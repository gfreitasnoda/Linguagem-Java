package br.com.projetotelemarketing.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import br.com.projetotelemarketing.dao.CRUDTelemarketing;
import br.com.projetotelemarketing.domain.Chamado;
import br.com.projetotelemarketing.util.AcessoSSH;

public class FazerChamado extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtDepartamento;
	private JTextField txtDataAbertura;
	private JTextArea txtDescricao;
	private JButton btnChamado;
	private Long id =  null;

	CRUDTelemarketing cc = new CRUDTelemarketing();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FazerChamado frame = new FazerChamado();
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
	public FazerChamado() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(FazerChamado.class.getResource("/br/com/projetotelemarketing/images/logo2.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 690, 626);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(41, 7, 175));
		panel.setBounds(0, 0, 884, 80);
		contentPane.add(panel);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(FazerChamado.class.getResource("/br/com/projetotelemarketing/images/logo2.png")));
		lblNewLabel.setBounds(290, 11, 50, 59);
		panel.add(lblNewLabel);
		
		JLabel lblCabecalho = new JLabel("Bem vindo ao suporte da Eletronic Arts preencha os dados para receber o suporte");
		lblCabecalho.setForeground(Color.WHITE);
		lblCabecalho.setFont(new Font("Segoe UI Semibold", Font.BOLD, 17));
		lblCabecalho.setBounds(25, 91, 651, 45);
		contentPane.add(lblCabecalho);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 20));
		lblNome.setForeground(Color.WHITE);
		lblNome.setBounds(10, 167, 139, 45);
		contentPane.add(lblNome);
		
		txtNome = new JTextField();
		txtNome.setBounds(10, 207, 237, 45);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		JLabel lblDepartamento = new JLabel("Departamento");
		lblDepartamento.setForeground(Color.WHITE);
		lblDepartamento.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 20));
		lblDepartamento.setBounds(10, 242, 139, 45);
		contentPane.add(lblDepartamento);
		
		txtDepartamento = new JTextField();
		txtDepartamento.setColumns(10);
		txtDepartamento.setBounds(10, 285, 237, 45);
		contentPane.add(txtDepartamento);
		
		JLabel lblDescricao = new JLabel("Descrição");
		lblDescricao.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 20));
		lblDescricao.setForeground(Color.WHITE);
		lblDescricao.setBounds(10, 324, 139, 45);
		contentPane.add(lblDescricao);
		
		txtDescricao = new JTextArea();
		txtDescricao.setBounds(10, 361, 417, 200);
		contentPane.add(txtDescricao);
		
		btnChamado = new JButton("Solicitar \r\nChamado");
		btnChamado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Chamado graChamado = new Chamado();
				if(txtNome.getText().trim().equals("")
						|| txtDepartamento.getText().trim().equals("")
						|| txtDescricao.getText().trim().equals("")
						|| txtDataAbertura.getText().trim().equals("")
							) {
						JOptionPane.showMessageDialog(null, "Você precisa preencher todos os campos requisitados","Erro", JOptionPane.ERROR_MESSAGE);
				}
				else {
					graChamado.setNomepessoa(txtNome.getText());
					graChamado.setDepartamento(txtDepartamento.getText());
					graChamado.setDescricao(txtDescricao.getText());
					graChamado.setDataAbertura(Date.valueOf(txtDataAbertura.getText()));
					graChamado.setIdchamado(id);
					
					JOptionPane.showMessageDialog(null, cc.registrar(graChamado));
					
					LimparCampos();
					
				}
			
		}
	});
				
		btnChamado.setBackground(new Color(0, 128, 0));
		btnChamado.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 20));
		btnChamado.setBounds(461, 361, 203, 200);
		contentPane.add(btnChamado);
		
		JLabel lblNewLabel_1 = new JLabel("Data de Abertura");
		lblNewLabel_1.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 20));
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(317, 167, 167, 45);
		contentPane.add(lblNewLabel_1);

		txtDataAbertura = new JTextField();
		txtDataAbertura.setBounds(317, 207, 167, 45);
		contentPane.add(txtDataAbertura);
		txtDataAbertura.setColumns(10);
		
		JButton btnGrafico = new JButton("Abrir Grafico");
		btnGrafico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					AcessoSSH assh = new AcessoSSH();
					assh.executar();
				
			}
		});
		btnGrafico.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 20));
		btnGrafico.setBackground(Color.WHITE);
		btnGrafico.setBounds(461, 264, 203, 80);
		contentPane.add(btnGrafico);
	}
	
	private void LimparCampos() {
		
		txtNome.setText("");
		txtDescricao.setText("");
		txtDepartamento.setText("");
		txtDataAbertura.setText("");
	
}
}
