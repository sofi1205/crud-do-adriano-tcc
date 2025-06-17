package br.com.itb.miniprojetospring.control;

import br.com.itb.miniprojetospring.model.Tecnico;
import br.com.itb.miniprojetospring.model.TecnicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/tecnicos")  // Alterado para garantir que a URL tenha o prefixo "/api"
@CrossOrigin(origins = "*")  // Permite requisições de qualquer origem (ajustar conforme necessário)
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
    public ResponseEntity<Tecnico> buscarPorId(@PathVariable Long id) {
        Optional<Tecnico> tecnico = tecnicoRepository.findById(id);
        if (tecnico.isPresent()) {
            return ResponseEntity.ok(tecnico.get());  // Retorna o técnico encontrado
        } else {
            return ResponseEntity.notFound().build();  // Retorna 404 caso não encontrado
        }
    }

    // CADASTRAR novo técnico
    @PostMapping
    public ResponseEntity<?> cadastrar(@RequestBody Tecnico tecnico) {
        // Verifica se o RM já está cadastrado
        Optional<Tecnico> tecnicoExistente = tecnicoRepository.findByrmtecnico(tecnico.getRmtecnico());

        if (tecnicoExistente.isPresent()) {
            return ResponseEntity
                    .badRequest()
                    .body("RM já cadastrado. Tente outro.");  // Retorna erro se RM já estiver cadastrado
        }

        Tecnico novoTecnico = tecnicoRepository.save(tecnico);
        return ResponseEntity.ok(novoTecnico);  // Retorna o técnico cadastrado
    }

    // LOGIN de técnico
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Tecnico tecnico) {
        Optional<Tecnico> tecnicoExistente = tecnicoRepository.findByrmtecnico(tecnico.getRmtecnico());

        if (tecnicoExistente.isPresent()) {
            Tecnico t = tecnicoExistente.get();
            if (t.getSenha().equals(tecnico.getSenha())) {
                return ResponseEntity.ok(t);  // Retorna os dados do técnico se o login for bem-sucedido
            } else {
                return ResponseEntity.status(401).body("Senha incorreta");  // Retorna erro de senha incorreta
            }
        } else {
            return ResponseEntity.status(401).body("RM não cadastrado");  // Retorna erro de RM não cadastrado
        }
    }

    // ATUALIZAR técnico
    @PutMapping("/{id}")
    public ResponseEntity<Tecnico> atualizar(@PathVariable Long id, @RequestBody Tecnico tecnicoAtualizado) {
        Optional<Tecnico> tecnicoExistente = tecnicoRepository.findById(id);

        if (tecnicoExistente.isPresent()) {
            Tecnico tecnico = tecnicoExistente.get();
            // Atualiza os dados do técnico
            tecnico.setRmtecnico(tecnicoAtualizado.getRmtecnico());
            tecnico.setSenha(tecnicoAtualizado.getSenha());
            tecnico.setAdmin(tecnicoAtualizado.isAdmin());
            return ResponseEntity.ok(tecnicoRepository.save(tecnico));  // Retorna o técnico atualizado
        } else {
            return ResponseEntity.notFound().build();  // Retorna 404 caso o técnico não seja encontrado
        }
    }

    // DELETAR técnico
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        Optional<Tecnico> tecnico = tecnicoRepository.findById(id);
        if (tecnico.isPresent()) {
            tecnicoRepository.deleteById(id);
            return ResponseEntity.noContent().build();  // Retorna 204 No Content após a exclusão
        } else {
            return ResponseEntity.notFound().build();  // Retorna 404 se o técnico não for encontrado
        }
    }
}
