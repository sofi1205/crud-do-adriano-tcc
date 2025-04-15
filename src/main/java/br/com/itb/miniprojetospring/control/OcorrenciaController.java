package br.com.itb.miniprojetospring.control;

import br.com.itb.miniprojetospring.model.Ocorrencia;
import br.com.itb.miniprojetospring.model.OcorrenciaRepository;
import br.com.itb.miniprojetospring.model.Laboratorio;
import br.com.itb.miniprojetospring.model.LaboratorioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:5173", maxAge = 3600, allowCredentials = "false")
@RequestMapping("/ocorrencias")
public class OcorrenciaController {

    @Autowired
    private OcorrenciaRepository ocorrenciaRepository;

    @Autowired
    private LaboratorioRepository laboratorioRepository;

    // Método para buscar todas as ocorrências
    @GetMapping
    public List<Ocorrencia> getAllOcorrencias() {
        return ocorrenciaRepository.findAll();
    }

    // Método para salvar a ocorrência com o laboratório
    @PostMapping
    public Ocorrencia createOcorrencia(@RequestBody Ocorrencia ocorrencia) {
        // Encontrar o laboratório pelo ID
        Optional<Laboratorio> laboratorio = laboratorioRepository.findById(ocorrencia.getLaboratorio().getId());
        if (laboratorio.isPresent()) {
            ocorrencia.setLaboratorio(laboratorio.get());  // Atribuir o laboratório à ocorrência
        }
        return ocorrenciaRepository.save(ocorrencia);
    }
}
