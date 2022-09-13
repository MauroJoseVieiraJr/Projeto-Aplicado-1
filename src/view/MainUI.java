package view;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import controller.CandidatoController;
import controller.CandidatoXPesquisaController;
import controller.PesquisaController;
import controller.TipoPesquisaController;
import model.Candidato;
import model.CandidatoXPesquisa;
import model.Pesquisa;
import model.TipoPesquisa;

public class MainUI extends JFrame implements ActionListener {
	private static final int WIDTH = 800;
	private static final int HEIGHT = 600;
	private static final String[] COMBO_BOX_OPTIONS = {"Candidato", "Tipo de Pesquisa", "Pesquisa", "Desempenho"};
	
	private String title = "Projeto Aplicado 1";
	private JTabbedPane tabs = new JTabbedPane();
	private JPanel register = new JPanel();
	private JPanel update = new JPanel();
	private JPanel delete = new JPanel();
	private JPanel search = new JPanel();
		
	public MainUI() {
		setParameters();
		
		addTabs();

		registerTabSetup();
		updateTabSetup();
		deleteTabSetup();
		searchTabSetup();
				
		requestFocus();
		setVisible(true);
	}
	
	private void setParameters() {
		setBounds(0, 0, WIDTH, HEIGHT);
		setTitle(title);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
		setFocusable(true);
		getContentPane().setLayout(null);
	}
		
	private void addTabs() {
		int tabsWidth = WIDTH - 25;
		int tabsHeight = HEIGHT - 45;
		
		tabs.setBounds(5, 0, tabsWidth, tabsHeight);
		
		tabs.addTab("Registrar", register);
		tabs.addTab("Atualizar", update);
		tabs.addTab("Deletar", delete);
		tabs.addTab("Pesquisar", search);
		
		register.setBounds(0, 0, tabsWidth, tabsHeight);
		
		getContentPane().add(tabs);
	}
	
	private void registerTabSetup() {
		JComboBox<String> cb = createComboBox(0);
		
		register.setLayout(null);
		register.add(cb);
		
		showCandidatoGui(register);
	}
	
	private void updateTabSetup() {
		update.setLayout(null);
	}
	
	private void deleteTabSetup() {
		delete.setLayout(null);
	}
	
	private void searchTabSetup() {
		search.setLayout(null);
	}

	private JComboBox<String> createComboBox(int i) {
		JComboBox<String> options = new JComboBox(COMBO_BOX_OPTIONS);
		options.setSelectedIndex(i);
		options.setBounds(10, 10, tabs.getWidth() - 25, 30);
		options.addActionListener(this);

		return options;
	}
	
	private void updateGui(String s, JPanel jp) {
		// Candidato
		if (s.equals(COMBO_BOX_OPTIONS[0])) {
			showCandidatoGui(jp);
		}
		
		// Tipo de Pesquisa
		else if (s.equals(COMBO_BOX_OPTIONS[1])) {
			showTipoPesquisaGui(jp);
		}
		
		// Pesquisa
		else if (s.equals(COMBO_BOX_OPTIONS[2])) {
			showPesquisaGui(jp);
		}
		
		// Desempenho (Candidato_X_Pesquisa)
		else if (s.equals(COMBO_BOX_OPTIONS[3])) {
			showCandidatoXPesquisaGui(jp);
		}
	}
	
