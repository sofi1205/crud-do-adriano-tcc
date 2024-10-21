package br.com.itb.miniprojetospring.control;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.itb.miniprojetospring.model.Laboratorio;
import br.com.itb.miniprojetospring.service.LaboratorioService;

@RestController
@CrossOrigin(origins="*", maxAge = 3600, allowCredentials = "false")
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

	// ROTA PUT (Atualizar laboratório existente)
	@PutMapping("/{id}")
	public ResponseEntity<Object> updateLaboratorio(@PathVariable Long id, @RequestBody Laboratorio laboratorioDetails) {
		if (laboratorioService.isLaboratorioDuplicado(laboratorioDetails.getSala(), laboratorioDetails.getAndar())) {
			return ResponseEntity.status(HttpStatus.CONFLICT)
					.body("Já existe um laboratório com essa sala e andar.");
		}
		return ResponseEntity.status(HttpStatus.OK)
				.body(laboratorioService.update(id, laboratorioDetails));
	}
}
