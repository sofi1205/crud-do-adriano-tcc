package br.com.itb.miniprojetospring.control;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.itb.miniprojetospring.model.Laboratorio;
import br.com.itb.miniprojetospring.service.LaboratorioService;

@RestController
@CrossOrigin(origins="http://localhost:5173", maxAge = 3600, allowCredentials = "false")
@RequestMapping("/laboratorio")
public class LaboratorioController {


	final LaboratorioService laboratorioService;

	public LaboratorioController(LaboratorioService _laboratorioService) {
		this.laboratorioService = _laboratorioService;
	}

	// ROTA POST (Criar novo laboratório)
	@PostMapping
	public ResponseEntity<Object> saveLaboratorio(@RequestBody Laboratorio laboratorio) {
		if (laboratorioService.isLaboratorioDuplicado(laboratorio.getSala(), laboratorio.getAndar())) {
			return ResponseEntity.status(HttpStatus.CONFLICT)
					.body("Já existe um laboratório com essa sala e andar.");
		}
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(laboratorioService.save(laboratorio));
	}

	// ROTA GET (Obter todos os laboratórios)
	@GetMapping
	public ResponseEntity<List<Laboratorio>> getAllLaboratorios() {
		return ResponseEntity.status(HttpStatus.OK)
				.body(laboratorioService.findAll());
	}

	// Método para buscar laboratório por ID
	@GetMapping("/findById/{id}")
	public ResponseEntity<Laboratorio> findById(@PathVariable Long id) {
		Optional<Laboratorio> laboratorio = Optional.ofNullable(laboratorioService.findById(id));
		return laboratorio.map(ResponseEntity::ok)
				.orElseGet(() -> ResponseEntity.notFound().build());
	}

	@GetMapping("/verificarDuplicidade")
	public ResponseEntity<Boolean> verificarDuplicidade(@RequestParam String sala, @RequestParam String andar) {
		boolean isDuplicated = laboratorioService.isLaboratorioDuplicado(sala, andar);
		return new ResponseEntity<>(isDuplicated, HttpStatus.OK);
	}

	// Método para atualizar laboratório
	@PutMapping("/{id}")
	public ResponseEntity<Object> updateLaboratorio(@PathVariable Long id, @RequestBody Laboratorio laboratorioDetails) {
		if (laboratorioService.isLaboratorioDuplicado(laboratorioDetails.getSala(), laboratorioDetails.getAndar())) {
			return ResponseEntity.status(HttpStatus.CONFLICT)
					.body("Já existe um laboratório com essa sala e andar.");
		}
		return ResponseEntity.status(HttpStatus.OK)
				.body(laboratorioService.update(id, laboratorioDetails));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		if (laboratorioService.existsById(id)) {
			laboratorioService.deleteById(id);
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.notFound().build();
		}
}
}
