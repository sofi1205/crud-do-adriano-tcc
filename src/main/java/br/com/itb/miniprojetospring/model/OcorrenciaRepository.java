package br.com.itb.miniprojetospring.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OcorrenciaRepository
        extends JpaRepository<Ocorrencia, Long> {

    Ocorrencia findAllById(long id);
}
