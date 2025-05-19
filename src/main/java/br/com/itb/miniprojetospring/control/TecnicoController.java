package br.com.itb.miniprojetospring.control;

import br.com.itb.miniprojetospring.model.Tecnico;
import br.com.itb.miniprojetospring.model.TecnicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tecnicos")
@CrossOrigin(origins = "*")
public class TecnicoController {

    @Autowired
    private TecnicoRepository tecnicoRepository;

    // LISTAR todos os técnicos
    @GetMapping
    public List<Tecnico> listarTodos() {
        return tecnicoRepository.findAll();
    }

    // BUSCAR por ID
    @GetMapping("/{id}")
    public Optional<Tecnico> buscarPorId(@PathVariable Long id) {
        return tecnicoRepository.findById(id);
    }

    // CADASTRAR novo técnico
    @PostMapping
    public Tecnico cadastrar(@RequestBody Tecnico tecnico) {
        return tecnicoRepository.save(tecnico);
    }

    // ATUALIZAR técnico
    @PutMapping("/{id}")
    public Tecnico atualizar(@PathVariable Long id, @RequestBody Tecnico tecnicoAtualizado) {
        return tecnicoRepository.findById(id).map(tecnico -> {
            tecnico.setRmtecnico(tecnicoAtualizado.getRmtecnico());
            tecnico.setSenha(tecnicoAtualizado.getSenha());
            tecnico.setAdmin(tecnicoAtualizado.isAdmin());
            tecnico.setIdOcorrencia(tecnicoAtualizado.getIdOcorrencia());
            return tecnicoRepository.save(tecnico);
        }).orElseGet(() -> {
            tecnicoAtualizado.setIdOcorrencia(id);
            return tecnicoRepository.save(tecnicoAtualizado);
        });
    }

    // DELETAR técnico
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        tecnicoRepository.deleteById(id);
    }
}
