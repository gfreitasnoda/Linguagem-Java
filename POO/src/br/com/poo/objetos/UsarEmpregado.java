package br.com.poo.objetos;

import br.com.poo.classes.Empregado;
import br.com.poo.classes.Setor;

public class UsarEmpregado {

	public static void main(String[] args) {
		
			Empregado wagner = new Empregado();
			
			wagner.salvar();
			
			System.out.println(wagner.salvar());
			wagner.mensagem("Olá Wagner");
			
			Setor vendas = new Setor();
			System.out.println(vendas.salvar());
			
			vendas.mensagem("Novo setor para empresa");
			
	}

}
