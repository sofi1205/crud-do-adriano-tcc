package br.com.itb.miniprojetospring.model;
import java.util.List;  //
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LaboratorioRepository
	extends JpaRepository<Laboratorio, Long> {

	List<Laboratorio> findBySalaAndAndar(String sala, String andar);
	Laboratorio findAllById(long id);
}
