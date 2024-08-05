package br.com.itb.miniprojeto3cspring.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.itb.miniprojeto3cspring.model.Produto;
import br.com.itb.miniprojeto3cspring.model.ProdutoRepository;
import jakarta.transaction.Transactional;

@Service
public class ProdutoService {
	
	// Criar objeto repository
	final ProdutoRepository produtoRepository;
	
	// Injeção de Dependência
	public ProdutoService(ProdutoRepository _produtoRepository) {
		this.produtoRepository = _produtoRepository;
	}
	
	// Método INSERT INTO PRODUTO
	@Transactional
	public Produto save(Produto _produto) {
		return produtoRepository.save(_produto);
	}
	
	// Método SELECT * FROM PRODUTO
	public List<Produto> findAll(){
		List<Produto> lista = produtoRepository.findAll();
		return lista;
	}
	
	
}
