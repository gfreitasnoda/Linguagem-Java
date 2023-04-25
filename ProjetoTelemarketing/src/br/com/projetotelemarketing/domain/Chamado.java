package br.com.projetotelemarketing.domain;

import java.sql.Date;

public class Chamado {
		
		private Long idchamado;
		private String funcionario;
		private String departamento;
		private String descricao;
		private Date dataAbertura;
		private Date dataResolucao;
		private String statuschamada;
		private String observacao;
		private String chamados;
		private String nomepessoa;

		public Chamado() {
		}

		public Chamado(Long idchamado, String funcionario, String departamento, String descricao, Date dataAbertura,
				Date dataResolucao, String statuschamada, String observacao, String chamados, String nomepessoa) {
			this.idchamado = idchamado;
			this.funcionario = funcionario;
			this.departamento = departamento;
			this.descricao = descricao;
			this.dataAbertura = dataAbertura;
			this.dataResolucao = dataResolucao;
			this.statuschamada = statuschamada;
			this.observacao = observacao;
			this.chamados = chamados;
			this.nomepessoa = nomepessoa;
		}

		public Long getIdchamado() {
			return idchamado;
		}

		public void setIdchamado(Long id) {
			this.idchamado = id;
		}

		public String getFuncionario() {
			return funcionario;
		}

		public void setFuncionario(String funcionario) {
			this.funcionario = funcionario;
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

		public Date getDataAbertura() {
			return dataAbertura;
		}

		public void setDataAbertura(Date dataAbertura) {
			this.dataAbertura = dataAbertura;
		}

		public Date getDataResolucao() {
			return dataResolucao;
		}

		public void setDataResolucao(Date dataResolucao) {
			this.dataResolucao = dataResolucao;
		}

		public String getStatuschamada() {
			return statuschamada;
		}

		public void setStatuschamada(String statuschamada) {
			this.statuschamada = statuschamada;
		}

		public String getObservacao() {
			return observacao;
		}

		public void setObservacao(String observacao) {
			this.observacao = observacao;
		}

		public String getChamados() {
			return chamados;
		}

		public void setChamados(String chamados) {
			this.chamados = chamados;
		}

		public String getNomepessoa() {
			return nomepessoa;
		}

		public void setNomepessoa(String nomepessoa) {
			this.nomepessoa = nomepessoa;
		}

		public void setIdchamado(long id) {
			// TODO Auto-generated method stub
			
		}

}
