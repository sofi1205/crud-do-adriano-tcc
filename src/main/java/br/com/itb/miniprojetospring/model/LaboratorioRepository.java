package br.com.itb.miniprojetospring.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LaboratorioRepository extends JpaRepository<Laboratorio, Long> {

	List<Laboratorio> findAll();  // Método para listar todos os laboratórios


	// Verifica se existe laboratório com a mesma sala e andar
	boolean existsBySalaAndAndar(String sala, String andar);
}
