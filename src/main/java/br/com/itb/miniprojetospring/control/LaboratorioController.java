package br.com.itb.miniprojetospring.control;

import br.com.itb.miniprojetospring.model.Laboratorio;
import br.com.itb.miniprojetospring.model.LaboratorioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
}
