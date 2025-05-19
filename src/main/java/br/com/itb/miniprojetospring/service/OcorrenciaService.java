package br.com.itb.miniprojetospring.service;

import br.com.itb.miniprojetospring.model.Ocorrencia;
import br.com.itb.miniprojetospring.model.OcorrenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OcorrenciaService {

    @Autowired
    private OcorrenciaRepository ocorrenciaRepository;

    // Salvar ou atualizar a ocorrência
    public void save(Ocorrencia ocorrencia) {
        ocorrenciaRepository.save(ocorrencia);
    }

    // Buscar ocorrência por ID
    public Ocorrencia findById(Long id) {
        Optional<Ocorrencia> ocorrencia = ocorrenciaRepository.findById(id);
        return ocorrencia.orElse(null);  // Retorna null se não encontrar
    }

    // Buscar todas as ocorrências
    public Iterable<Ocorrencia> findAll() {
        return ocorrenciaRepository.findAll();
    }

    // Deletar ocorrência por ID
    public void delete(Long id) {
        ocorrenciaRepository.deleteById(id);
    }
}
