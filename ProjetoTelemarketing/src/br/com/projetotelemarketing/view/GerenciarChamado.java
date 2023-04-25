package br.com.projetotelemarketing.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import br.com.projetotelemarketing.dao.CRUDTelemarketing;
import br.com.projetotelemarketing.domain.Chamado;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class GerenciarChamado extends JFrame {

	private JPanel contentPane;
	private JTextField txtFuncionario;
	private JTextField txtDataResolucao;
	private JTextField txtStatus;
	private JTextField txtObservacao;
	private Long id;
	
	private JButton btnApagar;
	private JButton btnAtualizar;
	
	private JLabel lblObservacoes;
	private JLabel lblStatus;
	private JLabel lblDataResolucao;
	private JLabel lblFuncionario;
	private JLabel lblCabecalho;
	private JLabel lblLogo;
	private JPanel panel;

	CRUDTelemarketing cc = new CRUDTelemarketing();
	private JScrollPane scrollPane;
	private JTable table;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GerenciarChamado frame = new GerenciarChamado();
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
	public GerenciarChamado() {
		setBackground(new Color(255, 74, 74));
		setTitle("Chamados");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 742, 628);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = new JPanel();
		panel.setBackground(new Color(41, 7, 175));
		panel.setBounds(0, 0, 884, 80);
		contentPane.add(panel);
		panel.setLayout(null);
		
		lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon(GerenciarChamado.class.getResource("/br/com/projetotelemarketing/images/logo2.png")));
		lblLogo.setBounds(420, 11, 50, 59);
		panel.add(lblLogo);
		
		lblCabecalho = new JLabel("Bem vindo ao suporte da Eletronic Arts preencha os dados para receber o suporte");
		lblCabecalho.setFont(new Font("Segoe UI Semibold", Font.BOLD, 17));
		lblCabecalho.setForeground(Color.WHITE);
		lblCabecalho.setBounds(31, 77, 651, 45);
		contentPane.add(lblCabecalho);
		
		lblFuncionario = new JLabel("Funcionario");
		lblFuncionario.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 20));
		lblFuncionario.setForeground(Color.WHITE);
		lblFuncionario.setBounds(21, 124, 210, 45);
		contentPane.add(lblFuncionario);
		
		txtFuncionario = new JTextField();
		txtFuncionario.setColumns(10);
		txtFuncionario.setBounds(21, 160, 239, 27);
		contentPane.add(txtFuncionario);
		
		lblDataResolucao = new JLabel("Data de Resolução");
		lblDataResolucao.setForeground(Color.WHITE);
		lblDataResolucao.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 20));
		lblDataResolucao.setBounds(21, 194, 190, 27);
		contentPane.add(lblDataResolucao);
		
		txtDataResolucao = new JTextField();
		txtDataResolucao.setBounds(21, 220, 158, 28);
		contentPane.add(txtDataResolucao);
		txtDataResolucao.setColumns(10);
		
		lblStatus = new JLabel("Status");
		lblStatus.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 20));
		lblStatus.setForeground(Color.WHITE);
		lblStatus.setBounds(306, 133, 158, 27);
		contentPane.add(lblStatus);
		
		txtStatus = new JTextField();
		txtStatus.setBounds(306, 158, 283, 79);
		contentPane.add(txtStatus);
		txtStatus.setColumns(10);
		
		lblObservacoes = new JLabel("Observações");
		lblObservacoes.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 20));
		lblObservacoes.setForeground(Color.WHITE);
		lblObservacoes.setBounds(31, 259, 136, 27);
		contentPane.add(lblObservacoes);
		
		txtObservacao = new JTextField();
		txtObservacao.setBounds(21, 289, 283, 142);
		contentPane.add(txtObservacao);
		txtObservacao.setColumns(10);
		
		btnAtualizar = new JButton("Atualizar ");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				graChamado.setTitulo(txtTitulo.getText());
				cadcurso.setDescricao(txtDescricao.getText());
				cadcurso.setHorarioinicio(txtHoraInicio.getText());
				cadcurso.setHorariotermino(txtHoraTermino.getText());
				cadcurso.setDatainicio(Date.valueOf(txtDataInicio.getText()));
				cadcurso.setDatatermino(Date.valueOf(txtDataTermino.getText()));
				
				JOptionPane.showMessageDialog(null, cc.gravar(graChamado));
				CarregarTabela();
				LimparCampos();
				
			}
		});
		btnAtualizar.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 22));
		btnAtualizar.setBackground(new Color(255, 255, 0));
		btnAtualizar.setBounds(314, 289, 210, 59);
		contentPane.add(btnAtualizar);
		
		btnApagar = new JButton("Apagar Chamado");
		btnApagar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(id.equals(null)) {
					JOptionPane.showMessageDialog(null, "Selecione um chamado para apagar");
				}
				else {
						if(JOptionPane.showConfirmDialog(null,"Você realmente quer apagar o chamado ?", "ATENÇÃO!!", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE)==0) {
							
						}
					Chamado ac = new Chamado();
					ac.setIdchamado(id);
					JOptionPane.showMessageDialog(null, cc.apagar(ac));
					CarregarTabela();
					LimparCampos();
					
				}
			
			}
		});
		
		btnApagar.setBackground(new Color(255, 0, 0));
		btnApagar.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 20));
		btnApagar.setBounds(314, 372, 210, 59);
		contentPane.add(btnApagar);
	}
		
		private void CarregarTabela() {
			
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(21, 438, 695, 140);
		contentPane.add(scrollPane);
		
		String[] cabecalho = {
				"Id Chamado","Nome da pessoa","departamento","descricao", "Funcionario", "Status Chamado",
				"Data Abertura","Data Resolucao","Observacao"
	};
	
	Object[][] dados = new Object[cc.listar().size()][4];
	
	for(int i = 0 ; i < dados.length ; i++) {
		dados[i][0] = cc.listar().get(i).getIdchamado();
		dados[i][1] = cc.listar().get(i).getFuncionario();
		dados[i][2] = cc.listar().get(i).getDataResolucao();
		dados[i][3] = cc.listar().get(i).getStatuschamada();
		dados[i][4] = cc.listar().get(i).getObservacao();
	}
	
	DefaultTableModel model = new DefaultTableModel(dados, cabecalho);
		
		table = new JTable(model);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
					
					txtFuncionario.setText(String.valueOf(table.getValueAt(table.getSelectedRow(),1)));
					txtDataResolucao.setText(String.valueOf(table.getValueAt(table.getSelectedRow(),2)));
					txtStatus.setText(String.valueOf(table.getValueAt(table.getSelectedRow(),3)));
					txtObservacao.setText(String.valueOf(table.getValueAt(table.getSelectedRow(),4)));
					id = Long.parseLong(String.valueOf(table.getValueAt(table.getSelectedRow(),0)));
							
			}
		});
		scrollPane.setViewportView(table);
	}
		private void LimparCampos() {
	
		txtFuncionario.setText("");
		txtDataResolucao.setText("");
		txtStatus.setText("");
		txtObservacao.setText("");
	
}
}
