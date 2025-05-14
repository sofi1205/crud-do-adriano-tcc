import br.com.itb.miniprojetospring.model.Laboratorio;
import br.com.itb.miniprojetospring.model.LaboratorioRepository;
import br.com.itb.miniprojetospring.model.Ocorrencia;
import br.com.itb.miniprojetospring.model.OcorrenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDate;
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

    @GetMapping
    public List<Ocorrencia> getAllOcorrencias() {
        return ocorrenciaRepository.findAll();
    }

    // Novo endpoint com upload de arquivo
    @PostMapping("/upload")
    public Ocorrencia uploadOcorrencia(
            @RequestParam("descricao") String descricao,
            @RequestParam("patrimonio") String patrimonio,
            @RequestParam("laboratorioId") long laboratorioId,
            @RequestParam(value = "anexo", required = false) MultipartFile anexoFile
    ) throws IOException {

        Optional<Laboratorio> laboratorio = laboratorioRepository.findById(laboratorioId);
        if (!laboratorio.isPresent()) {
            throw new RuntimeException("Laboratório não encontrado");
        }

        Ocorrencia ocorrencia = new Ocorrencia();
        ocorrencia.setDescricao(descricao);
        ocorrencia.setPatrimonio(patrimonio);
        ocorrencia.setLaboratorio(laboratorio.get());
        ocorrencia.setDataAbertura(LocalDate.now().toString());
        ocorrencia.setStatusOcorrencia("Pendente");

        if (anexoFile != null && !anexoFile.isEmpty()) {
            ocorrencia.setAnexo(anexoFile.getBytes());
        }

        return ocorrenciaRepository.save(ocorrencia);
    }
}
