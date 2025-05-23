package br.com.itb.miniprojetospring.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.itb.miniprojetospring.model.Laboratorio;
import br.com.itb.miniprojetospring.model.LaboratorioRepository;
import jakarta.transaction.Transactional;

@Service
public class LaboratorioService {

	final LaboratorioRepository laboratorioRepository;

	public LaboratorioService(LaboratorioRepository _laboratorioRepository) {
		this.laboratorioRepository = _laboratorioRepository;
	}

	// Método para salvar laboratório
	@Transactional
	public Laboratorio save(Laboratorio _laboratorio) {
		return laboratorioRepository.save(_laboratorio);
	}

	// Método para encontrar todos os laboratórios
	public List<Laboratorio> findAll() {
		return laboratorioRepository.findAll();
	}

	// Método para encontrar laboratório por ID
	public Laboratorio findById(long id) {
		return laboratorioRepository.findById(id).orElseThrow(() -> new RuntimeException("Laboratório não encontrado"));
	}

	// Método para atualizar laboratório
	@Transactional
	public Laboratorio update(Long id, Laboratorio laboratorioDetails) {
		Laboratorio laboratorio = findById(id);
		laboratorio.setSala(laboratorioDetails.getSala());
		laboratorio.setAndar(laboratorioDetails.getAndar());
		return laboratorioRepository.save(laboratorio);
	}

	// Método para verificar duplicidade de laboratório
	public boolean isLaboratorioDuplicado(String sala, String andar) {
		return laboratorioRepository.existsBySalaAndAndar(sala, andar);
	}

	public void deleteById(Long id) {
		laboratorioRepository.deleteById(id);
	}

	public boolean existsById(Long id) {
		return laboratorioRepository.existsById(id);
	}
}
