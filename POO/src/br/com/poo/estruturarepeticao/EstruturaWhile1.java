package br.com.poo.estruturarepeticao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class EstruturaWhile1 extends JFrame {

	private JPanel contentPane;
	private JTextField textInicial;
	private JTextField textFinal;
	
	String dados = "";
	int i;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EstruturaWhile1 frame = new EstruturaWhile1();
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
	public EstruturaWhile1() {
		setResizable(false);
		setBackground(new Color(136, 23, 23));
		setTitle("Janela Principal");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 315, 426);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(111, 19, 19));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Número Inicial");
		lblNewLabel.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD, 16));
		lblNewLabel.setBounds(29, 22, 130, 39);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Número Final");
		lblNewLabel_1.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD, 16));
		lblNewLabel_1.setBounds(29, 72, 130, 30);
		contentPane.add(lblNewLabel_1);
		
		textInicial = new JTextField();
		textInicial.setFont(new Font("Yu Gothic Medium", Font.BOLD, 12));
		textInicial.setBounds(148, 36, 112, 20);
		contentPane.add(textInicial);
		textInicial.setColumns(10);
		
		textFinal = new JTextField();
		textFinal.setFont(new Font("Yu Gothic Light", Font.BOLD, 12));
		textFinal.setBounds(148, 82, 112, 20);
		contentPane.add(textFinal);
		textFinal.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(29, 154, 253, 222);
		contentPane.add(scrollPane);
		
		JTextArea txtResultado = new JTextArea();
		scrollPane.setViewportView(txtResultado);
		
		JButton btnExecutar = new JButton("Executar");
		btnExecutar.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD, 18));
		btnExecutar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
					while(i <= Integer.parseInt(textFinal.getText())) {
							dados += i + "\n";
							i ++; 
						
					}
					txtResultado.setText(dados);
					textInicial.setText("");
					textFinal.setText("");
					dados = "";
					
					
			
			}
		});
		btnExecutar.setBounds(29, 113, 252, 30);
		contentPane.add(btnExecutar);
	}
}
