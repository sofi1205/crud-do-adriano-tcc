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
            // Verificar se a dataAtendimento está nula e definir com a data e hora atual
            if (ocorrencia.getDataAtendimento() == null) {
                ocorrencia.setDataAtendimento(LocalDateTime.now());
            }

            // Salvar ou atualizar a ocorrência
            ocorrenciaService.save(ocorrencia);

            return "Ocorrência cadastrada/atualizada com sucesso!";
        } catch (Exception e) {
            e.printStackTrace();
            return "Erro ao cadastrar/atualizar ocorrência: " + e.getMessage();
        }
    }

    // Consultar ocorrência por ID
    @GetMapping("/{id}")
    public Ocorrencia getOcorrenciaById(@PathVariable Long id) {
        return ocorrenciaService.findById(id);
    }

    // Listar todas as ocorrências
    @GetMapping
    public Iterable<Ocorrencia> getAllOcorrencias() {
        return ocorrenciaService.findAll();
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

    // Atualizar status de ocorrência para 'lida'
    @PutMapping("/{id}/marcar-lida")
    public String marcarComoLida(@PathVariable Long id) {
        try {
            Ocorrencia ocorrencia = ocorrenciaService.findById(id);
            if (ocorrencia != null) {
                ocorrencia.setLida(true);  // Marca como 'lida'
                ocorrenciaService.save(ocorrencia);  // Atualiza no banco
                return "Ocorrência marcada como lida!";
            }
            return "Ocorrência não encontrada!";
        } catch (Exception e) {
            return "Erro ao marcar ocorrência como lida: " + e.getMessage();
        }
    }
}
