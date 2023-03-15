package br.com.poo.estruturarepeticao;

import javax.swing.JOptionPane;

public class Pares extends JOptionPane {

	public static void main(String[] args) {
			
			String inicio, termino, resultado = "";
			inicio = JOptionPane.showInputDialog("Entre com um número");
			
			termino = JOptionPane.showInputDialog("Entre com um outro número");
			
			int in = Integer.parseInt(inicio);
			int ter = Integer.parseInt(termino);
			
			//Os valores que entrarão em inicio e termino veem do elemento 
			//JOptionPane.showInputDialog no formato de texto. Como iremos
			//realizar uma contagem com os valores será necessario converte-los
			//para número inteiro.Assim, usamos a classe Integer com a função
			//parseInt e convertemos para número
			
			for (int i = in; i <= ter ; i++ ) {
					if( i % 2 == 0) {
						resultado += "\n"+i;
					}
			}
			JOptionPane.showMessageDialog(null, resultado, "Números Pares",JOptionPane.INFORMATION_MESSAGE);
	}

}
