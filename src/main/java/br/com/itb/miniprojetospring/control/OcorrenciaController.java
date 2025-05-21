package br.com.itb.miniprojetospring.control;

import br.com.itb.miniprojetospring.model.Ocorrencia;
import br.com.itb.miniprojetospring.service.OcorrenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/ocorrencias")
public class OcorrenciaController {

    @Autowired
    private OcorrenciaService ocorrenciaService;

    // Criar/Atualizar uma ocorrência
    @PostMapping("/upload")
    public String uploadOcorrencia(@RequestBody Ocorrencia ocorrencia) {
        try {
            // Definir a data de atendimento se não estiver definida
            if (ocorrencia.getDataAtendimento() == null) {
                ocorrencia.setDataAtendimento(LocalDateTime.now());
            }

            // Salvar ou atualizar a ocorrência
            ocorrencia.setStatus("PENDENTE");  // Status inicial como "PENDENTE"
            ocorrenciaService.save(ocorrencia);

            return "Ocorrência cadastrada com sucesso!";
        } catch (Exception e) {
            e.printStackTrace();
            return "Erro ao cadastrar/atualizar ocorrência: " + e.getMessage();
        }
    }

    // Consultar todas as ocorrências pendentes
    @GetMapping("/pendentes")
    public Iterable<Ocorrencia> getPendentes() {
        return ocorrenciaService.findPendentes();
    }

    // Consultar todas as ocorrências solucionadas
    @GetMapping("/solucionadas")
    public Iterable<Ocorrencia> getSolucionadas() {
        return ocorrenciaService.findSolucionadas();
    }

    // Consultar ocorrência por ID
    @GetMapping("/{id}")
    public Ocorrencia getOcorrenciaById(@PathVariable Long id) {
        return ocorrenciaService.findById(id);
    }

    // Deletar ocorrência por ID
    @DeleteMapping("/{id}")
    public String deleteOcorrencia(@PathVariable Long id) {
        try {
            ocorrenciaService.delete(id);
            return "Ocorrência deletada com sucesso!";
        } catch (Exception e) {
            return "Erro ao deletar ocorrência: " + e.getMessage();
        }
    }

    // Atualizar status da ocorrência para 'SOLUCIONADA'
    @PutMapping("/{id}/marcar-lida")
    public String marcarComoSolucionada(@PathVariable Long id) {
        try {
            ocorrenciaService.marcarComoSolucionada(id);
            return "Ocorrência marcada como solucionada!";
        } catch (Exception e) {
            return "Erro ao marcar ocorrência como solucionada: " + e.getMessage();
        }
    }
}
