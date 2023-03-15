package br.com.poo.estruturarepeticao;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Tabuada extends JFrame {

	public static void main(String[] args) {
			/*
			 * Gerando um objeto de Janela baseando na classe
			 * JFrame. Abaixo um processo de instância
			 */
			JFrame janela = new JFrame();
			//tamanho em largura e altura
			janela.setSize(500,400);
			
			//posicionar a janela no centro da tela
			janela.setLocationRelativeTo(null);
			
			//aplicar um titulo a janela que será criada
			janela.setTitle("Tabuada");
			
			//comando para fechar e retirar a janela da memoria
			janela.setDefaultCloseOperation(EXIT_ON_CLOSE);
			
			//Vamos definir o layout como null.Isso nos ajuda
			//a posicionar os componentes livremente
			janela.getContentPane().setLayout(null);
			
			
			/*
			 * Vamos adicionar um componente de texto a nossa janela.
			 * este componente será um rótulo(label ->Jlabel)
			 */
			JLabel lblNumero = new JLabel("Digite um número para a tabuada");
			/*
			 * Para posicionar a Label na janela criada será necessario 
			 * utilizar as configurações de largura(x) e altura(y) 
			 */
			lblNumero.setBounds(10,10,250,30);
			//Vamos a label (lblNumero) a tela janela
			janela.add(lblNumero);
			
			/*
			 * Vamos add um novo componente chamado JTextArea
			 * para apresentar os resultados da tabuada
			 */
			JTextArea txtResultado = new JTextArea();
			//Vamos posicionar e definir a largura e altura da caixa
			txtResultado.setBounds(10,40,463,300);
			
			//adicionar caixa de texto a janela
			janela.add(txtResultado);
			
			/*
			 * Para o usuario inserir um numero para a tabuada iremos adicionar
			 * um novo componente chamado JTextField(Campo de Texto)
			 */
			JTextField txtNumero = new JTextField();
			
			
			//Vamos posicionar a caixa 
			
			txtNumero.setBounds(205,5,30,30);
			janela.add(txtNumero);
			
			JButton btnCalcular = new JButton("Calcular");
			btnCalcular.setBounds(250,5,200,30);
			janela.add(btnCalcular);
			
			//comando para mostrar a janela
			janela.setVisible(true);
			

	}

}
