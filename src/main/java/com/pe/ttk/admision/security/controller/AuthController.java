package com.pe.ttk.admision.security.controller;

import com.pe.ttk.admision.dto.Mensaje;
import com.pe.ttk.admision.security.dto.JwtDto;
import com.pe.ttk.admision.security.dto.LoginUsuario;
import com.pe.ttk.admision.security.dto.NuevoUsuario;
import com.pe.ttk.admision.security.dto.UsuarioDto;
import com.pe.ttk.admision.security.entity.Rol;
import com.pe.ttk.admision.security.entity.Usuario;
import com.pe.ttk.admision.security.enums.RolNombre;
import com.pe.ttk.admision.security.jwt.JwtProvider;
import com.pe.ttk.admision.security.service.RolService;
import com.pe.ttk.admision.security.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/auth")
@CrossOrigin
public class AuthController {

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UsuarioService usuarioService;

    @Autowired
    RolService rolService;

    @Autowired
    JwtProvider jwtProvider;

    private final Path rootFolder = Paths.get("archivos/Empleado");

    @PostMapping("/nuevo")
    public ResponseEntity<?> nuevo(@RequestParam(name = "foto", required = false) MultipartFile foto,
                                   @Valid  NuevoUsuario nuevoUsuario,
                                   BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return new ResponseEntity(new Mensaje("campos mal puestos o email inválido"), HttpStatus.BAD_REQUEST);
        if (usuarioService.existsByNombreUsuario(nuevoUsuario.getNombreUsuario()))
            return new ResponseEntity(new Mensaje("ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        if (usuarioService.existsByEmail(nuevoUsuario.getEmail()))
            return new ResponseEntity(new Mensaje("ese email ya existe"), HttpStatus.BAD_REQUEST);

        try {
            Files.copy(foto.getInputStream(), this.rootFolder.resolve(foto.getOriginalFilename()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Usuario usuario =
                new Usuario(nuevoUsuario.getNombre(), nuevoUsuario.getNombreUsuario(), nuevoUsuario.getEmail(),
                        passwordEncoder.encode(nuevoUsuario.getPassword()),foto.getOriginalFilename());
        Path rutaRelativa = Paths.get(foto.getOriginalFilename());
        Path rutaAbsoluta = rutaRelativa.toAbsolutePath();



        usuario.setFotografia(rutaAbsoluta.toString());

        Set<Rol> roles = new HashSet<>();
        roles.add(rolService.getByRolNombre(RolNombre.ROLE_USER).get());
        if (nuevoUsuario.getRoles().contains("admin"))
            roles.add(rolService.getByRolNombre(RolNombre.ROLE_ADMIN).get());
        usuario.setRoles(roles);
        usuarioService.save(usuario);
        return new ResponseEntity(new Mensaje("usuario guardado"), HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<JwtDto> login(@Valid @RequestBody LoginUsuario loginUsuario, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return new ResponseEntity(new Mensaje("campos mal puestos"), HttpStatus.BAD_REQUEST);
        Authentication authentication =
                authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginUsuario.getNombreUsuario(), loginUsuario.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtProvider.generateToken(authentication);
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        JwtDto jwtDto = new JwtDto(jwt, userDetails.getUsername(), userDetails.getAuthorities());
        return new ResponseEntity(jwtDto, HttpStatus.OK);
    }

    @PostMapping("/refresh")
    public ResponseEntity<JwtDto> refresh(@RequestBody JwtDto jwtDto) throws ParseException {
        String token = jwtProvider.refreshToken(jwtDto);
        JwtDto jwt = new JwtDto(token);
        return new ResponseEntity(jwt, HttpStatus.OK);
    }

    @GetMapping(value = "/usuario", produces = "application/json")
    public ResponseEntity<?> datosUsuario(Authentication auth) {
        String username = auth.getName();

        Usuario usuario = usuarioService.getByNombreUsuario(username).get();
        UsuarioDto usuarioDto = new UsuarioDto();

        usuarioDto.setEmail(usuario.getEmail());
        usuarioDto.setNombreUsuario(usuario.getNombreUsuario());
        usuarioDto.setNombre(usuario.getNombre());
        usuarioDto.setFotografia(usuario.getFotografia());
        usuarioDto.setRoles(usuario.getRoles());


        return new ResponseEntity(usuarioDto, HttpStatus.OK);
    }
}

