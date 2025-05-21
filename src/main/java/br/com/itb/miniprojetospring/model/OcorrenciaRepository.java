package br.com.itb.miniprojetospring.model;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OcorrenciaRepository extends JpaRepository<Ocorrencia, Long> {

    // Consultar ocorrências com status "PENDENTE"
    Iterable<Ocorrencia> findByStatus(String status);
}
