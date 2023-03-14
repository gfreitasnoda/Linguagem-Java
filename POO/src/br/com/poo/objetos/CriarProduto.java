package br.com.poo.objetos;

import br.com.poo.classes.Produto;

public class CriarProduto {

	public static void main(String[] args) {
		// Criando o objeto produto
			Produto prod = new Produto();
			prod.setId(10);
			prod.setNome("Sabonete");
			prod.cadastrar();
			prod.listar();
	}

}
