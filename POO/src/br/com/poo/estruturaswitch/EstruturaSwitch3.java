package br.com.poo.estruturaswitch;

import javax.swing.JOptionPane;

public class EstruturaSwitch3 extends JOptionPane {

	public static void main(String[] args) {
		JOptionPane.showMessageDialog(null, "Bom dia","Sistema", JOptionPane.INFORMATION_MESSAGE);
		String salario = JOptionPane.showInputDialog("Digite um cargo que diremos o salário dele");
		String rs;
		switch(salario) {
			case "Diretor":
			rs = "O salário dele é 20.000";
			break;
			
			case "Gerente":
			rs = "O salário dele é 15.000";
			break;
			
			case "Secretária":
			rs = "O salário dele é 8.000";
			break;
			
			case "Analista":
			rs = "O salário dele é 7.000";
			break;
			
			case "Assistente":
			rs = "O salário dele é 4.000";
			break;
			
			case "Estagiário":
			rs = "O salário dele é 1.500";
			break;
			
			default:
			rs =  "Esse cargo não existe";
			break;
		}
		JOptionPane.showMessageDialog(null, rs,"Resposta", JOptionPane.INFORMATION_MESSAGE);
	}

}
