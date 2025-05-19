package br.com.itb.miniprojetospring.model;

import br.com.itb.miniprojetospring.model.Ocorrencia;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OcorrenciaRepository extends JpaRepository<Ocorrencia, Long> {
    // Métodos personalizados podem ser adicionados aqui, caso necessário
}
