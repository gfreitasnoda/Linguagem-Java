package br.com.projetotelemarketing.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class Conexao {

	protected Connection conn = null;
	protected PreparedStatement pst = null;
	protected ResultSet rs = null;
	
	public void abrirConexao() {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:6556/bancobd?useTimeZone=true", "root","senac@123");
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
				//Para tratamento de erros especificos de sql estamos usando a classe SQLException
			}
		catch(Exception e) {
			e.printStackTrace();
			//Para erros gerais, estamos usando comando Exception
		}
	}	
	
	
	
	
}
