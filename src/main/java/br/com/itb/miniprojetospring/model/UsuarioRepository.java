package br.com.itb.miniprojetospring.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository
	extends JpaRepository<Laboratorio, Long> {

	Laboratorio findAllById(long id);
}
