package br.com.ProjetoEscola.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import br.com.ProjetoEscola.dao.CRUDCurso;
import br.com.ProjetoEscola.domain.Curso;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GerenciarCurso extends JFrame {

	private JPanel contentPane;
	private final JScrollPane scrollPane = new JScrollPane();
	private JTextField txtTitulo;
	private JButton btnCadastrar;
	private JButton btnAtualizar;
	private JButton btnConsultar;
	private JTextArea txtDescricao;
	private JButton btnDeletar;
	
	private JLabel lblNewLabel;
	private JLabel lblDescrioDoCurso;
	private JLabel lblNewLabel_1;
	private JLabel lblDataInicio;
	private JLabel lblDataTermino;
	private JLabel lblHoraInício;
	private JLabel lblHoraTermino;
	private JLabel lblNewLabel_2;
	
	
	private JFormattedTextField txtDataInicio;
	private JFormattedTextField txtDataTermino;
	private JFormattedTextField txtHoraInicio;
	private JFormattedTextField txtHoraTermino;
	private Long id = null;
	
	MaskFormatter di;
	MaskFormatter dt;
	MaskFormatter hi;
	MaskFormatter ht;
	CRUDCurso cc = new CRUDCurso();
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GerenciarCurso frame = new GerenciarCurso();
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
	public GerenciarCurso() {
		
		try {
		
		
		
		setTitle("Gerenciar Cursos");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 867, 536);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		txtTitulo = new JTextField();
		txtTitulo.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 17));
		txtTitulo.setBounds(127, 80, 209, 30);
		contentPane.add(txtTitulo);
		txtTitulo.setColumns(10);
		
		lblNewLabel = new JLabel("Titulo do Curso:");
		lblNewLabel.setFont(new Font("Segoe UI Light", Font.PLAIN, 17));
		lblNewLabel.setBounds(10, 71, 139, 48);
		contentPane.add(lblNewLabel);
		
		lblDescrioDoCurso = new JLabel("Descrição do Curso:");
		lblDescrioDoCurso.setFont(new Font("Segoe UI Light", Font.PLAIN, 17));
		lblDescrioDoCurso.setBounds(10, 104, 189, 48);
		contentPane.add(lblDescrioDoCurso);
		
		txtDescricao = new JTextArea();
		txtDescricao.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 17));
		txtDescricao.setBounds(10, 149, 326, 202);
		contentPane.add(txtDescricao);
		txtDescricao.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		
		lblNewLabel_1 = new JLabel("GERENCIADOR DE CURSO");
		lblNewLabel_1.setFont(new Font("Segoe UI Semibold", Font.BOLD, 23));
		lblNewLabel_1.setBounds(310, 11, 284, 41);
		contentPane.add(lblNewLabel_1);
		
		lblDataInicio = new JLabel("Data de Início:");
		lblDataInicio.setFont(new Font("Segoe UI Light", Font.PLAIN, 17));
		lblDataInicio.setBounds(363, 71, 189, 48);
		contentPane.add(lblDataInicio);
		
		MaskFormatter di = new MaskFormatter("####-##-##");
		di.setPlaceholderCharacter('_');
		
		
		txtDataInicio = new JFormattedTextField(di);
		txtDataInicio.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 17));
		txtDataInicio.setBounds(470, 84, 124, 29);
		contentPane.add(txtDataInicio);
		
		lblDataTermino = new JLabel("Data de Termino:");
		lblDataTermino.setFont(new Font("Segoe UI Light", Font.PLAIN, 17));
		lblDataTermino.setBounds(363, 114, 189, 48);
		contentPane.add(lblDataTermino);
		
		MaskFormatter dt = new MaskFormatter("####-##-##");
		dt.setPlaceholderCharacter('_');
		
		txtDataTermino = new JFormattedTextField(dt);
		txtDataTermino.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 17));
		txtDataTermino.setBounds(491, 123, 103, 29);
		contentPane.add(txtDataTermino);
		
		lblHoraInício = new JLabel("Horário de Início:");
		lblHoraInício.setFont(new Font("Segoe UI Light", Font.PLAIN, 17));
		lblHoraInício.setBounds(363, 173, 189, 48);
		contentPane.add(lblHoraInício);
		
		MaskFormatter hi = new MaskFormatter("##h:##");
		hi.setPlaceholderCharacter('_');
		
		txtHoraInicio = new JFormattedTextField(hi);
		txtHoraInicio.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 17));
		txtHoraInicio.setBounds(491, 186, 103, 29);
		contentPane.add(txtHoraInicio);
		
		lblHoraTermino = new JLabel("Horário de Termino:");
		lblHoraTermino.setFont(new Font("Segoe UI Light", Font.PLAIN, 17));
		lblHoraTermino.setBounds(363, 212, 189, 48);
		contentPane.add(lblHoraTermino);
		
		MaskFormatter ht = new MaskFormatter("##h:##");
		ht.setPlaceholderCharacter('_');
		
		txtHoraTermino = new JFormattedTextField(ht);
		txtHoraTermino.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 16));
		txtHoraTermino.setBounds(512, 225, 82, 29);
		contentPane.add(txtHoraTermino);
		
		carregarTabela();
		
		btnCadastrar = new JButton("Cadastrar");

		btnCadastrar.setBackground(new Color(0, 128, 64));
		btnCadastrar.setFont(new Font("Malgun Gothic", Font.BOLD, 16));
		btnCadastrar.setBounds(363, 271, 113, 80);
		contentPane.add(btnCadastrar);
		
		btnAtualizar = new JButton("Atualizar\r\n");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				Curso cadcurso = new Curso();
				if(txtTitulo.getText().trim().equals("")
						|| txtDescricao.getText().trim().equals("")
						|| txtHoraInicio.getText().trim().equals("")
						|| txtHoraTermino.getText().trim().equals("")
						|| txtDataInicio.getText().trim().equals("")
						|| txtDataTermino.getText().trim().equals("")
							) {
						JOptionPane.showMessageDialog(null, "Você precisa preendher todos os campos requisitados","Erro", JOptionPane.ERROR_MESSAGE);
				}
				else {
					cadcurso.setTitulo(txtTitulo.getText());
					cadcurso.setDescricao(txtDescricao.getText());
					cadcurso.setHorarioinicio(txtHoraInicio.getText());
					cadcurso.setHorariotermino(txtHoraTermino.getText());
					cadcurso.setDatainicio(Date.valueOf(txtDataInicio.getText()));
					cadcurso.setDatatermino(Date.valueOf(txtDataTermino.getText()));
					cadcurso.setIdcurso(id);
					
					
					JOptionPane.showMessageDialog(null, cc.atualizar(cadcurso).getTitulo()+ " foi atualizado ");
					carregarTabela();
					
					LimparCampos();
					
				}
				
				
				
				
			
			}
		});
		btnAtualizar.setBackground(new Color(0, 128, 255));
		btnAtualizar.setFont(new Font("Malgun Gothic", Font.BOLD, 16));
		btnAtualizar.setBounds(491, 271, 103, 80);
		contentPane.add(btnAtualizar);
		
		btnConsultar = new JButton("Consultar\r\n");
		btnConsultar.setBackground(new Color(255, 255, 128));
		btnConsultar.setFont(new Font("Malgun Gothic", Font.BOLD, 16));
		btnConsultar.setBounds(604, 271, 113, 80);
		contentPane.add(btnConsultar);
		
		btnDeletar = new JButton("Deletar\r\n");
		btnDeletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				if(id.equals(null)) {
					JOptionPane.showMessageDialog(null, "Selecione um curso para apagar");
				}
				else {
						if(JOptionPane.showConfirmDialog(null,"Você realmente quer apagar o curso ?", "ATENÇÃO!!", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE)==0) {
							
						}
					Curso cr = new Curso();
					cr.setIdcurso(id);
					JOptionPane.showMessageDialog(null, cc.apagar(cr));
					carregarTabela();
					LimparCampos();
				}
			
			}
		});
		btnDeletar.setBackground(new Color(255, 0, 0));
		btnDeletar.setFont(new Font("Malgun Gothic", Font.BOLD, 16));
		btnDeletar.setBounds(727, 271, 113, 80);
		contentPane.add(btnDeletar);
		
		lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon(GerenciarCurso.class.getResource("/br/com/ProjetoEscola/images/logocurso2.png")));
		lblNewLabel_2.setBounds(604, 34, 237, 226);
		contentPane.add(lblNewLabel_2);
		
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					
					Curso cadcurso = new Curso();
					if(txtTitulo.getText().trim().equals("")
							|| txtDescricao.getText().trim().equals("")
							|| txtHoraInicio.getText().trim().equals("")
							|| txtHoraTermino.getText().trim().equals("")
							|| txtDataInicio.getText().trim().equals("")
							|| txtDataTermino.getText().trim().equals("")
								) {
							JOptionPane.showMessageDialog(null, "Você precisa preendher todos os campos requisitados","Erro", JOptionPane.ERROR_MESSAGE);
					}
					else {
						cadcurso.setTitulo(txtTitulo.getText());
						cadcurso.setDescricao(txtDescricao.getText());
						cadcurso.setHorarioinicio(txtHoraInicio.getText());
						cadcurso.setHorariotermino(txtHoraTermino.getText());
						cadcurso.setDatainicio(Date.valueOf(txtDataInicio.getText()));
						cadcurso.setDatatermino(Date.valueOf(txtDataTermino.getText()));
						
						JOptionPane.showMessageDialog(null, cc.gravar(cadcurso));
						carregarTabela();
						
						LimparCampos();
						
					}
				
			}
		});
		
		
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
		}
	private void carregarTabela() {
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 362, 831, 124);
		contentPane.add(scrollPane);
		
		String[] cabecalho = {
					"Id Curso", "Titulo do Curso", "Descrição do Curso",
					"Data de Início","Data de Término", "Horário de Início","Horário Término"
		};
		
		Object[][] dados = new Object[cc.listar().size()][7];
		
		for(int i = 0 ; i < dados.length ; i++) {
			dados[i][0] = cc.listar().get(i).getIdcurso();
			dados[i][1] = cc.listar().get(i).getTitulo();
			dados[i][2] = cc.listar().get(i).getDescricao();
			dados[i][3] = cc.listar().get(i).getDatainicio();
			dados[i][4] = cc.listar().get(i).getDatatermino();
			dados[i][5] = cc.listar().get(i).getHorarioinicio();
			dados[i][6] = cc.listar().get(i).getHorariotermino();
		}
		
		DefaultTableModel model = new DefaultTableModel(dados, cabecalho);
		
		JTable table = new JTable(model);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
					
					txtTitulo.setText(String.valueOf(table.getValueAt(table.getSelectedRow(),1)));
					txtDescricao.setText(String.valueOf(table.getValueAt(table.getSelectedRow(),2)));
					txtDataInicio.setText(String.valueOf(table.getValueAt(table.getSelectedRow(),3)));
					txtDataTermino.setText(String.valueOf(table.getValueAt(table.getSelectedRow(),4)));
					txtHoraInicio.setText(String.valueOf(table.getValueAt(table.getSelectedRow(),5)));
					txtHoraTermino.setText(String.valueOf(table.getValueAt(table.getSelectedRow(),6)));
					id = Long.parseLong(String.valueOf(table.getValueAt(table.getSelectedRow(),0)));
							
			}
		});
		scrollPane.setViewportView(table);
	}
	
	private void LimparCampos() {
		
		txtTitulo.setText("");
		txtDescricao.setText("");
		txtDataInicio.setText("");
		txtDataTermino.setText("");
		txtHoraInicio.setText("");
		txtHoraTermino.setText("");
		
		
	}
	
}
