package com.pe.ttk.admision.security.service;

import java.util.Optional;

import com.pe.ttk.admision.security.entity.Usuario;
import com.pe.ttk.admision.security.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UsuarioService {
	@Autowired
    UsuarioRepository usuarioRepository;

	public Optional<Usuario> getByNombreUsuario(String nombreUsuario) {
		return usuarioRepository.findByNombreUsuario(nombreUsuario);

	}
	
	public Optional<Usuario> getByNombreUsuarioOrEmail(String nombreOrEmail) {
		return usuarioRepository.findByNombreUsuarioOrEmail(nombreOrEmail, nombreOrEmail);

	}



	public boolean existsByNombreUsuario(String nombreUsuario) {

		return usuarioRepository.existsByNombreUsuario(nombreUsuario);
	}

	public boolean existsByEmail(String email) {

		return usuarioRepository.existsByEmail(email);
	}
	
	public void save(Usuario usuario) {
		usuarioRepository.save(usuario);
	}
	
	public Optional<Usuario> getByTokenPassword(String tokenPassword) {
		return usuarioRepository.findByTokenPassword(tokenPassword);

	}


}
