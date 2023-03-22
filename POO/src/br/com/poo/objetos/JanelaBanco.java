package br.com.poo.objetos;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JanelaBanco extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JanelaBanco frame = new JanelaBanco();
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
	public JanelaBanco() {
		setTitle("Tela Principal");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 576, 308);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 64, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnPoupanca = new JButton("Poupança");
		btnPoupanca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					Poupanca jp = new Poupanca();
					jp.setVisible(true);
					
			}
		});
		btnPoupanca.setFont(new Font("Tahoma", Font.BOLD, 22));
		btnPoupanca.setForeground(new Color(249, 81, 0));
		btnPoupanca.setBackground(Color.WHITE);
		btnPoupanca.setBounds(49, 109, 206, 120);
		contentPane.add(btnPoupanca);
		
		JButton btnCorrente = new JButton("Corrente");
		btnCorrente.setFont(new Font("Tahoma", Font.BOLD, 28));
		btnCorrente.setForeground(new Color(249, 81, 0));
		btnCorrente.setBackground(Color.WHITE);
		btnCorrente.setBounds(287, 107, 206, 120);
		contentPane.add(btnCorrente);
		
		JLabel lblTitulo = new JLabel("BO");
		lblTitulo.setForeground(Color.WHITE);
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 38));
		lblTitulo.setBounds(223, 30, 93, 66);
		contentPane.add(lblTitulo);
		
		JLabel lblX = new JLabel("X");
		lblX.setForeground(new Color(249, 81, 0));
		lblX.setFont(new Font("Tahoma", Font.BOLD, 38));
		lblX.setBounds(279, 30, 93, 66);
		contentPane.add(lblX);
	}
}
