package br.com.poo.classes.heranca;

public abstract class Pessoa {
	
//Atributos classe Pessoa
	private int id;
	private String email;
//construtor classe Pessoa
	public Pessoa() {}
//construtor classe Pessoa com argumentos
	public Pessoa(int id, String email) {
		this.id = id;
		this.email = email;
	}
	//Gerar metodos de acesso get set
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	

}
