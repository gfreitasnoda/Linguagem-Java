package br.com.ProjetoAtividade.domain;

import java.sql.Date;

public class Chamados {
	
	private Long idChamados;
	private String nomepessoa;
	private String departamento;
	private String descricao;
	private Date dataSolicitacao;
	private Date dataResolucao;
	private String statusChamado;
	private String observacao;
	private String nomeFuncionario;
	
	
	
	public Chamados() {}



	public Chamados(Long idChamados, String nomepessoa, String departamento, String descricao, Date dataSolicitacao,
			Date dataResolucao, String statusChamado, String observacao, String nomeFuncionario) {
		this.idChamados = idChamados;
		this.nomepessoa = nomepessoa;
		this.departamento = departamento;
		this.descricao = descricao;
		this.dataSolicitacao = dataSolicitacao;
		this.dataResolucao = dataResolucao;
		this.statusChamado = statusChamado;
		this.observacao = observacao;
		this.nomeFuncionario = nomeFuncionario;
	}



	public Long getIdChamados() {
		return idChamados;
	}



	public void setIdChamados(Long idChamados) {
		this.idChamados = idChamados;
	}



	public String getNomepessoa() {
		return nomepessoa;
	}



	public void setNomepessoa(String nomepessoa) {
		this.nomepessoa = nomepessoa;
	}



	public String getDepartamento() {
		return departamento;
	}



	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}



	public String getDescricao() {
		return descricao;
	}



	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}



	public Date getDataSolicitacao() {
		return dataSolicitacao;
	}



	public void setDataSolicitacao(Date dataSolicitacao) {
		this.dataSolicitacao = dataSolicitacao;
	}



	public Date getDataResolucao() {
		return dataResolucao;
	}



	public void setDataResolucao(Date dataResolucao) {
		this.dataResolucao = dataResolucao;
	}



	public String getStatusChamado() {
		return statusChamado;
	}



	public void setStatusChamado(String statusChamado) {
		this.statusChamado = statusChamado;
	}



	public String getObservacao() {
		return observacao;
	}



	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}



	public String getNomeFuncionario() {
		return nomeFuncionario;
	}



	public void setNomeFuncionario(String nomeFuncionario) {
		this.nomeFuncionario = nomeFuncionario;
	}
	
	
}
