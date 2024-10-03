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
	public Laboratorio update(Laboratorio _laboratorio) {
		Laboratorio laboratorioEncontrado = laboratorioRepository.findAllById(_laboratorio.getId());
		if(laboratorioEncontrado.getId() > 0)
			return laboratorioRepository.save(_laboratorio);
		else
			return new Laboratorio(0, "Laboratório não encontrado");
	}

}
