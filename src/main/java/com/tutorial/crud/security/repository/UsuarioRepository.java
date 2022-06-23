package com.tutorial.crud.security.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tutorial.crud.security.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
	
	Optional<Usuario>findByNombreUsuario(String nombreUsuario);
	Optional<Usuario>findByNombreUsuarioOrEmail(String nombreUsuario,String email);
	boolean existsByNombreUsuario(String nombreUsuario);
	boolean existsByEmail(String email);
	Optional<Usuario>findByTokenPassword(String tokenPassword);
	
	

}
