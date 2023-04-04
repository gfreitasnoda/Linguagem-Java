package br.com.ProjetoEscola.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * A classe Conexão é destinada a abrir conexão com o banco de dados<br>
 * Nesta classe você encontrará os seguintes métodos <br>
 * <ul>
 *  <li><b> abrirConexao:</b> Abre a conexão com o banco escoladb<li>
 *  <li><b>fecharConexao:</b>Fecha a conexão com o banco escolacb</li>
 *	<ul>
 * @author GUIGÃO AUTOPEÇAS
 *
 */

public abstract class Conexao {
		/*
		 * As propriedades(Atribuidos) da classe Conexao foram setados como 
		 * protected, pois haverá um processo de herança dessa classe e assim será possivel
		 * passar os dados para as subclasses (classes filhas).
		 * O comando Connection é uma classe que permite estabelecer a 
		 * conexão com o banco de dados . Foi setado para esta variavel
		 * conn com o valor inicial nulo. Assim ela começa com algo depois 
		 * sera instanciada.
		 * Já o comando PreparedStatement é utilizado para executar os comandos de 
		 * SQL, tais como: Insert, Update, Select, Delete, dentre outros. A variavel do 
		 * prepared foi criada como pst e seu valor inicial é null.
		 * O comando ResultSet é destinado a guardar do comando
		 * Select do mysql. A variável rs foi inicializada com valor null
		 */
		protected Connection conn = null;
		protected PreparedStatement pst = null;
		protected ResultSet rs = null;
		/**
		 * O método <b>abrirConexao</b> abre a conexão com o banco de dados 
		 * escoladb que está no servidor MySQL,  que por sua vez está no container(docker)
		 */
		public void abrirConexao() {
				/*
				 * Os comandos try, são usados oara realizar o tratamento de erros, onde try, você tenta executar algo e
				 * caso dê erro o comando catch, captura automaticamente o erro e o trata de acordo com o 
				 * comando printStackTrace, exibindo a pilha(Stack) de erros.
				 */
				try {
						Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
						conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:6556/escoladb?useTimeZone=true", "root","senac@123");
						//faz que a conexão seja feita como uma ponte do sql para o eclipse tendo que informar somente o caminho, ip, usuario e senha.TimeZone definido como true
				}
				catch(SQLException se) {
						se.printStackTrace();
						//Para tratamento de eros especificos de sql estamos usando a classse SQLException
				}
				catch(Exception e) {
						e.printStackTrace();
						//Para erros gerais, estamos usando comando Exception
				}
		}
		
		public void fecharConexao() {
			
			try {
					conn.close();
					//comando close fecha e desliga a conexão feita pelo DriveManager 
				}
				catch(SQLException se) {
					se.printStackTrace();
					//Para tratamento de eros especificos de sql estamos usando a classse SQLException
				}
			catch(Exception e) {
				e.printStackTrace();
				//Para erros gerais, estamos usando comando Exception
			}
		}	
	
}
