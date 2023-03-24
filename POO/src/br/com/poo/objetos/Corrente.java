package br.com.poo.objetos;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import br.com.poo.classes.heranca.ContaCorrente;
import javax.swing.JTextArea;

public class Corrente extends JFrame {

	private JPanel contentPane;
	private JTextField txtNumeroBanco;
	private JTextField txtNumeroConta;
	private JTextField txtAgencia;
	private JTextField txtTitular;
	private JTextField txtSaldo;
	private JTextField txtLimite;
	private ContaCorrente corrente;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public Corrente() {
		corrente = new ContaCorrente();
		setTitle("Janela Corrente");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1094, 612);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 64, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel pnlMenu = new JPanel();
		pnlMenu.setBackground(new Color(255, 98, 21));
		pnlMenu.setBounds(0, 0, 200, 573);
		contentPane.add(pnlMenu);
		pnlMenu.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("BOX Operações");
		lblNewLabel.setIcon(new ImageIcon(Corrente.class.getResource("/br/com/poo/images/logobanco.png")));
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 19));
		lblNewLabel.setBounds(10, 40, 180, 36);
		pnlMenu.add(lblNewLabel);
		
		JLabel lblAbrirConta = new JLabel("Abrir Conta");
		
		lblAbrirConta.setIcon(new ImageIcon(Corrente.class.getResource("/br/com/poo/images/logoabrirconta.png")));
		lblAbrirConta.setFont(new Font("Segoe UI", Font.BOLD, 22));
		lblAbrirConta.setBounds(10, 150, 180, 36);
		pnlMenu.add(lblAbrirConta);
		
		JLabel lblSaldo = new JLabel("Verificar Saldo");
		
		lblSaldo.setEnabled(false);
		lblSaldo.setIcon(new ImageIcon(Corrente.class.getResource("/br/com/poo/images/logosaldo2.png")));
		lblSaldo.setFont(new Font("Segoe UI", Font.BOLD, 19));
		lblSaldo.setBounds(10, 213, 180, 36);
		pnlMenu.add(lblSaldo);
		
		JLabel lblSacar = new JLabel("Sacar");
		
		lblSacar.setEnabled(false);
		lblSacar.setIcon(new ImageIcon(Corrente.class.getResource("/br/com/poo/images/logosacar.png")));
		lblSacar.setFont(new Font("Segoe UI", Font.BOLD, 22));
		lblSacar.setBounds(10, 280, 180, 36);
		pnlMenu.add(lblSacar);
		
		JLabel lblDepositar = new JLabel("Depositar");
		lblDepositar.setEnabled(false);
		lblDepositar.setIcon(new ImageIcon(Corrente.class.getResource("/br/com/poo/images/logodepositar.png")));
		lblDepositar.setFont(new Font("Segoe UI", Font.BOLD, 22));
		lblDepositar.setBounds(10, 348, 180, 36);
		pnlMenu.add(lblDepositar);
		
		JLabel lblNewLabel_1 = new JLabel("Usuario");
		lblNewLabel_1.setIcon(new ImageIcon(Corrente.class.getResource("/br/com/poo/images/logoconta.png")));
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.BOLD, 22));
		lblNewLabel_1.setBounds(10, 474, 180, 36);
		pnlMenu.add(lblNewLabel_1);
		
		JPanel panel = new JPanel();
		panel.setBounds(210, 41, 425, 470);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Número do Banco");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel_2.setBounds(10, 11, 201, 47);
		panel.add(lblNewLabel_2);
		
		txtNumeroBanco = new JTextField();
		txtNumeroBanco.setFont(new Font("Tahoma", Font.PLAIN, 22));
		txtNumeroBanco.setBounds(10, 55, 405, 28);
		panel.add(txtNumeroBanco);
		txtNumeroBanco.setColumns(10);
		
		JLabel lblNewLabel_2_1 = new JLabel("Número da Conta");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel_2_1.setBounds(10, 81, 201, 47);
		panel.add(lblNewLabel_2_1);
		
		txtNumeroConta = new JTextField();
		txtNumeroConta.setFont(new Font("Tahoma", Font.PLAIN, 22));
		txtNumeroConta.setColumns(10);
		txtNumeroConta.setBounds(10, 116, 405, 28);
		panel.add(txtNumeroConta);
		
		JLabel lblNewLabel_2_2 = new JLabel("Agência");
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel_2_2.setBounds(10, 139, 201, 47);
		panel.add(lblNewLabel_2_2);
		
		txtAgencia = new JTextField();
		txtAgencia.setFont(new Font("Tahoma", Font.PLAIN, 22));
		txtAgencia.setColumns(10);
		txtAgencia.setBounds(10, 180, 405, 28);
		panel.add(txtAgencia);
		
		JLabel lblNewLabel_2_3 = new JLabel("Titular");
		lblNewLabel_2_3.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel_2_3.setBounds(10, 204, 201, 47);
		panel.add(lblNewLabel_2_3);
		
		txtTitular = new JTextField();
		txtTitular.setFont(new Font("Tahoma", Font.PLAIN, 22));
		txtTitular.setColumns(10);
		txtTitular.setBounds(10, 247, 405, 36);
		panel.add(txtTitular);
		
		JLabel lblNewLabel_2_3_1 = new JLabel("Saldo");
		lblNewLabel_2_3_1.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel_2_3_1.setBounds(10, 277, 201, 47);
		panel.add(lblNewLabel_2_3_1);
		
		txtSaldo = new JTextField();
		txtSaldo.setFont(new Font("Tahoma", Font.PLAIN, 22));
		txtSaldo.setColumns(10);
		txtSaldo.setBounds(10, 317, 405, 33);
		panel.add(txtSaldo);
		
		JLabel lblNewLabel_2_3_1_1 = new JLabel("Limite");
		lblNewLabel_2_3_1_1.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel_2_3_1_1.setBounds(10, 344, 201, 47);
		panel.add(lblNewLabel_2_3_1_1);
		
		txtLimite = new JTextField();
		txtLimite.setFont(new Font("Tahoma", Font.PLAIN, 22));
		txtLimite.setColumns(10);
		txtLimite.setBounds(10, 387, 405, 33);
		panel.add(txtLimite);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(645, 41, 423, 470);
		contentPane.add(scrollPane);
		
		JTextArea txtResultado = new JTextArea();
		txtResultado.setFont(new Font("Monospaced", Font.PLAIN, 20));
		scrollPane.setViewportView(txtResultado);
	
		lblAbrirConta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
					
					if(
							txtNumeroBanco.getText().trim().equals("") ||
							txtAgencia.getText().trim().equals("") ||
							txtNumeroConta.getText().trim().equals("") ||
							txtTitular.getText().trim().equals("") ||
							txtSaldo.getText().trim().equals("") ||
							txtLimite.getText().trim().equals("")){
						JOptionPane.showMessageDialog(null, "Os campos devem ser preenchidos", "Erro", JOptionPane.ERROR_MESSAGE);
							}
					else {
						
						corrente.setNumeroBanco(Long.parseLong(txtNumeroBanco.getText()));
						corrente.setAgencia(Integer.parseInt(txtAgencia.getText()));
						corrente.setNumeroConta(Long.parseLong(txtNumeroConta.getText()));
						corrente.setTitular(txtTitular.getText());
						corrente.setSaldo(Double.parseDouble(txtSaldo.getText()));
						corrente.setLimite(Double.parseDouble(txtLimite.getText()));
						
						//habilitar os botoes de saque, saldo, deposito
						lblSaldo.setEnabled(true);
						lblSacar.setEnabled(true);
						lblDepositar.setEnabled(true);
						
						//desabilitar as caixas com os dados da conta
						
						txtNumeroBanco.setEnabled(false);
						txtNumeroConta.setEnabled(false);
						txtAgencia.setEnabled(false);
						txtTitular.setEnabled(false);
						txtSaldo.setEnabled(false);
						txtLimite.setEnabled(false);
						txtResultado.setText("A conta foi criada com sucesso");
						
					}
					
			}
		});
		
		lblSaldo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
					
					txtResultado.setText(txtResultado.getText()+"\n\n"+corrente.verificarSaldo());
					
				
			}
		});
		
		lblDepositar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
					
					String valor = JOptionPane.showInputDialog("Digeite o valor do deposito");
					txtResultado.setText(txtResultado.getText()+"\n\n"+corrente.depositar(Double.parseDouble(valor)));
					
			}
		});
		
		lblSacar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
					
					String valor = JOptionPane.showInputDialog("Digeite o valor de saque");
					txtResultado.setText(txtResultado.getText()+"\n\n"+corrente.sacar(Double.parseDouble(valor)));
					
			}
		});
	
	}
}
