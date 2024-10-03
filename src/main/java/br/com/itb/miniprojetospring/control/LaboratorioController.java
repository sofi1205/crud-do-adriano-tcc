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
	
	// criação do objeto de serviço
	final LaboratorioService laboratorioService;
	
	// Injeção de Dependência
	public LaboratorioController(LaboratorioService _laboratorioService) {
		this.laboratorioService = _laboratorioService;
	}
	
	// ROTA POST
	@PostMapping
	public ResponseEntity<Object> saveLaboratorio(@RequestBody Laboratorio laboratorio){
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(laboratorioService.save(laboratorio));
	}
	
	// ROTA GET
	@GetMapping
	public ResponseEntity<List<Laboratorio>> getAllLaboratorios(){
		return ResponseEntity.status(HttpStatus.OK)
				.body(laboratorioService.findAll());
	}

	@PutMapping
	public ResponseEntity<Object> updateLaboratorio(@RequestBody Laboratorio laboratorio){
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(laboratorioService.update(laboratorio));
	}
	
}
