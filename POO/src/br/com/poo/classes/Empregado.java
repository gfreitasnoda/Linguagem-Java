package br.com.poo.classes;

import javax.swing.JOptionPane;

import br.com.poo.interfaces.Acoes;

public class Empregado implements Acoes{

	@Override
	public void mensagem(String msg) {
		JOptionPane.showMessageDialog(null, msg);
		
	}

	@Override
	public String salvar() {
		return "Salvo com Sucesso !!";
	}

	@Override
	public Double soma(double[] valores) {
		
		double rs = 0.0;
		for(int i = 0 ; i < valores.length ; i++) {
			rs +=valores[i];
		}
		
		return rs;
	}
		
}
