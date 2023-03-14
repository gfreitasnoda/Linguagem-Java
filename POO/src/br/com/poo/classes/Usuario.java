package br.com.poo.classes;


// Essa classe é destinada a criação de novos usuários

public class Usuario {
		
		// Atributos da classe
		public int id;
		public String nomeUsuario;
		public String senha;
		public String[] grupo;
		
		public void cadastrar() {
			System.out.println("O usuário "+ nomeUsuario+ " foi cadastrado ");
		}
		
		public void listarUsuario() {
				System.out.println("\nId Usuario: "+id +"\nNome: "+nomeUsuario +"\nGrupo: "+grupo );
		}
}
