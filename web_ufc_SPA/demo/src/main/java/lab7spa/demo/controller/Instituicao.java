package lab7spa.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import lab7spa.demo.service.TurmaService;

@RestController
public class Instituicao {
    @Autowired
	TurmaService turmaService;

	@GetMapping("/api/turma")
	List<Produto> getTurmaList(){
		return turmaService.getTurmaList();
	}

	@PostMapping("/api/produto")
	void addProduto(@RequestBody Produto produto) {
		produtoService.addProduto(produto);
	}
}

