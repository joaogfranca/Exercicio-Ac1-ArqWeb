package com.example.demo;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import com.example.demo.models.Categoria;
import com.example.demo.models.Produto;
import com.example.demo.repository.CategoriaRepository;
import com.example.demo.repository.ProdutoRepository;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner init(@Autowired ProdutoRepository produtoRepository,
			@Autowired CategoriaRepository categoriaRepository) {
		return args -> {

			Categoria c1 = new Categoria(1L, "Dispositivos Ópticos", "Objetos em função da visão");
			Categoria c2 = new Categoria(2L, "Alimentos", "Itens de origem alimentícia");
			Categoria c3 = new Categoria(3L, "Vestuário", "Itens para vestir o corpo");

			categoriaRepository.inserir(c1);
			categoriaRepository.inserir(c2);
			categoriaRepository.inserir(c3);

			Produto p1 = new Produto(1L, "Chinelo de madeira", 2, c3);
			Produto p2 = new Produto(2L, "Salgadinho de milho", 4, c2);
			Produto p3 = new Produto(3L, "Óculos de grau", 1, c1);

			produtoRepository.inserir(p1);
			produtoRepository.inserir(p2);
			produtoRepository.inserir(p3);

			produtoRepository.excluirProdutoPorId(1L);

			categoriaRepository.excluirCategoriaPorId(3L);

			List<Produto> listaDeProdutos = produtoRepository.obterTodos();
			listaDeProdutos.forEach(System.out::println);

			List<Categoria> listaDeCategorias = categoriaRepository.obterTodos();
			listaDeCategorias.forEach(System.out::println);

			// produtoRepository.obterProdutoPorId(2L);

			// categoriaRepository.obterCategoriaPorId(2L);
		};
	}
}
