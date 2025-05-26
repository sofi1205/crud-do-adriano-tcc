package br.com.itb.miniprojetospring.control;

import br.com.itb.miniprojetospring.model.Tecnico;
import br.com.itb.miniprojetospring.model.TecnicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<?> cadastrar(@RequestBody Tecnico tecnico) {
        Optional<Tecnico> tecnicoExistente = tecnicoRepository.findByrmtecnico(tecnico.getRmtecnico());

        if (tecnicoExistente.isPresent()) {
            return ResponseEntity
                    .badRequest()
                    .body("RM já cadastrado. Tente outro.");
        }

        Tecnico novoTecnico = tecnicoRepository.save(tecnico);
        return ResponseEntity.ok(novoTecnico);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Tecnico tecnico) {
        Optional<Tecnico> tecnicoExistente = tecnicoRepository.findByrmtecnico(tecnico.getRmtecnico());

        if (tecnicoExistente.isPresent()) {
            Tecnico t = tecnicoExistente.get();
            if (t.getSenha().equals(tecnico.getSenha())) {
                return ResponseEntity.ok(t); // login OK, retorna os dados do técnico
            } else {
                return ResponseEntity.status(401).body("Senha incorreta");
            }
        } else {
            return ResponseEntity.status(401).body("RM não cadastrado");
        }
    }


    // ATUALIZAR técnico
    @PutMapping("/{id}")
    public Tecnico atualizar(@PathVariable Long id, @RequestBody Tecnico tecnicoAtualizado) {
        return tecnicoRepository.findById(id).map(tecnico -> {
            tecnico.setRmtecnico(tecnicoAtualizado.getRmtecnico());
            tecnico.setSenha(tecnicoAtualizado.getSenha());
            tecnico.setAdmin(tecnicoAtualizado.isAdmin());
            return tecnicoRepository.save(tecnico);
        }).orElseGet(() -> {
            return tecnicoRepository.save(tecnicoAtualizado);
        });
    }

    // DELETAR técnico
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        tecnicoRepository.deleteById(id);
    }
}
