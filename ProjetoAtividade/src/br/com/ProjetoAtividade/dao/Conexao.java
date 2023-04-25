package br.com.ProjetoAtividade.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * A classe Conexão é destinada a abrir conexão com o banco de dados<br>
 * Nesta classe você encontrará os seguintes métodos:<br>
 * <ul>
 * 	<li><b>abrirConexao:<b> Abre a conexão com o banco atividade<li>
 * 	<li><b>fecharConexao></b> Fecha a conexão com o banco atividade<li>
 * 	</ul>
 * @author Nicolas Souza
 *
 */

public abstract class Conexao {

	/*
	 * As propriedades (Atributos) da classe Conexao foram setados como
	 * protected, pois haverá um processo de herança desta classe e assim
	 * será possível passar os dados para as subclasses(classes filhas).
	 * O comando Connection é uma classe que permite estabelecer a conexão
	 * com o banco de dados. Foi setado para está classe a variável
	 * conn com o valor inicial nulo. Assim ela começa com algo e depois
	 * será instânciada.
	 * Já o comando PreparedStatement é utilizado para executar os comandos
	 * de SQL, tais como: Insert, Update, Select, Delete, dentre
	 * outros. A variável do prepared foi criada como pst e seu valor
	 * inicial é null.
	 * O comando ResultSet é destinado a guardar os resultados do comando
	 * Select do mysql. A variável rs foi inicializada com o valor null
	 */
	
	
	protected Connection conn = null;
	protected PreparedStatement pst = null;
	protected ResultSet rs = null;
	
	/**
	 * O método <b>abrirConexao</b> abre a conexão com o banco de dados 
	 * atividade que está no servidor MySql, que sua vez está no container(docker).
	 * 
	 */
	
	public void abrirConexao () {
		/*
		 * Os comandos try(tentar) ... catch(capturar), são utilizados para
		 * realizar o tratamento de erros, onde try, você tenta
		 * executar algo e caso dê erro o comando catch, captura
		 * automaticamente o erro e o trata de acordo com o comando
		 * printStakeTrace, exibindo a pilha(Stake) de erros
		 */
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			
			/*
			 * Na linha abaixo é passado para o comando getConnection a 
			 * url de conexao com o banco de dados(ip,porta,banco de dados),
			 * o usuário e a senha. TimeZone foi definido como true
			 */
			
			conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:6556/atividade?useTimeZone=true","root","senac@123");
			
		}
		catch(SQLException se) {
			se.printStackTrace();
			/*
			 * Para tratamento de erros especificos de sql, estamos usando
			 * a classe SQLException
			 */
		}
		catch(Exception e) {
			/*
			 * Para erros gerais, estamos usando o comando Excepetion
			 */
			e.printStackTrace();
		}
		
	}
	
	/*
	 * O comando public void, se tem de intuito a fechar a conexão que está aberta
	 * ao banco de dados, no comando try(tentar) junto ao conn, vem com a função
	 * de tentativa a fechar a conexão com do banco de dados, caso haja um erro
	 * em meio da função de fechar, irá a ação do comando catch(capturar) o mesmo
	 * vem com a intenção de informar a falha da tentativa de fechar a conexão
	 */
	
	
	public void fecharConexao() {
		try {
			/*
			 * O comando close é utilizado para fechar
			 * a conexão com o servidor de banco de dados
			 */
			conn.close();
			
		}
		catch(SQLException se) {
			se.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
