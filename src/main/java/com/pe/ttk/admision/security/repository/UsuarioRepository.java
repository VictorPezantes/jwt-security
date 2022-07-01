package com.pe.ttk.admision.security.repository;

import java.util.Optional;

import com.pe.ttk.admision.security.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
	
	Optional<Usuario>findByNombreUsuario(String nombreUsuario);
	Optional<Usuario>findByNombreUsuarioOrEmail(String nombreUsuario,String email);
	boolean existsByNombreUsuario(String nombreUsuario);
	boolean existsByEmail(String email);
	Optional<Usuario>findByTokenPassword(String tokenPassword);
	
	

}
