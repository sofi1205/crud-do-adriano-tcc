package br.com.itb.miniprojeto3cspring.control;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.itb.miniprojeto3cspring.model.Produto;
import br.com.itb.miniprojeto3cspring.service.ProdutoService;

@RestController
@CrossOrigin(origins="*", maxAge = 3600, allowCredentials = "false")
@RequestMapping("/produto")
public class ProdutoController {
	
	// criação do objeto de serviço
	final ProdutoService produtoService;
	
	// Injeção de Dependência
	public ProdutoController(ProdutoService _produtoService) {
		this.produtoService = _produtoService;
	}
	
	// ROTA POST
	@PostMapping
	public ResponseEntity<Object> saveProduto(Produto produto){
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(produtoService.save(produto));
	}
	
	// ROTA GET
	@GetMapping
	public ResponseEntity<List<Produto>> getAllProdutos(){
		return ResponseEntity.status(HttpStatus.OK)
				.body(produtoService.findAll());
	}
	
	
	
}
