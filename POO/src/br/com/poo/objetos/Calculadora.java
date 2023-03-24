package br.com.poo.objetos;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;

public class Calculadora extends JFrame {

	private JPanel contentPane;
	private JButton btnUm;
	private JButton btnDois;
	private JButton btnTres;
	private JButton btnQuatro;
	private JButton btnCinco;
	private JButton btnSeis;
	private JButton btnSete;
	private JButton btnOito;
	private JButton btnNove;
	private JButton btnDez;
	private JButton btnMultiplicação;
	private JButton btnDivisao;
	private JButton btnAdicao;
	private JButton btnSub;
	private JLabel lblResultado;
	private String resultado;
	private String valor1;
	private String valor2;
	private String operacao;
	private double num1;
	private double num2;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Calculadora frame = new Calculadora();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Calculadora() {
		
		resultado = "";
		valor1 = "";
		valor2 = "";
		operacao = "";
		
		setResizable(false);
		setTitle("Calculadora");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 385, 567);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblResultado = new JLabel("");
		lblResultado.setFont(new Font("Tahoma", Font.PLAIN, 55));
		lblResultado.setBounds(10, 11, 349, 81);
		contentPane.add(lblResultado);
		
		JButton btnMultiplicacao = new JButton("x");
		btnMultiplicacao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				valor1 = lblResultado.getText();
				operacao = "*";
				lblResultado.setText("");
			}
		});
		btnMultiplicacao.setBackground(new Color(192, 192, 192));
		btnMultiplicacao.setFont(new Font("Perpetua Titling MT", Font.PLAIN, 31));
		btnMultiplicacao.setBounds(271, 195, 88, 65);
		contentPane.add(btnMultiplicacao);
		
		JButton btnDivisao = new JButton("/");
		btnDivisao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				valor1 = lblResultado.getText();
				operacao = "/";
				lblResultado.setText("");
				
				
				
			}
		});
		btnDivisao.setBackground(new Color(192, 192, 192));
		btnDivisao.setFont(new Font("Tahoma", Font.PLAIN, 31));
		btnDivisao.setBounds(271, 119, 88, 65);
		contentPane.add(btnDivisao);
		
		JButton btnAdicao = new JButton("+");
		btnAdicao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				valor1 = lblResultado.getText();
				operacao = "+";
				lblResultado.setText("");
			}
		});
		btnAdicao.setBackground(new Color(192, 192, 192));
		btnAdicao.setFont(new Font("Perpetua Titling MT", Font.PLAIN, 31));
		btnAdicao.setBounds(271, 271, 88, 65);
		contentPane.add(btnAdicao);
		
		JButton btnSub = new JButton("-");
		btnSub.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				valor1 = lblResultado.getText();
				operacao = "-";
				lblResultado.setText("");
			}
		});
		btnSub.setBackground(new Color(192, 192, 192));
		btnSub.setFont(new Font("Perpetua Titling MT", Font.PLAIN, 31));
		btnSub.setBounds(271, 347, 88, 65);
		contentPane.add(btnSub);
		
		JButton btnIgual = new JButton("=");
		btnIgual.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				valor2 = lblResultado.getText();
				int num = Integer.parseInt(valor1);
				int num2 = Integer.parseInt(valor2);
				
				switch(operacao) {
				 
				case "/":
					resultado = "valor1 / valor2" + operacao;
				break;
				
				case "+":
					resultado = "valor1 + valor2"+operacao ;
				break;
				
				case "-":
					resultado = "valor1 - valor2"+operacao;
				break;
				
				case "*":
					resultado = "valor1 * valor2"+operacao;
				break;	
					
					
					
				}
				
			}
		});
		btnIgual.setBackground(new Color(255, 128, 64));
		btnIgual.setFont(new Font("Tahoma", Font.PLAIN, 31));
		btnIgual.setBounds(271, 423, 88, 88);
		contentPane.add(btnIgual);
		
		JButton btnUm = new JButton("1");
		btnUm.setBackground(new Color(192, 192, 192));
		btnUm.setFont(new Font("Tahoma", Font.PLAIN, 38));
		btnUm.setBounds(10, 119, 74, 94);
		contentPane.add(btnUm);
		btnUm.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(lblResultado.getText().equals("0")) {
					resultado = "1";
					lblResultado.setText(resultado);
			}
				else {
					resultado += "1";
					lblResultado.setText(resultado);
					}
				}
		});
		JButton btnDois = new JButton("2");
		btnDois.setBackground(new Color(192, 192, 192));
		btnDois.setFont(new Font("Tahoma", Font.PLAIN, 38));
		btnDois.setBounds(94, 119, 74, 94);
		contentPane.add(btnDois);
		btnDois.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(lblResultado.getText().equals("0")) {
					resultado = "2";
					lblResultado.setText(resultado);
			}
				else {
					resultado += "2";
					lblResultado.setText(resultado);
					}
				}
		});
		
		JButton btnTres = new JButton("3");
		btnTres.setBackground(new Color(192, 192, 192));
		btnTres.setFont(new Font("Tahoma", Font.PLAIN, 38));
		btnTres.setBounds(178, 119, 74, 94);
		contentPane.add(btnTres);
		btnTres.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(lblResultado.getText().equals("0")) {
					resultado = "3";
					lblResultado.setText(resultado);
			}
				else {
					resultado += "3";
					lblResultado.setText(resultado);
					}
				}
		});
		
		
		JButton btnSeis = new JButton("6");
		btnSeis.setBackground(new Color(192, 192, 192));
		btnSeis.setFont(new Font("Tahoma", Font.PLAIN, 38));
		btnSeis.setBounds(178, 224, 74, 89);
		contentPane.add(btnSeis);
		btnSeis.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(lblResultado.getText().equals("0")) {
					resultado = "6";
					lblResultado.setText(resultado);
			}
				else {
					resultado += "6";
					lblResultado.setText(resultado);
					}
				}
		});
		
		
		JButton btnCinco = new JButton("5");
		btnCinco.setBackground(new Color(192, 192, 192));
		btnCinco.setFont(new Font("Tahoma", Font.PLAIN, 38));
		btnCinco.setBounds(94, 224, 74, 89);
		contentPane.add(btnCinco);
		btnCinco.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(lblResultado.getText().equals("0")) {
					resultado = "5";
					lblResultado.setText(resultado);
			}
				else {
					resultado += "5";
					lblResultado.setText(resultado);
					}
				}
		});
		
		
		JButton btnQuatro = new JButton("4");
		btnQuatro.setBackground(new Color(192, 192, 192));
		btnQuatro.setFont(new Font("Tahoma", Font.PLAIN, 38));
		btnQuatro.setBounds(10, 224, 74, 89);
		contentPane.add(btnQuatro);
		btnQuatro.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(lblResultado.getText().equals("0")) {
					resultado = "4";
					lblResultado.setText(resultado);
			}
				else {
					resultado += "4";
					lblResultado.setText(resultado);
					}
				}
		});
		
		
		JButton btnSete = new JButton("7");
		btnSete.setBackground(new Color(192, 192, 192));
		btnSete.setFont(new Font("Tahoma", Font.PLAIN, 38));
		btnSete.setBounds(10, 324, 74, 88);
		contentPane.add(btnSete);
		btnSete.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(lblResultado.getText().equals("0")) {
					resultado = "7";
					lblResultado.setText(resultado);
			}
				else {
					resultado += "7";
					lblResultado.setText(resultado);
					}
				}
		});
		
		
		JButton btnOito = new JButton("8");
		btnOito.setBackground(new Color(192, 192, 192));
		btnOito.setFont(new Font("Tahoma", Font.PLAIN, 38));
		btnOito.setBounds(94, 325, 74, 88);
		contentPane.add(btnOito);
		btnOito.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(lblResultado.getText().equals("0")) {
					resultado = "8";
					lblResultado.setText(resultado);
			}
				else {
					resultado += "8";
					lblResultado.setText(resultado);
					}
				}
		});
		
		
		JButton btnNove = new JButton("9");
		btnNove.setBackground(new Color(192, 192, 192));
		btnNove.setFont(new Font("Tahoma", Font.PLAIN, 38));
		btnNove.setBounds(178, 325, 74, 88);
		contentPane.add(btnNove);
		btnNove.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(lblResultado.getText().equals("0")) {
					resultado = "9";
					lblResultado.setText(resultado);
			}
				else {
					resultado += "9";
					lblResultado.setText(resultado);
					}
				}
		});
		
		
		JButton btnZero = new JButton("0");
		btnZero.setBackground(new Color(192, 192, 192));
		btnZero.setFont(new Font("Tahoma", Font.PLAIN, 38));
		btnZero.setBounds(10, 423, 74, 88);
		contentPane.add(btnZero);
		btnZero.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(lblResultado.getText().equals("0")) {
					resultado = "0";
					lblResultado.setText(resultado);
			}
				else {
					resultado += "0";
					lblResultado.setText(resultado);
					}
				}
		});
		
		
		JButton btnLimpa = new JButton("CE");
		btnLimpa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				lblResultado.setText("");
				
			}
		});
		btnLimpa.setBackground(new Color(139, 217, 245));
		btnLimpa.setFont(new Font("Tahoma", Font.PLAIN, 38));
		btnLimpa.setBounds(94, 426, 158, 85);
		contentPane.add(btnLimpa);
	}
}
