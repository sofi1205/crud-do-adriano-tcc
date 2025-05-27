package br.com.itb.miniprojetospring.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;


@Repository
public interface TecnicoRepository
        extends JpaRepository<Tecnico, Long> {
    Optional<Tecnico> findByrmtecnico(String rmtecnico);


}
