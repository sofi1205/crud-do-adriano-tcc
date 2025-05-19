package br.com.itb.miniprojetospring.control;

import br.com.itb.miniprojetospring.model.Laboratorio;
import br.com.itb.miniprojetospring.model.LaboratorioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/laboratorio")
public class LaboratorioController {

	@Autowired
	private LaboratorioRepository laboratorioRepository;

	// GET: lista todos os laboratórios
	@GetMapping
	public List<Laboratorio> getAll() {
		return laboratorioRepository.findAll();
	}

	// POST: salva um novo laboratório
	@PostMapping
	public Laboratorio create(@RequestBody Laboratorio laboratorio) {
		return laboratorioRepository.save(laboratorio);
	}

	// PUT: atualiza um laboratório existente
	@PutMapping("/{id}")
	public ResponseEntity<Laboratorio> update(@PathVariable Long id, @RequestBody Laboratorio novoLab) {
		return laboratorioRepository.findById(id)
				.map(lab -> {
					lab.setSala(novoLab.getSala());
					lab.setAndar(novoLab.getAndar());
					Laboratorio atualizado = laboratorioRepository.save(lab);
					return ResponseEntity.ok(atualizado);
				})
				.orElse(ResponseEntity.notFound().build());
	}

	// DELETE: deleta um laboratório por ID
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		laboratorioRepository.deleteById(id);
	}

	// Verifica se o laboratório é duplicado (mesma sala e andar)
	@GetMapping("/verificarDuplicidade")
	public boolean verificarDuplicidade(@RequestParam String sala, @RequestParam String andar) {
		return laboratorioRepository.existsBySalaAndAndar(sala, andar);
	}

	// Busca laboratório por ID
	@GetMapping("/findById/{id}")
	public ResponseEntity<Laboratorio> getById(@PathVariable Long id) {
		return laboratorioRepository.findById(id)
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}
}
