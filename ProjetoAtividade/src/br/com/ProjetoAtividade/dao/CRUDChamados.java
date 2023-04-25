package br.com.ProjetoAtividade.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.ProjetoAtividade.domain.Chamados;

public class CRUDChamados extends Conexao implements CRUD<Chamados> {
	
	
	String msg = "";
	
	
	

	@Override
	public String gravar(Chamados obj) {
		
		try {
			abrirConexao();
			String sql = "INSERT INTO chamados (nomepessoa,departamento,descricao,dataSolicitacao,dataResolucao,statusChamado,observacao,nomeFuncionario)VALUES(?,?,?,?,?,?,?,?)";
			pst = conn.prepareStatement(sql);
			//Passar os parametros para os pontos de interrogação
			pst.setString(1, obj.getNomepessoa());
			pst.setString(2, obj.getDepartamento());
			pst.setString(3, obj.getDescricao());
			pst.setDate(4, obj.getDataResolucao());
			pst.setDate(5, obj.getDataResolucao());
			pst.setString(6, obj.getStatusChamado());
			pst.setString(7, obj.getObservacao());
			pst.setString(8, obj.getNomeFuncionario());
			
			/*
			 * Quando executamos a consulta usando o comando executeUpdate ele 
			 * retornará um número que pode ser 1 ou 0(zero) sendo 1 quando o
			 * dado é inserido e 0(zero) quando o dado não é inserido
			 */
			int i = pst.executeUpdate();
			
			if(i>0) {
				msg = "Chamado de suporte realizado com sucésso";
			}
			else {
				msg = "Não foi possível solicitar o chamado do suporte. Tente novamente com atenção.";
				
			}
		}
			catch(SQLException se) {
				msg = "Erro de sql -> " + se.getMessage();		
			}
			catch(Exception e) {
				msg = "Erro inesperado." + e.getMessage();
			}
			finally {
				fecharConexao();
			}
		
		
		
		return msg;
	}

