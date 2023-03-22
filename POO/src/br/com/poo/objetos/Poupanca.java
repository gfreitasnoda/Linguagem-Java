package br.com.poo.objetos;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class Poupanca extends JFrame {

	private JPanel contentPane;
	private JTextField txtNumeroBanco;
	private JTextField txtAgencia;
	private JTextField txtNumeroConta;
	private JTextField txtTitular;
	private JTextField txtSaldoInicial;
	private JTextField txtRendimento;
	private JTextField txtValor;
	private JButton btnSaldo;
	private JButton btnSacar;
	private JButton btnDeposito;


	/**
	 * Create the frame.
	 */
	public Poupanca() {
		setTitle("Janela Poupança");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 705, 471);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 64, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNumeroConta = new JLabel("Número da banco:");
		lblNumeroConta.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 25));
		lblNumeroConta.setForeground(Color.WHITE);
		lblNumeroConta.setBackground(Color.WHITE);
		lblNumeroConta.setBounds(30, 11, 226, 43);
		contentPane.add(lblNumeroConta);
		
		JLabel lblAgncia = new JLabel("Agência:");
		lblAgncia.setForeground(Color.WHITE);
		lblAgncia.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 25));
		lblAgncia.setBackground(Color.WHITE);
		lblAgncia.setBounds(248, 11, 109, 43);
		contentPane.add(lblAgncia);
		
		JLabel lblNumeroConta_1 = new JLabel("Número da conta:");
		lblNumeroConta_1.setForeground(Color.WHITE);
		lblNumeroConta_1.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 25));
		lblNumeroConta_1.setBackground(Color.WHITE);
		lblNumeroConta_1.setBounds(357, 11, 206, 43);
		contentPane.add(lblNumeroConta_1);
		
		txtNumeroBanco = new JTextField();
		txtNumeroBanco.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if(txtNumeroBanco.getText().equals("") || txtNumeroBanco.getText().trim().equals("")) {
					JOptionPane.showConfirmDialog(null,"Número do banco obrigatório");
					txtNumeroBanco.requestFocus();
				}
			}
		});
		txtNumeroBanco.setBounds(30, 47, 206, 38);
		contentPane.add(txtNumeroBanco);
		txtNumeroBanco.setColumns(10);
		
		txtAgencia = new JTextField();
		txtAgencia.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if(txtAgencia.getText().equals("") || txtAgencia.getText().trim().equals("")) {
					JOptionPane.showConfirmDialog(null,"Informção da Agencia é obrigatória");
					txtAgencia.requestFocus();
				}
			}
		});
		txtAgencia.setBounds(248, 47, 96, 38);
		contentPane.add(txtAgencia);
		txtAgencia.setColumns(10);
		
		txtNumeroConta = new JTextField();
		txtNumeroConta.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if(txtNumeroConta.getText().equals("") || txtNumeroConta.getText().trim().equals("")) {
					JOptionPane.showConfirmDialog(null,"Número da Conta obrigatório");
					txtNumeroConta.requestFocus();
				}
			}
		});
		txtNumeroConta.setBounds(357, 47, 295, 38);
		contentPane.add(txtNumeroConta);
		txtNumeroConta.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Nome do titular:");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 25));
		lblNewLabel.setBounds(30, 86, 206, 43);
		contentPane.add(lblNewLabel);
		
		txtTitular = new JTextField();
		txtTitular.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if(txtTitular.getText().equals("") || txtTitular.getText().trim().equals("")) {
					JOptionPane.showConfirmDialog(null,"Informção do Nome do Titular é obrigatório");
					txtTitular.requestFocus();
				}
			}
		});
		txtTitular.setColumns(10);
		txtTitular.setBounds(30, 124, 533, 38);
		contentPane.add(txtTitular);
		
		JLabel lblSaldoInicial = new JLabel("Saldo Inicial:");
		lblSaldoInicial.setForeground(Color.WHITE);
		lblSaldoInicial.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 25));
		lblSaldoInicial.setBounds(30, 173, 206, 43);
		contentPane.add(lblSaldoInicial);
		
		txtSaldoInicial = new JTextField();
		txtSaldoInicial.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if(txtSaldoInicial.getText().equals("") || txtSaldoInicial.getText().trim().equals("")) {
					JOptionPane.showConfirmDialog(null,"Saldo Inicial obrigatório");
					txtSaldoInicial.requestFocus();
				}
			}
		});
		txtSaldoInicial.setColumns(10);
		txtSaldoInicial.setBounds(30, 216, 226, 38);
		contentPane.add(txtSaldoInicial);
		
		JLabel lblRendimento = new JLabel("Rendimento:");
		lblRendimento.setForeground(Color.WHITE);
		lblRendimento.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 25));
		lblRendimento.setBounds(357, 173, 206, 43);
		contentPane.add(lblRendimento);
		
		txtRendimento = new JTextField();
		txtRendimento.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if(txtRendimento.getText().equals("") || txtRendimento.getText().trim().equals("")) {
					JOptionPane.showConfirmDialog(null,"Informe o Rendimento é obrigatório");
					txtRendimento.requestFocus();
				}
				btnSaldo.setText("Abrir Conta");
				btnSaldo.setEnabled(true);
			}
		});
		txtRendimento.setColumns(10);
		txtRendimento.setBounds(357, 216, 295, 38);
		contentPane.add(txtRendimento);
		
		btnSaldo = new JButton("Verificar Saldo");
		btnSaldo.setForeground(new Color(249, 81, 0));
		btnSaldo.setBackground(Color.WHITE);
		btnSaldo.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 18));
		btnSaldo.setBounds(30, 285, 176, 101);
		contentPane.add(btnSaldo);
		btnSaldo.setEnabled(false);
		
		btnSacar = new JButton("Sacar");
		btnSacar.setForeground(new Color(249, 81, 0));
		btnSacar.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 18));
		btnSacar.setBackground(Color.WHITE);
		btnSacar.setBounds(230, 343, 153, 43);
		contentPane.add(btnSacar);
		btnSacar.setEnabled(false);
		
		btnDeposito = new JButton("Deposito");
		btnDeposito.setForeground(new Color(249, 81, 0));
		btnDeposito.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 18));
		btnDeposito.setBackground(Color.WHITE);
		btnDeposito.setBounds(230, 283, 153, 43);
		contentPane.add(btnDeposito);
		btnDeposito.setEnabled(false);
		
		txtValor = new JTextField();
		txtValor.setText("\r\n");
		txtValor.setBounds(409, 309, 243, 77);
		contentPane.add(txtValor);
		txtValor.setColumns(10);
		txtValor.setEnabled(false);
		
		JLabel lblValorDeposito = new JLabel("Valor de Deposito:");
		lblValorDeposito.setForeground(Color.WHITE);
		lblValorDeposito.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 25));
		lblValorDeposito.setBounds(410, 265, 242, 43);
		contentPane.add(lblValorDeposito);
	}
}
