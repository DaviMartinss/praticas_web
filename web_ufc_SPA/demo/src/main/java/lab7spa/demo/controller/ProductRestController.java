package lab7spa.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lab7spa.demo.service.ProdutoService;


@RestController
public class ProductRestController {

	@Autowired
	ProdutoService produtoService;

	@GetMapping("/api/produto")
	List<Produto> getProdutos(){
		return produtoService.getProdutos();
	}

	@PostMapping("/api/produto")
	void addProduto(@RequestBody Produto produto) {
		produtoService.addProduto(produto);
	}
}