	@Override
	public List<Chamados> listar() {
		/*
		 * Vamos criar uma lista de cursos, onde sua implementação é
		 * um array(Matriz) de cursos no formato de uma lista de cursos.
		 * Assim teremos linhas e colunas para os cursos
		 */
		
		List<Chamados> lstChamados = new ArrayList<Chamados>();
		
		try {
			abrirConexao();
			String sql = "SELECT * FROM curso;";
			//Preparar a consulta para ser executada
			pst = conn.prepareStatement(sql);
			/*
			 * O comando executeQuery é utilizado para executar comandos
			 * de SELECT. O retorno do executeQuery é o ResultSet,
			 * portanto necessário que haja uma variável do tipo ResultSet
			 * para guardar o retorno da execução. Estamos usando a variável
			 * rs que foi declarada na classe Conexão.
			 * O ResultSet que está destinado e abreviado anteriormente
			 * na classe de Conexão como rs
			 */
			rs = pst.executeQuery();
			
			/*
			 * Enquanto houver dados na tabela de banco dados o laço continua a
			 * buscar os dados. O comando next() do rs captura dados da tabela e
			 * adiciona  em novo curso.
			 */
			
			while(rs.next()) {
				Chamados chamado = new Chamados();
				
				chamado.setIdChamados(rs.getLong(1));
				chamado.setNomepessoa(rs.getString(2));
				chamado.setDepartamento(rs.getString(3));
				chamado.setDescricao(rs.getString(4));
				chamado.setDataSolicitacao(rs.getDate(5));
				chamado.setDataResolucao(rs.getDate(6));
				chamado.setStatusChamado(rs.getString(7));
				chamado.setObservacao(rs.getString(8));
				chamado.setNomeFuncionario(rs.getString(9));
				
				//Adiciona um novo chamado na lista de chamados
				lstChamados.add(chamado);
				
			}
			
		}
			catch(SQLException se) {
				se.printStackTrace();
				
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			
			finally {
				fecharConexao();
			}
			
			return lstChamados;
		
	
	}

	@Override
	public List<Chamados> listar(Chamados obj) {
		/*
		 * Vamos criar uma lista de chamados, onde sua implementação é
		 * um array(Matriz) de cusos no formato de uma lista de cursos.
		 * Assim teremos linhas e colunas para os cursos
		 */
		
		List<Chamados> lstChamados = new ArrayList<Chamados>();
		
		try {
			
			abrirConexao();
			
			String sql = "";
			
			if(obj.getIdChamados()!=0) {
				sql = "SELECT * FROM chamados WHERE idChamados= "+obj.getIdChamados();
				
			}
			
			else if (obj.getNomepessoa()!=null) {
				sql = "SELECT * FROM chmaados WHERE nomepessoa LIKE "+obj.getNomepessoa();
				
			}
			else if (obj.getDepartamento()!=null) {
				sql = "SELECT * FROM chamados WHERE departamento LIKE"+obj.getDepartamento();
				
			}
			else {
				sql = "SELECT * FROM chamados;";
			}
			
			
			//Preparar a consulta para ser executada
			
			pst = conn.prepareStatement(sql);
			/*
			 * O comando executeQuery é utilizado para executar comandos
			 * de SELECT. O retorno do executeQuery é o ResultSet,
			 * portanto necessário que haja uma variável do tipo ResultSet
			 * para guardar o retorno da execução. Estamos usando a variável
			 * rs que foi declarada na classe Conexão.
			 * O ResultSet que está destinado e abreviado anteriormente
			 * na classe de Conexão como rs
			 */
			rs = pst.executeQuery();
			
			/*
			 * Enquanto houver dados na tabela de banco dados o laço continua a
			 * buscar os dados. O comando next() do rs captura dados da tabela e
			 * adiciona  em novo curso.
			 */
			
			while(rs.next()) {
				Chamados chamado = new Chamados();
				
				
				chamado.setIdChamados(rs.getLong(1));
				chamado.setNomepessoa(rs.getString(2));
				chamado.setDepartamento(rs.getString(3));
				chamado.setDescricao(rs.getString(4));
				chamado.setDataSolicitacao(rs.getDate(5));
				chamado.setDataResolucao(rs.getDate(6));
				chamado.setStatusChamado(rs.getString(7));
				chamado.setObservacao(rs.getString(8));
				chamado.setNomeFuncionario(rs.getString(9));
				
				//Adiciona um novo chamado na lista de chamados.
				lstChamados.add(chamado);
			}
			
		}
		catch(SQLException se) {
			se.printStackTrace();
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		finally {
			fecharConexao();
		}
		return lstChamados;
		
		
	}

	@Override
	public Chamados atualizar(Chamados obj) {
		
		Chamados chamado = new Chamados();
		
		try {
			abrirConexao();
			String sql = "UPDATE chamados SET dataResolucao=?,statusChamado=?,observacao=?,nomeFuncionario=? WHERE idChamados=?";
			pst = conn.prepareStatement(sql);
			pst.setDate(1, obj.getDataResolucao());
			pst.setString(2, obj.getStatusChamado());
			pst.setString(3, obj.getObservacao());
			pst.setString(4, obj.getNomeFuncionario());
			
			
			int i = pst.executeUpdate();
			
			if(i>0) {
				chamado = obj;
			}
			else {
				//Exibir a mensagem mesmo sem retorno de String.
				throw new Exception ("Não foi possível atualizar.");
			}
		}
		catch(SQLException se) {
			se.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		finally {
			fecharConexao();
		}
		
		return chamado;
		
		
		
	
		
	}

	@Override
	public String apagar(Chamados obj) {
		
		String msg = "";
		
		try {
			abrirConexao();
			
			String sql = "DELETE FROM chamados WHERE idChamados=?";
			
			pst = conn.prepareStatement(sql);
			pst.setLong(1, obj.getIdChamados());
			
			int i = pst.executeUpdate();
			
			if(i>0) {
				msg = "Chamado apagado.";
				
			}
			else {
				msg = "Não foi possível apagar o chamado.";
			}
			
		}
		catch(SQLException se) {
			 msg = "Erro na consulta de SQL -> " + se.getMessage();
			}
			catch(Exception e) {
				msg = "Erro de ação ->" + e.getMessage();
			}
			
			finally {
				fecharConexao();
			}
			
			return msg;
		

		
	}

}