	private void showCandidatoGui(JPanel jp) {
		jp.removeAll();		// Não é o jeito certo de se fazer, mas dane-se. Swing é uma merda mesmo.
		
		jp.setLayout(null);
		int xAlign = 10;
		int yAlign = 50;
		
		JComboBox<String> cb = createComboBox(0);
		jp.add(cb);
		
		JLabel nome = new JLabel("Nome: ");
		nome.setSize(80, 30);
		nome.setLocation(xAlign, yAlign);
		jp.add(nome);
		
		JTextField textFieldNome = new JTextField();
		textFieldNome.setBounds(xAlign + 90, yAlign, 660, 30);
		textFieldNome.setColumns(1);
		jp.add(textFieldNome);
		
		JLabel partido = new JLabel("Partido: ");
		partido.setSize(80, 30);
		partido.setLocation(xAlign, yAlign + 30);
		jp.add(partido);
		
		JTextField textFieldPartido = new JTextField();
		textFieldPartido.setBounds(xAlign + 90, yAlign + 30, 660, 30);
		textFieldPartido.setColumns(1);
		jp.add(textFieldPartido);
		
		JLabel fichaLimpa = new JLabel("Ficha Limpa: ");
		fichaLimpa.setSize(80, 30);
		fichaLimpa.setLocation(xAlign, yAlign + 60);
		jp.add(fichaLimpa);
		
		JCheckBox checkBoxfichaLimpa = new JCheckBox();
		checkBoxfichaLimpa.setBounds(xAlign + 90, yAlign + 60, 30, 30);
		jp.add(checkBoxfichaLimpa);
		
		JButton confirmButton = new JButton("Confirmar");
		confirmButton.setSize(100, 30);
		confirmButton.setLocation(550, 485);
		confirmButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Candidato c = new Candidato(0, textFieldNome.getText(), textFieldPartido.getText(), checkBoxfichaLimpa.isSelected());
				CandidatoController cc = new CandidatoController();
				
				try {
					cc.Create(c);
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1.toString());
					e1.printStackTrace();
				}
			}
		});
		jp.add(confirmButton);
		
		JButton cancelButton = new JButton("Cancelar");
		cancelButton.setSize(100, 30);
		cancelButton.setLocation(660, 485);
		jp.add(cancelButton);
		
		jp.repaint();
	}
	
	private void showTipoPesquisaGui(JPanel jp) {
		jp.removeAll();		// Não é o jeito certo de se fazer, mas dane-se. Swing é uma merda mesmo.
		
		jp.setLayout(null);
		int xAlign = 10;
		int yAlign = 50;
		
		JComboBox<String> cb = createComboBox(1);
		jp.add(cb);
		
		JLabel desc = new JLabel("Descrição: ");
		desc.setSize(80, 30);
		desc.setLocation(xAlign, yAlign);
		jp.add(desc);

		JTextField textFieldDesc = new JTextField();
		textFieldDesc.setBounds(xAlign + 90, yAlign, 660, 30);
		textFieldDesc.setColumns(1);
		jp.add(textFieldDesc);
		
		JButton confirmButton = new JButton("Confirmar");
		confirmButton.setSize(100, 30);
		confirmButton.setLocation(550, 485);
		confirmButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				TipoPesquisa tp = new TipoPesquisa(0, textFieldDesc.getText());
				TipoPesquisaController tpc = new TipoPesquisaController();
				
				try {
					tpc.Create(tp);
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1.toString());
					e1.printStackTrace();
				}
			}
		});
		jp.add(confirmButton);
		
		JButton cancelButton = new JButton("Cancelar");
		cancelButton.setSize(100, 30);
		cancelButton.setLocation(660, 485);
		jp.add(cancelButton);
		
		jp.repaint();
	}
	
	private void showPesquisaGui(JPanel jp) {
		jp.removeAll();		// Não é o jeito certo de se fazer, mas dane-se. Swing é uma merda mesmo.
		
		jp.setLayout(null);
		int xAlign = 10;
		int yAlign = 50;
		
		JComboBox<String> cb = createComboBox(2);
		jp.add(cb);
		
		JLabel instituto = new JLabel("Instituto: ");
		instituto.setSize(140, 30);
		instituto.setLocation(xAlign, yAlign);
		jp.add(instituto);
		
		JTextField textFieldInstituto = new JTextField();
		textFieldInstituto.setBounds(xAlign + 150, yAlign, 600, 30);
		textFieldInstituto.setColumns(1);
		jp.add(textFieldInstituto);
		
		JLabel data = new JLabel("Data: ");
		data.setSize(140, 30);
		data.setLocation(xAlign, yAlign + 30);
		jp.add(data);
		
		JTextField textFieldData = new JTextField();
		textFieldData.setBounds(xAlign + 150, yAlign + 30, 600, 30);
		textFieldData.setColumns(1);
		jp.add(textFieldData);
		
		JLabel local = new JLabel("Local da Pesquisa: ");
		local.setSize(140, 30);
		local.setLocation(xAlign, yAlign + 60);
		jp.add(local);
		
		JTextField textFieldLocal = new JTextField();
		textFieldLocal.setBounds(xAlign + 150, yAlign + 60, 600, 30);
		textFieldLocal.setColumns(1);
		jp.add(textFieldLocal);
		
		JLabel media = new JLabel("Média de Idade: ");
		media.setSize(140, 30);
		media.setLocation(xAlign, yAlign + 90);
		jp.add(media);
		
		JTextField textFieldMedia = new JTextField();
		textFieldMedia.setBounds(xAlign + 150, yAlign + 90, 600, 30);
		textFieldMedia.setColumns(1);
		jp.add(textFieldMedia);
		
		JLabel tipoPesquisa = new JLabel("Tipo de Pesquisa: ");
		tipoPesquisa.setSize(140, 30);
		tipoPesquisa.setLocation(xAlign, yAlign + 120);
		jp.add(tipoPesquisa);
		
		JTextField textFieldTipoPesquisa = new JTextField();
		textFieldTipoPesquisa.setBounds(xAlign + 150, yAlign + 120, 600, 30);
		textFieldTipoPesquisa.setColumns(1);
		jp.add(textFieldTipoPesquisa);
		
		JLabel formato = new JLabel("Formato: ");
		formato.setSize(140, 30);
		formato.setLocation(xAlign, yAlign + 150);
		jp.add(formato);
		
		JTextField textFieldFormato = new JTextField();
		textFieldFormato.setBounds(xAlign + 150, yAlign + 150, 600, 30);
		textFieldFormato.setColumns(1);
		jp.add(textFieldFormato);
		
		JButton confirmButton = new JButton("Confirmar");
		confirmButton.setSize(100, 30);
		confirmButton.setLocation(550, 485);
		confirmButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				TipoPesquisa tp = new TipoPesquisa(1, "teste");
				
				try {
					tp = new TipoPesquisaController().Find(Integer.parseInt(textFieldTipoPesquisa.getText()));
					
				} catch (NumberFormatException e2) {
					JOptionPane.showMessageDialog(null, e2.toString());
					e2.printStackTrace();
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, e2.toString());
					e2.printStackTrace();
				}
				Pesquisa p = new Pesquisa(0, textFieldInstituto.getText(), textFieldData.getText(),
						textFieldLocal.getText(), Integer.parseInt(textFieldMedia.getText()), tp, textFieldFormato.getText());
								
				PesquisaController pc = new PesquisaController();
				
				try {
					pc.Create(p);
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1.toString());
					e1.printStackTrace();
				}
			}
		});
		jp.add(confirmButton);
		
		JButton cancelButton = new JButton("Cancelar");
		cancelButton.setSize(100, 30);
		cancelButton.setLocation(660, 485);
		jp.add(cancelButton);
		
		jp.repaint();
	}
	
	private void showCandidatoXPesquisaGui(JPanel jp) {
		jp.removeAll();		// Não é o jeito certo de se fazer, mas dane-se. Swing é uma merda mesmo.
		
		jp.setLayout(null);
		int xAlign = 10;
		int yAlign = 50;
		
		JComboBox<String> cb = createComboBox(3);
		jp.add(cb);
		
		JLabel candidato = new JLabel("ID Candidato: ");
		candidato.setSize(80, 30);
		candidato.setLocation(xAlign, yAlign);
		jp.add(candidato);
		
		JTextField textCandidato = new JTextField();
		textCandidato.setBounds(xAlign + 90, yAlign, 660, 30);
		textCandidato.setColumns(1);
		jp.add(textCandidato);
		
		JLabel pesquisa = new JLabel("ID Pesquisa: ");
		pesquisa.setSize(80, 30);
		pesquisa.setLocation(xAlign, yAlign + 30);
		jp.add(pesquisa);
		
		JTextField textFieldPesquisa = new JTextField();
		textFieldPesquisa.setBounds(xAlign + 90, yAlign + 30, 660, 30);
		textFieldPesquisa.setColumns(1);
		jp.add(textFieldPesquisa);
		
		JLabel votos = new JLabel("Votos: ");
		votos.setSize(80, 30);
		votos.setLocation(xAlign, yAlign + 60);
		jp.add(votos);
		
		JTextField textFieldVotos = new JTextField();
		textFieldVotos.setBounds(xAlign + 90, yAlign + 60, 660, 30);
		textFieldVotos.setColumns(1);
		jp.add(textFieldVotos);
		
		JButton confirmButton = new JButton("Confirmar");
		confirmButton.setSize(100, 30);
		confirmButton.setLocation(550, 485);
		confirmButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Candidato c = new Candidato(0, "", "", false);
				Pesquisa p = new Pesquisa(0, "", "", "", 0, null, "");
				
				try {
					c = new CandidatoController().Find(Integer.parseInt(textCandidato.getText()));
					p = new PesquisaController().Find(Integer.parseInt(textFieldPesquisa.getText()));
				} catch (NumberFormatException e2) {
					e2.printStackTrace();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
				
				CandidatoXPesquisa cxp = new CandidatoXPesquisa(0, c, p, Integer.parseInt(textFieldVotos.getText()));
								
				CandidatoXPesquisaController cxpc = new CandidatoXPesquisaController();
				
				try {
					cxpc.Create(cxp);
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1.toString());
					e1.printStackTrace();
				}
			}
		});
		jp.add(confirmButton);
		
		JButton cancelButton = new JButton("Cancelar");
		cancelButton.setSize(100, 30);
		cancelButton.setLocation(660, 485);
		jp.add(cancelButton);
		
		jp.repaint();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JComboBox<String> cb = (JComboBox<String>) e.getSource();
		updateGui((String) cb.getSelectedItem(), (JPanel) cb.getParent());
	}
}
