package lab7spa.demo.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import lab7spa.demo.controller.Produto;

@Service
public class ProdutoService {
	
	private List<Produto> produtos = new ArrayList<Produto>();
	
	public ProdutoService() {
		produtos.addAll(Arrays.asList(new Produto(1, "Livro", 200f), new Produto(1, "Laptop", 938752.67f), new Produto(3, "Bicicleta", 12400f)));
	}
	
	public List<Produto> getProdutos() {
		return produtos;
	}

	public void addProduto(Produto produto) {
		produtos.add(produto);
	}

}