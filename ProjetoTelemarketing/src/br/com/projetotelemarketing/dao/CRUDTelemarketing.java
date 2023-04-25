package br.com.projetotelemarketing.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import br.com.projetotelemarketing.domain.Chamado;

public class CRUDTelemarketing extends Conexao implements CRUD <Chamado> {

	@Override
	public String registrar(Chamado obj) {
			String msg = "";
			try {
				abrirConexao();
				String sql = "insert into chamado(nomepessoa,departamento,descricao,dataAbertura)values(?,?,?,?)";
				pst = conn.prepareStatement(sql);
				//passar os parametros para os pontos de interrogação
				pst.setString(1, obj.getNomepessoa());
				pst.setString(2, obj.getDepartamento());
				pst.setString(3, obj.getDescricao());
				pst.setDate(4, obj.getDataAbertura());
				/*
				 * Quando usamos a consulta usando o comando executeUpdate ele 
				 * retorna um numero que pode ser 1 ou 0(zero), sendo 1 quando o
				 * dado é inserido e 0(zero) quando o dado não é inserido
				 * */
			
				int i = pst.executeUpdate();
				
				if(i > 0) {
					msg = "Chamado feito com sucesso!";
				}
				else {
					msg = "Não foi possivel realizar a solitação do chamado";
				}
			}
				
				catch(SQLException se) {
					msg = "Erro de sql ->"+se.getMessage();
				}
				catch(Exception e) {
					msg = "Erro inesperado ->"+e.getMessage();
				}
				finally {
					fecharConexao();
				}
			
		return msg;
		
	}

	@Override
	public List<Chamado> listar() {
		List<Chamado> lstChamado = new ArrayList<Chamado>();
		
		try {
			
			abrirConexao();
			String sql = "SELECT * FROM banco";
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			
			while(rs.next()) {
				Chamado chamado = new Chamado();
				
				
				chamado.setIdchamado(rs.getInt(1));
				chamado.setFuncionario(rs.getString(2));
				chamado.setDepartamento(rs.getString(3));
				chamado.setDescricao(rs.getString(4));
				chamado.setDataAbertura(rs.getDate(5));
				chamado.setDataResolucao(rs.getDate(6));
				chamado.setStatuschamada(rs.getString(7));
				chamado.setObservacao(rs.getString(8));
				chamado.setNomepessoa(rs.getString(9));
				
				lstChamado.add(chamado);
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
	
	return lstChamado;
}

	@Override
	public List<Chamado> listar(Chamado obj) {
		List<Chamado> lstChamado = new ArrayList<Chamado>();
		
		try {
			abrirConexao();
			
			String sql = "";
			
			if(obj.getIdchamado()!=0) {
				 sql = "Select * From curso WHERE idchamado="+obj.getIdchamado();
			}
			else if(obj.getFuncionario()!=null) {
				sql = "Select * From curso WHERE funcionario like "+obj.getFuncionario()+"%";
			}
			else if(obj.getDepartamento()!=null) {
				sql = "Select * From curso WHERE departamento like %"+obj.getDepartamento()+"%";
			}
			
			else if(obj.getDescricao()!=null) {
				sql = "Select * From curso WHERE descricao like %"+obj.getDescricao()+"%";
			}
			else if(obj.getDataAbertura()!=null) {
				sql = "Select * From curso WHERE DataAbertura like %"+obj.getDataAbertura()+"%";
			}

			else {
				sql = "Select * From banco";
			}
			
			pst = conn.prepareStatement(sql);
			
			rs = pst.executeQuery();
			
			while(rs.next()) {
				Chamado chamado = new Chamado();
				
				
				chamado.setIdchamado(rs.getLong(1));
				chamado.setFuncionario(rs.getString(2));
				chamado.setDepartamento(rs.getString(3));
				chamado.setDescricao(rs.getString(4));
				chamado.setDataAbertura(rs.getDate(5));
				chamado.setDataResolucao(rs.getDate(6));
				chamado.setStatuschamada(rs.getString(7));
				chamado.setObservacao(rs.getString(8));
				chamado.setNomepessoa(rs.getString(9));
				
				lstChamado.add(chamado);
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
	
	return lstChamado;
}

	@Override
	public Chamado atualizar(Chamado obj) {
		Chamado chamado = new Chamado();
		try {
				abrirConexao();
				String sql = "UPDATE banco SET funcionario=?,departamento=?,dataResolucao=?,statuschamada=? WHERE idchamado=?";
				pst = conn.prepareStatement(sql);
				pst.setString(1, obj.getFuncionario());
				pst.setString(2,obj.getDepartamento());
				pst.setString(3, obj.getDescricao());
				pst.setDate(4, obj.getDataResolucao());
				pst.setString(5, obj.getStatuschamada());
				pst.setLong(6, obj.getIdchamado());
						
				int i = pst.executeUpdate();
				if(i > 0) {
					chamado = obj;
				}
				else {
						throw new Exception("Não foi possivel atualizar");
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
	public String apagar(Chamado obj) {
		String msg = "";
		try {
			abrirConexao();
			String sql = "DELETE FROM banco WHERE idchamado = ?";
			pst = conn.prepareStatement(sql);
			pst.setLong(1, obj.getIdchamado());
			int i = pst.executeUpdate();
			if(i > 0) {
				msg = "Chamado apagado";
			}
			else {
				msg = "Não foi possivel apagar o chamado";
			}
		}
		catch(SQLException se) {
			msg = "Erro na consulta de SQL ->"+se.getMessage();
		}
		catch(Exception e) {
			msg = "Erro desconhecido ->"+e.getMessage();
		}
		finally {
				fecharConexao();
		}
		return msg;
	}

}
