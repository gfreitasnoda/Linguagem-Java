package br.com.ProjetoAtividade.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import br.com.ProjetoAtividade.dao.CRUDChamados;
import br.com.ProjetoAtividade.domain.Chamados;

public class SolicitacaoSuporte extends JFrame {

	
	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtDescricao;
	private JTextField txtDepartamento;
	JFormattedTextField txtData;
	CRUDChamados cc = new CRUDChamados();
	
	MaskFormatter ds;
	
	JButton btnEnviar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SolicitacaoSuporte frame = new SolicitacaoSuporte();
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
	public SolicitacaoSuporte() {
		
		try {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 744, 459);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(64, 0, 64));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Solicitação de Suporte");
		lblNewLabel.setFont(new Font("Swis721 WGL4 BT", Font.PLAIN, 25));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(207, 11, 468, 51);
		contentPane.add(lblNewLabel);
		
		JLabel lblNomeDoSolicitante = new JLabel("Nome do solicitante");
		lblNomeDoSolicitante.setForeground(Color.WHITE);
		lblNomeDoSolicitante.setFont(new Font("Swis721 WGL4 BT", Font.BOLD, 20));
		lblNomeDoSolicitante.setBounds(5, 58, 231, 42);
		contentPane.add(lblNomeDoSolicitante);
		
		txtNome = new JTextField();
		txtNome.setFont(new Font("Verdana", Font.BOLD, 18));
		txtNome.setBounds(5, 96, 231, 31);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		JLabel lblDescricao = new JLabel("Descricação do problema");
		lblDescricao.setForeground(Color.WHITE);
		lblDescricao.setFont(new Font("Swis721 WGL4 BT", Font.BOLD, 18));
		lblDescricao.setBounds(5, 138, 248, 42);
		contentPane.add(lblDescricao);
		
		txtDescricao = new JTextField();
		txtDescricao.setBounds(5, 176, 231, 110);
		contentPane.add(txtDescricao);
		txtDescricao.setColumns(10);
		
		JLabel lblDataDeSolicitao = new JLabel("Data de solicitação");
		lblDataDeSolicitao.setForeground(Color.WHITE);
		lblDataDeSolicitao.setFont(new Font("Swis721 WGL4 BT", Font.BOLD, 20));
		lblDataDeSolicitao.setBounds(5, 305, 231, 42);
		contentPane.add(lblDataDeSolicitao);
		
		ds = new MaskFormatter("####-##-##");
		ds.setPlaceholderCharacter('_');
		
		txtData = new JFormattedTextField(ds);
		txtData.setBounds(5, 340, 177, 31);
		contentPane.add(txtData);
		
		JLabel lblAno = new JLabel("Ano -");
		lblAno.setForeground(Color.WHITE);
		lblAno.setFont(new Font("Swis721 WGL4 BT", Font.BOLD, 20));
		lblAno.setBounds(5, 367, 83, 42);
		contentPane.add(lblAno);
		
		JLabel lblAno_1 = new JLabel("Mês -");
		lblAno_1.setForeground(Color.WHITE);
		lblAno_1.setFont(new Font("Swis721 WGL4 BT", Font.BOLD, 20));
		lblAno_1.setBounds(64, 367, 83, 42);
		contentPane.add(lblAno_1);
		
		JLabel lblAno_1_1 = new JLabel("Dia ");
		lblAno_1_1.setForeground(Color.WHITE);
		lblAno_1_1.setFont(new Font("Swis721 WGL4 BT", Font.BOLD, 20));
		lblAno_1_1.setBounds(124, 368, 83, 42);
		contentPane.add(lblAno_1_1);
		
		JButton btnEnviar = new JButton("Enviar");
		
		
		btnEnviar.setBackground(new Color(255, 255, 255));
		btnEnviar.setFont(new Font("Swis721 WGL4 BT", Font.BOLD, 20));
		btnEnviar.setBounds(486, 364, 226, 42);
		contentPane.add(btnEnviar);
		
		JLabel lblDepartamentoSolicitado = new JLabel("Departamento Solicitado");
		lblDepartamentoSolicitado.setForeground(Color.WHITE);
		lblDepartamentoSolicitado.setFont(new Font("Swis721 WGL4 BT", Font.BOLD, 18));
		lblDepartamentoSolicitado.setBounds(276, 60, 231, 42);
		contentPane.add(lblDepartamentoSolicitado);
		
		txtDepartamento = new JTextField();
		txtDepartamento.setFont(new Font("Verdana", Font.BOLD, 18));
		txtDepartamento.setColumns(10);
		txtDepartamento.setBounds(270, 94, 231, 31);
		contentPane.add(txtDepartamento);
		
		btnEnviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Chamados cadChamado = new Chamados();
				if(txtNome.getText().trim().equals("")
					||txtDescricao.getText().trim().equals("")
					||txtDepartamento.getText().trim().equals("")
					||txtData.getText().trim().equals("")
					
						
						
						
						
				
						
				) {
					JOptionPane.showMessageDialog(null, "Precisamos que você descreva o seu problema e preencha todos os campos.","Erro",JOptionPane.ERROR_MESSAGE);
				}
				else {
					cadChamado.setNomepessoa(txtNome.getText());
					cadChamado.setDescricao(txtDescricao.getText());
					cadChamado.setDepartamento(txtDepartamento.getText());
					cadChamado.setDataSolicitacao(Date.valueOf(txtData.getText()));
					cadChamado.setStatusChamado("Pendente");
					
					JOptionPane.showMessageDialog(null, cc.gravar(cadChamado));
					
					limparCampos();
					
					
				}
					
					
					
				
			}
			
			
		
		});
		
		
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	
	
	
	
	private void limparCampos() {
		
		txtNome.setText("");
		txtDepartamento.setText("");
		txtDescricao.setText("");
		txtData.setText("");
	}
}
