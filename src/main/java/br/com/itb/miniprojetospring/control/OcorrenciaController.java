package br.com.itb.miniprojetospring.control;

import br.com.itb.miniprojetospring.model.Ocorrencia;
import br.com.itb.miniprojetospring.model.OcorrenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@CrossOrigin(origins="http://localhost:5173", maxAge = 3600, allowCredentials = "false")
@RequestMapping("/ocorrencias")

public class OcorrenciaController {

    @Autowired
    private OcorrenciaRepository ocorrenciaRepository;

    @GetMapping
    public List<Ocorrencia> getAllOcorrencias() {
        return ocorrenciaRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ocorrencia> getOcorrenciaById(@PathVariable int id) {
        Optional<Ocorrencia> ocorrencia = ocorrenciaRepository.findById(id);
        return ocorrencia.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Ocorrencia createOcorrencia(@RequestBody Ocorrencia ocorrencia) {
        return ocorrenciaRepository.save(ocorrencia);
    }





    @PutMapping("/{id}")
    public ResponseEntity<Ocorrencia> updateOcorrencia(@PathVariable long id, @RequestBody Ocorrencia ocorrenciaDetails) {
        return ocorrenciaRepository.findById(id).map(ocorrencia -> {
            ocorrencia.setDescricao(ocorrenciaDetails.getDescricao());
            ocorrencia.setAnexo(ocorrenciaDetails.getAnexo());
            ocorrencia.setDataAbertura(ocorrenciaDetails.getDataAbertura());
            ocorrencia.setDataAtendimento(ocorrenciaDetails.getDataAtendimento());
            ocorrencia.setStatusOcorrencia(ocorrenciaDetails.getStatusOcorrencia());
            ocorrencia.setPatrimonio(ocorrenciaDetails.getPatrimonio());
            return ResponseEntity.ok(ocorrenciaRepository.save(ocorrencia));
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteOcorrencia(@PathVariable long id) {
        return ocorrenciaRepository.findById(id).map(ocorrencia -> {
            ocorrenciaRepository.delete(ocorrencia);
            return ResponseEntity.noContent().build();
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
