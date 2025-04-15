package br.com.itb.miniprojetospring.control;

import br.com.itb.miniprojetospring.model.Laboratorio;
import br.com.itb.miniprojetospring.model.LaboratorioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/laboratorio")
public class LaboratorioController {

	@Autowired
	private LaboratorioRepository laboratorioRepository;

	// Método para retornar todos os laboratórios
	@GetMapping
	public List<Laboratorio> getAllLaboratorios() {
		return laboratorioRepository.findAll();  // Retorna todos os laboratórios
	}
}
