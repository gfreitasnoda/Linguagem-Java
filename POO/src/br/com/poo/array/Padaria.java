package br.com.poo.array;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Padaria extends JFrame {

	private JPanel contentPane;
	private JTextField txtCodigoProduto;
	private JTextField txtCodigoBarras;
	private final JSeparator separator_1 = new JSeparator();
	private JTextField txtdescricao;
	private JTextField txtValorUni;
	private JTextField txtQuantidade;
	private JTextField txtTotalItens;
	private JTextField txtSubtotal;
	private JTextArea txtNota;
	private String cabecalho;
	private int item;
	private double valorPagar;
	private JLabel lblValorPagar; 

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Padaria frame = new Padaria();
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
	public Padaria() {
		
		valorPagar = 0.0;
		item =1;	
		
		cabecalho = "\t\t\tMultipão\n\t\t\tPadaria"+
									"\n\t\tPraça Santa Luiza de Marillac, 182 - Jardim Guançã" +
									"\n\t\t             02150-000 - São Paulo - SP" +
									"\n\t\t                     68.887.686/0001-18" +
									"\n\t\t                     IE :682.057.976.994"+
									"\n\t\t                     IM:1.046.973/001-0"+
									"\n------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------"+
									"\n\t\t\tCUPOM FISCAL"+
									"\nITEM\tCÓDIGO\tDESCRIÇÃO\t\tQTD\tVL.UNIT.\tVL.TOTAL"+
									"\n------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------";
									
			
		
			String[][] produtos = {
						
					{"2023","Pão Francês","13.00","17032023"},
					{"2024","Pão de Leite","15.00","14032024"},
					{"2025","Torta de Frango","50.00","17032025"},
					{"2026","Leite Integral A","5.00","17032026"},
					{"2027","Manteiga", "5.00","17032027"},
					{"2028","Bolo","20.00","17032028"},
					{"2029","Bauru","12.00","17032029"},
					{"2030","Suco de Laranja","7.00","17032030"}
						
			};
		
		
		
		
		
		
		setTitle("Janela Padaria");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1600, 900);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel pnlEsquerdo = new JPanel();
		pnlEsquerdo.setBackground(new Color(128, 0, 0));
		pnlEsquerdo.setBounds(0, 0, 800, 700);
		contentPane.add(pnlEsquerdo);
		pnlEsquerdo.setLayout(null);
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setBounds(0, 0, 800, 300);
		
		lblLogo.setIcon(new ImageIcon(new ImageIcon(Padaria.class.getResource("/br/com/poo/images/download (1).png")).getImage().getScaledInstance(lblLogo.getWidth(), lblLogo.getHeight(), Image.SCALE_SMOOTH)));
		pnlEsquerdo.add(lblLogo);
		
		JLabel lblCodigoProduto = new JLabel("Código do Produto:");
		lblCodigoProduto.setForeground(new Color(255, 128, 0));
		lblCodigoProduto.setFont(new Font("Verdana", Font.PLAIN, 20));
		lblCodigoProduto.setBounds(10, 300, 213, 61);
		pnlEsquerdo.add(lblCodigoProduto);
		
		JLabel lblCodigoBarras = new JLabel("Código de Barras:");
		lblCodigoBarras.setForeground(new Color(255, 128, 0));
		lblCodigoBarras.setFont(new Font("Verdana", Font.PLAIN, 20));
		lblCodigoBarras.setBounds(510, 300, 213, 61);
		pnlEsquerdo.add(lblCodigoBarras);
		
		txtCodigoProduto = new JTextField();
		txtCodigoProduto.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
			
					for(int linha = 0 ; linha < produtos.length ; linha++) {
						
						for(int coluna = 0 ; coluna < produtos[0].length; coluna++) {
								if(txtCodigoProduto.getText().equals(produtos[linha][0])) {
									txtCodigoBarras.setText(produtos[linha][3]);
									txtdescricao.setText(produtos[linha][1]);
									txtValorUni.setText(produtos[linha][2]);
									break;
								}
						}
					}
			}
		});
		txtCodigoProduto.setForeground(new Color(255, 255, 255));
		txtCodigoProduto.setFont(new Font("Verdana", Font.PLAIN, 20));
		txtCodigoProduto.setBackground(new Color(128, 0, 0));
		txtCodigoProduto.setBounds(10, 350, 213, 32);
		pnlEsquerdo.add(txtCodigoProduto);
		txtCodigoProduto.setColumns(10);
		txtCodigoProduto.setBorder(null);
		
		txtCodigoBarras = new JTextField();
		txtCodigoBarras.setForeground(new Color(255, 255, 255));
		txtCodigoBarras.setFont(new Font("Verdana", Font.PLAIN, 20));
		txtCodigoBarras.setBackground(new Color(128, 0, 0));
		txtCodigoBarras.setColumns(10);
		txtCodigoBarras.setBounds(510, 350, 213, 32);
		pnlEsquerdo.add(txtCodigoBarras);
		separator_1.setBounds(0, 413, 800, 2);
		txtCodigoBarras.setBorder(null);
		pnlEsquerdo.add(separator_1);
		
		JLabel lblDescricao = new JLabel("Descrição:");
		lblDescricao.setForeground(new Color(255, 128, 0));
		lblDescricao.setFont(new Font("Verdana", Font.PLAIN, 20));
		lblDescricao.setBounds(10, 403, 213, 61);
		pnlEsquerdo.add(lblDescricao);
		
		txtdescricao = new JTextField();
		txtdescricao.setForeground(new Color(255, 255, 255));
		txtdescricao.setFont(new Font("Verdana", Font.PLAIN, 20));
		txtdescricao.setColumns(10);
		txtdescricao.setBackground(new Color(128, 0, 0));
		txtdescricao.setBounds(10, 448, 780, 32);
		txtdescricao.setBorder(null);
		pnlEsquerdo.add(txtdescricao);
		
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(365, 330, 2, 72);
		pnlEsquerdo.add(separator);
		
		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setBounds(0, 491, 800, 2);
		pnlEsquerdo.add(separator_1_1);
		
		JLabel lblValorUnitrio = new JLabel("Valor Unitário:");
		lblValorUnitrio.setForeground(new Color(255, 128, 0));
		lblValorUnitrio.setFont(new Font("Verdana", Font.PLAIN, 17));
		lblValorUnitrio.setBounds(10, 475, 213, 61);
		pnlEsquerdo.add(lblValorUnitrio);
		
		txtValorUni = new JTextField();
		txtValorUni.setForeground(new Color(255, 255, 255));
		txtValorUni.setFont(new Font("Verdana", Font.PLAIN, 20));
		txtValorUni.setColumns(10);
		txtValorUni.setBackground(new Color(128, 0, 0));
		txtValorUni.setBounds(10, 518, 213, 32);
		txtValorUni.setBorder(null);
		pnlEsquerdo.add(txtValorUni);
		
		txtQuantidade = new JTextField();
		txtQuantidade.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				
				txtTotalItens.setText("" +
							Double.parseDouble(txtQuantidade.getText()) *
							Double.parseDouble(txtValorUni.getText())
						);
				
				txtSubtotal.setText("R$ " +
						Double.parseDouble(txtQuantidade.getText()) *
						Double.parseDouble(txtValorUni.getText())
					);
				
			}
		});
		txtQuantidade.setForeground(new Color(255, 255, 255));
		txtQuantidade.setFont(new Font("Verdana", Font.PLAIN, 20));
		txtQuantidade.setColumns(10);
		txtQuantidade.setBackground(new Color(128, 0, 0));
		txtQuantidade.setBounds(261, 518, 213, 32);
		txtQuantidade.setBorder(null);
		pnlEsquerdo.add(txtQuantidade);
		
		JLabel lblQuantidade = new JLabel("Quantidade:");
		lblQuantidade.setForeground(new Color(255, 128, 0));
		lblQuantidade.setFont(new Font("Verdana", Font.PLAIN, 17));
		lblQuantidade.setBounds(261, 475, 213, 61);
		pnlEsquerdo.add(lblQuantidade);
		
		JLabel lblTotalItens = new JLabel("Total Itens");
		lblTotalItens.setForeground(new Color(255, 128, 0));
		lblTotalItens.setFont(new Font("Verdana", Font.PLAIN, 17));
		lblTotalItens.setBounds(522, 475, 213, 61);
		pnlEsquerdo.add(lblTotalItens);
		
		txtTotalItens = new JTextField();
		txtTotalItens.setForeground(Color.WHITE);
		txtTotalItens.setFont(new Font("Verdana", Font.PLAIN, 20));
		txtTotalItens.setColumns(10);
		txtTotalItens.setBackground(new Color(128, 0, 0));
		txtTotalItens.setBounds(522, 518, 213, 32);
		txtTotalItens.setBorder(null);
		pnlEsquerdo.add(txtTotalItens);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setOrientation(SwingConstants.VERTICAL);
		separator_2.setBounds(243, 507, 2, 72);
		pnlEsquerdo.add(separator_2);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setOrientation(SwingConstants.VERTICAL);
		separator_3.setBounds(497, 507, 2, 72);
		pnlEsquerdo.add(separator_3);
		
		JSeparator separator_1_1_1 = new JSeparator();
		separator_1_1_1.setBounds(0, 595, 800, 2);
		pnlEsquerdo.add(separator_1_1_1);
		
		JLabel lblSubtotal = new JLabel("Subtotal:");
		lblSubtotal.setForeground(new Color(255, 128, 0));
		lblSubtotal.setFont(new Font("Verdana", Font.PLAIN, 20));
		lblSubtotal.setBounds(10, 579, 213, 61);
		pnlEsquerdo.add(lblSubtotal);
		
		txtSubtotal = new JTextField();
		txtSubtotal.setForeground(Color.WHITE);
		txtSubtotal.setFont(new Font("Verdana", Font.BOLD, 35));
		txtSubtotal.setColumns(10);
		txtSubtotal.setBackground(new Color(128, 0, 0));
		txtSubtotal.setBounds(243, 608, 256, 66);
		txtSubtotal.setBorder(null);
		pnlEsquerdo.add(txtSubtotal);
		
		JButton btnIncluir = new JButton("Incluir");
		btnIncluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					
					cabecalho+="\n"+item+"\t"+ txtCodigoProduto.getText()+
							"\t"+txtdescricao.getText()+
							"\t\t"+txtQuantidade.getText()+
							"\t"+txtValorUni.getText()+
							"\t"+txtTotalItens.getText();
				
					txtNota.setText(cabecalho);
					item++;
					
					valorPagar += Double.parseDouble(txtTotalItens.getText());
					lblValorPagar.setText("R$" +valorPagar);
					
					
			}
		});
		btnIncluir.setForeground(new Color(128, 0, 0));
		btnIncluir.setBackground(new Color(255, 128, 0));
		btnIncluir.setFont(new Font("Verdana", Font.BOLD, 30));
		btnIncluir.setBounds(572, 608, 200, 66);
		pnlEsquerdo.add(btnIncluir);
		
		/*
		 * Para ajustar a imagem ao tamanhdo da Label, foi necessario aplicar o comando 
		 * new ImageIcon para definir a escala no elemento getImage.
		 * O tamanho da imagem foi de ajustado para largura da label(lbl.getWidth) e altura da
		 * label (lbl.getHeight) e para finalizar, foi alturado a forma de fechamento da
		 * imagem quando a tela fecha, foi setado o valor para suaviazação(image.SCALE_SMOOTH)
		 */
		
		JPanel pnlDireito = new JPanel();
		pnlDireito.setBackground(Color.WHITE);
		pnlDireito.setBounds(810, 0, 774, 700);
		contentPane.add(pnlDireito);
		pnlDireito.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 774, 700);
		pnlDireito.add(scrollPane);
		
		txtNota = new JTextArea();
		scrollPane.setViewportView(txtNota);
		txtNota.setText(cabecalho);
		
		JPanel pnlBase = new JPanel();
		pnlBase.setBackground(new Color(255, 128, 0));
		pnlBase.setBounds(0, 710, 1584, 150);
		contentPane.add(pnlBase);
		pnlBase.setLayout(null);
		
		JLabel lblTotalPagar = new JLabel(" Valor a Pagar: ");
		lblTotalPagar.setFont(new Font("Tahoma", Font.BOLD, 82));
		lblTotalPagar.setBounds(132, 27, 703, 95);
		pnlBase.add(lblTotalPagar);
		
		lblValorPagar = new JLabel("");
		lblValorPagar.setFont(new Font("Tahoma", Font.BOLD, 82));
		lblValorPagar.setBounds(776, 27, 649, 95);
		pnlBase.add(lblValorPagar);
		lblValorPagar.setText("R$ " + valorPagar);
	}
}
