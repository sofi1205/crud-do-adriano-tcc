package br.com.itb.miniprojetospring.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.itb.miniprojetospring.model.Laboratorio;
import br.com.itb.miniprojetospring.model.LaboratorioRepository;
import jakarta.transaction.Transactional;

@Service
public class LaboratorioService {
	
	// Criar objeto repositoryg
	final LaboratorioRepository laboratorioRepository;
	
	// Injeção de Dependência
	public LaboratorioService(LaboratorioRepository _laboratorioRepository) {
		this.laboratorioRepository = _laboratorioRepository;
	}

	
	// Método INSERT INTO PRODUTO
	@Transactional
	public Laboratorio save(Laboratorio _laboratorio) {
		return laboratorioRepository.save(_laboratorio);
	}
	
	// Método SELECT * FROM PRODUTO
	public List<Laboratorio> findAll(){
		List<Laboratorio> lista = laboratorioRepository.findAll();
		return lista;
	}

	public Laboratorio findAllById(long id){
		Laboratorio laboratorioEncontrado = laboratorioRepository.findAllById(id);
		return laboratorioEncontrado;
	}

	@Transactional
	public Laboratorio update(Long id, Laboratorio laboratorio) {
		Laboratorio laboratorioEncontrado = laboratorioRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Laboratório não encontrado"));

		// Verifica se já existe um laboratório com a mesma sala e andar, mas com id diferente
		boolean exists = laboratorioRepository.findAll().stream()
				.anyMatch(lab -> lab.getSala().equals(laboratorio.getSala())
						&& lab.getAndar().equals(laboratorio.getAndar())
						&& lab.getId() != id); // Garantir que não está comparando o mesmo id

		if (exists) {
			throw new RuntimeException("Já existe um laboratório com a mesma sala e andar.");
		}

		laboratorioEncontrado.setSala(laboratorio.getSala());
		laboratorioEncontrado.setAndar(laboratorio.getAndar());

		return laboratorioRepository.save(laboratorioEncontrado);
	}






}

