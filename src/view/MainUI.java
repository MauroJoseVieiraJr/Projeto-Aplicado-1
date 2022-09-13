package view;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import controller.*;
import model.*;
import view.tableModel.*;

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
		register.setLayout(null);
		register.setName("Registrar");
		
		showCandidatoGui(register);
	}
	
	private void updateTabSetup() {
		update.setLayout(null);
		update.setName("Atualizar");
		
		showCandidatoGui(update);
	}
	
	private void deleteTabSetup() {
		delete.setLayout(null);
		delete.setName("Deletar");
		
		showCandidatoGui(delete);
	}
	
	private void searchTabSetup() {
		search.setLayout(null);
		search.setName("Pesquisar");
		
		showCandidatoGui(search);
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
		CandidatoController cc = new CandidatoController();
		jp.removeAll();		// Não é o jeito certo de se fazer, mas dane-se. Swing é uma merda mesmo.
		
		jp.setLayout(null);
		int xAlign = 10;
		int yAlign = 50;
		
		JComboBox<String> cb = createComboBox(0);
		jp.add(cb);
		
		if(!jp.getName().equals("Pesquisar")) {
			JLabel nome = new JLabel("Nome: ");
			nome.setSize(80, 30);
			nome.setLocation(xAlign, yAlign);
			
			JTextField textFieldNome = new JTextField();
			textFieldNome.setBounds(xAlign + 90, yAlign, 660, 30);
			textFieldNome.setColumns(1);
			
			JLabel partido = new JLabel("Partido: ");
			partido.setSize(80, 30);
			partido.setLocation(xAlign, yAlign + 30);
			
			JTextField textFieldPartido = new JTextField();
			textFieldPartido.setBounds(xAlign + 90, yAlign + 30, 660, 30);
			textFieldPartido.setColumns(1);
			
			JLabel fichaLimpa = new JLabel("Ficha Limpa: ");
			fichaLimpa.setSize(80, 30);
			fichaLimpa.setLocation(xAlign, yAlign + 60);
			
			JCheckBox checkBoxfichaLimpa = new JCheckBox();
			checkBoxfichaLimpa.setBounds(xAlign + 90, yAlign + 60, 30, 30);
			
			JTextField textFieldId = new JTextField();
			textFieldId.setBounds(xAlign + 90, yAlign, 660, 30);
			textFieldId.setColumns(1);
			
			JLabel id = new JLabel("ID: ");
			id.setSize(80, 30);
			id.setLocation(xAlign, yAlign);
			
			// Adiciona os elementos configurados a tela Registrar
			if(jp.getName().equals("Registrar")) {
				jp.add(nome);
				jp.add(textFieldNome);
				jp.add(partido);
				jp.add(textFieldPartido);
				jp.add(fichaLimpa);
				jp.add(checkBoxfichaLimpa);
			}
			
			// Adiciona os elementos configurados a tela Atualizar
			if(jp.getName().equals("Atualizar")) {
				jp.add(nome);
				jp.add(textFieldNome);
				jp.add(partido);
				jp.add(textFieldPartido);
				jp.add(fichaLimpa);
				jp.add(checkBoxfichaLimpa);
				jp.add(id);
				jp.add(textFieldId);
				
				nome.setLocation(xAlign, yAlign + 30);
				textFieldNome.setLocation(xAlign + 90, yAlign + 30);
				
				partido.setLocation(xAlign, yAlign + 60);
				textFieldPartido.setLocation(xAlign + 90, yAlign + 60);
				
				fichaLimpa.setLocation(xAlign, yAlign + 90);
				checkBoxfichaLimpa.setLocation(xAlign + 90, yAlign + 90);
			}
			
			// Adiciona os elementos configurados a tela Deletar
			if(jp.getName().equals("Deletar")) {
				jp.add(id);
				jp.add(textFieldId);
			}
			
			JButton confirmButton = new JButton("Confirmar");
			confirmButton.setSize(100, 30);
			confirmButton.setLocation(550, 485);
			confirmButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					if (jp.getName().equals("Registrar")) {
						Candidato c = new Candidato(0, textFieldNome.getText(), textFieldPartido.getText(),
													checkBoxfichaLimpa.isSelected());
						
						try {
							cc.Create(c);
						} catch (Exception e1) {
							JOptionPane.showMessageDialog(null, e1.toString());
							e1.printStackTrace();
						}						
					}
					
					if (jp.getName().equals("Atualizar")) {
						Candidato c = new Candidato(Integer.parseInt(textFieldId.getText()), textFieldNome.getText(),
													textFieldPartido.getText(), checkBoxfichaLimpa.isSelected());
						
						try {
							cc.Update(c);
						} catch (Exception e1) {
							JOptionPane.showMessageDialog(null, e1.toString());
							e1.printStackTrace();
						}						
					}
					
					if (jp.getName().equals("Deletar")) {
						try {
							cc.Delete(Integer.parseInt(textFieldId.getText()));
						} catch (Exception e1) {
							JOptionPane.showMessageDialog(null, e1.toString());
							e1.printStackTrace();
						}						
					}
				}
			});
			jp.add(confirmButton);
			
			JButton cancelButton = new JButton("Cancelar");
			cancelButton.setSize(100, 30);
			cancelButton.setLocation(660, 485);
			cancelButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					textFieldId.setText("");
					textFieldNome.setText("");
					textFieldPartido.setText("");
					checkBoxfichaLimpa.setSelected(false);
				}
			});
			jp.add(cancelButton);
		} else {
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(xAlign, yAlign, 750, 465);
			
			JTable searchTable = new JTable();
			try {
				searchTable.setModel(new CandidatoTableModel(cc.Read()));
			} catch (SQLException e) {
				e.printStackTrace();
			}
			searchTable.setBounds(0, 0, scrollPane.getWidth(), scrollPane.getHeight());
			
			scrollPane.setViewportView(searchTable);
			jp.add(scrollPane);
		}
		
		jp.repaint();
	}
	
	private void showTipoPesquisaGui(JPanel jp) {
		TipoPesquisaController tpc = new TipoPesquisaController();
		
		jp.removeAll();		// Não é o jeito certo de se fazer, mas dane-se. Swing é uma merda mesmo.
		
		jp.setLayout(null);
		int xAlign = 10;
		int yAlign = 50;
		
		JComboBox<String> cb = createComboBox(1);
		jp.add(cb);
		
		if(!jp.getName().equals("Pesquisar")) {
			JLabel desc = new JLabel("Descrição: ");
			desc.setSize(80, 30);
			desc.setLocation(xAlign, yAlign);
			
			JTextField textFieldDesc = new JTextField();
			textFieldDesc.setBounds(xAlign + 90, yAlign, 660, 30);
			textFieldDesc.setColumns(1);
			
			JTextField textFieldId = new JTextField();
			textFieldId.setBounds(xAlign + 90, yAlign, 660, 30);
			textFieldId.setColumns(1);
			
			JLabel id = new JLabel("ID: ");
			id.setSize(80, 30);
			id.setLocation(xAlign, yAlign);
			
			if(jp.getName().equals("Registrar")) {
				jp.add(desc);
				jp.add(textFieldDesc);
			}
			
			if(jp.getName().equals("Atualizar")) {
				jp.add(desc);
				jp.add(textFieldDesc);
				jp.add(id);
				jp.add(textFieldId);
				
				desc.setLocation(xAlign, yAlign + 30);
				textFieldDesc.setLocation(xAlign + 90, yAlign + 30);
			}
			
			if(jp.getName().equals("Deletar")) {
				jp.add(id);
				jp.add(textFieldId);
			}
			
			JButton confirmButton = new JButton("Confirmar");
			confirmButton.setSize(100, 30);
			confirmButton.setLocation(550, 485);
			confirmButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					if (jp.getName().equals("Registrar")) {
						TipoPesquisa tp = new TipoPesquisa(0, textFieldDesc.getText());
						
						try {
							tpc.Create(tp);
						} catch (Exception e1) {
							JOptionPane.showMessageDialog(null, e1.toString());
							e1.printStackTrace();
						}						
					}
					
					if (jp.getName().equals("Atualizar")) {
						TipoPesquisa tp = new TipoPesquisa(Integer.parseInt(textFieldId.getText()), textFieldDesc.getText());
						
						try {
							tpc.Update(tp);
						} catch (Exception e1) {
							JOptionPane.showMessageDialog(null, e1.toString());
							e1.printStackTrace();
						}						
					}
					
					if (jp.getName().equals("Deletar")) {
						try {
							tpc.Delete(Integer.parseInt(textFieldId.getText()));
						} catch (Exception e1) {
							JOptionPane.showMessageDialog(null, e1.toString());
							e1.printStackTrace();
						}						
					}
				}
			});
			jp.add(confirmButton);
			
			JButton cancelButton = new JButton("Cancelar");
			cancelButton.setSize(100, 30);
			cancelButton.setLocation(660, 485);
			cancelButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					textFieldDesc.setText("");
				}
			});
			jp.add(cancelButton);
		} else {
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(xAlign, yAlign, 750, 465);
			
			JTable searchTable = new JTable();
			try {
				searchTable.setModel(new TipoPesquisaTableModel(tpc.Read()));
			} catch (SQLException e) {
				e.printStackTrace();
			}
			searchTable.setBounds(0, 0, scrollPane.getWidth(), scrollPane.getHeight());
			
			scrollPane.setViewportView(searchTable);
			jp.add(scrollPane);
		}
		
		jp.repaint();
	}
	
	private void showPesquisaGui(JPanel jp) {
		PesquisaController pc = new PesquisaController();
		
		jp.removeAll();		// Não é o jeito certo de se fazer, mas dane-se. Swing é uma merda mesmo.
		
		jp.setLayout(null);
		int xAlign = 10;
		int yAlign = 50;
		
		JComboBox<String> cb = createComboBox(2);
		jp.add(cb);
		
		if(!jp.getName().equals("Pesquisar")) {
			JLabel instituto = new JLabel("Instituto: ");
			instituto.setSize(140, 30);
			instituto.setLocation(xAlign, yAlign);
			
			JTextField textFieldInstituto = new JTextField();
			textFieldInstituto.setBounds(xAlign + 150, yAlign, 600, 30);
			textFieldInstituto.setColumns(1);
			
			JLabel data = new JLabel("Data: ");
			data.setSize(140, 30);
			data.setLocation(xAlign, yAlign + 30);
			
			JTextField textFieldData = new JTextField();
			textFieldData.setBounds(xAlign + 150, yAlign + 30, 600, 30);
			textFieldData.setColumns(1);
			
			JLabel local = new JLabel("Local da Pesquisa: ");
			local.setSize(140, 30);
			local.setLocation(xAlign, yAlign + 60);
			
			JTextField textFieldLocal = new JTextField();
			textFieldLocal.setBounds(xAlign + 150, yAlign + 60, 600, 30);
			textFieldLocal.setColumns(1);
			
			JLabel media = new JLabel("Média de Idade: ");
			media.setSize(140, 30);
			media.setLocation(xAlign, yAlign + 90);
			
			JTextField textFieldMedia = new JTextField();
			textFieldMedia.setBounds(xAlign + 150, yAlign + 90, 600, 30);
			textFieldMedia.setColumns(1);
			
			JLabel tipoPesquisa = new JLabel("Tipo de Pesquisa: ");
			tipoPesquisa.setSize(140, 30);
			tipoPesquisa.setLocation(xAlign, yAlign + 120);
			
			JTextField textFieldTipoPesquisa = new JTextField();
			textFieldTipoPesquisa.setBounds(xAlign + 150, yAlign + 120, 600, 30);
			textFieldTipoPesquisa.setColumns(1);
			
			JLabel formato = new JLabel("Formato: ");
			formato.setSize(140, 30);
			formato.setLocation(xAlign, yAlign + 150);
			
			JTextField textFieldFormato = new JTextField();
			textFieldFormato.setBounds(xAlign + 150, yAlign + 150, 600, 30);
			textFieldFormato.setColumns(1);
			
			JTextField textFieldId = new JTextField();
			textFieldId.setBounds(xAlign + 150, yAlign, 600, 30);
			textFieldId.setColumns(1);
			
			JLabel id = new JLabel("ID: ");
			id.setSize(80, 30);
			id.setLocation(xAlign, yAlign);
			
			if(jp.getName().equals("Registrar")) {
				jp.add(textFieldInstituto);
				jp.add(instituto);
				jp.add(data);
				jp.add(textFieldData);
				jp.add(local);
				jp.add(textFieldLocal);
				jp.add(media);
				jp.add(textFieldMedia);
				jp.add(tipoPesquisa);
				jp.add(textFieldTipoPesquisa);
				jp.add(formato);
				jp.add(textFieldFormato);
			}
			
			if(jp.getName().equals("Atualizar")) {
				jp.add(textFieldInstituto);
				jp.add(instituto);
				jp.add(data);
				jp.add(textFieldData);
				jp.add(local);
				jp.add(textFieldLocal);
				jp.add(media);
				jp.add(textFieldMedia);
				jp.add(tipoPesquisa);
				jp.add(textFieldTipoPesquisa);
				jp.add(formato);
				jp.add(textFieldFormato);
				jp.add(id);
				jp.add(textFieldId);
				
				instituto.setLocation(xAlign, yAlign + 30);
				textFieldInstituto.setLocation(xAlign + 150, yAlign + 30);
				
				data.setLocation(xAlign, yAlign + 60);
				textFieldData.setLocation(xAlign + 150, yAlign + 60);
				
				local.setLocation(xAlign, yAlign + 90);
				textFieldLocal.setLocation(xAlign + 150, yAlign + 90);
				
				media.setLocation(xAlign, yAlign + 120);
				textFieldMedia.setLocation(xAlign + 150, yAlign + 120);
				
				tipoPesquisa.setLocation(xAlign, yAlign + 150);
				textFieldTipoPesquisa.setLocation(xAlign + 150, yAlign + 150);
				
				formato.setLocation(xAlign, yAlign + 180);
				textFieldFormato.setLocation(xAlign + 150, yAlign + 180);
			}
			
			if(jp.getName().equals("Deletar")) {
				textFieldId.setBounds(xAlign + 90, yAlign, 660, 30);
				jp.add(id);
				jp.add(textFieldId);
			}
			
			JButton confirmButton = new JButton("Confirmar");
			confirmButton.setSize(100, 30);
			confirmButton.setLocation(550, 485);
			confirmButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					TipoPesquisa tp = new TipoPesquisa(1, "teste");
					
					// Só pra não dar pau na deleção de valores
					if(!jp.getName().equals("Deletar")) {
						try {
							System.out.println(jp.getName());
							tp = new TipoPesquisaController().Find(Integer.parseInt(textFieldTipoPesquisa.getText()));
							
						} catch (NumberFormatException e2) {
							JOptionPane.showMessageDialog(null, e2.toString());
							e2.printStackTrace();
						} catch (Exception e2) {
							JOptionPane.showMessageDialog(null, e2.toString());
							e2.printStackTrace();
						}
					}

					if (jp.getName().equals("Registrar")) {
						Pesquisa p = new Pesquisa(0, textFieldInstituto.getText(), textFieldData.getText(),
								textFieldLocal.getText(), Integer.parseInt(textFieldMedia.getText()), tp, textFieldFormato.getText());
										
						try {
							pc.Create(p);
						} catch (Exception e1) {
							JOptionPane.showMessageDialog(null, e1.toString());
							e1.printStackTrace();
						}
					}
					
					if (jp.getName().equals("Atualizar")) {
						Pesquisa p = new Pesquisa(Integer.parseInt(textFieldId.getText()), textFieldInstituto.getText(),
													textFieldData.getText(), textFieldLocal.getText(),
													Integer.parseInt(textFieldMedia.getText()), tp, textFieldFormato.getText());
										
						try {
							pc.Update(p);
						} catch (Exception e1) {
							JOptionPane.showMessageDialog(null, e1.toString());
							e1.printStackTrace();
						}
					}
					
					if (jp.getName().equals("Deletar")) {
						try {
							pc.Delete(Integer.parseInt(textFieldId.getText()));
						} catch (Exception e1) {
							JOptionPane.showMessageDialog(null, e1.toString());
							e1.printStackTrace();
						}
					}
				}
			});
			jp.add(confirmButton);
			
			JButton cancelButton = new JButton("Cancelar");
			cancelButton.setSize(100, 30);
			cancelButton.setLocation(660, 485);
			cancelButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					textFieldId.setText("");
					textFieldInstituto.setText("");
					textFieldData.setText("");
					textFieldLocal.setText("");
					textFieldMedia.setText("");
					textFieldTipoPesquisa.setText("");
					textFieldFormato.setText("");
				}
			});
			jp.add(cancelButton);
		} else {
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(xAlign, yAlign, 750, 465);
			
			JTable searchTable = new JTable();
			try {
				searchTable.setModel(new PesquisaTableModel(pc.Read()));
			} catch (SQLException e) {
				e.printStackTrace();
			}
			searchTable.setBounds(0, 0, scrollPane.getWidth(), scrollPane.getHeight());
			
			scrollPane.setViewportView(searchTable);
			jp.add(scrollPane);
		}

		jp.repaint();
	}
	
	private void showCandidatoXPesquisaGui(JPanel jp) {
		CandidatoXPesquisaController cxpc = new CandidatoXPesquisaController();
		
		jp.removeAll();		// Não é o jeito certo de se fazer, mas dane-se. Swing é uma merda mesmo.
		
		jp.setLayout(null);
		int xAlign = 10;
		int yAlign = 50;
		
		JComboBox<String> cb = createComboBox(3);
		jp.add(cb);
		
		if(!jp.getName().equals("Pesquisar")) {
			JLabel candidato = new JLabel("ID Candidato: ");
			candidato.setSize(80, 30);
			candidato.setLocation(xAlign, yAlign);
			
			JTextField textFieldCandidato = new JTextField();
			textFieldCandidato.setBounds(xAlign + 90, yAlign, 660, 30);
			textFieldCandidato.setColumns(1);
			
			JLabel pesquisa = new JLabel("ID Pesquisa: ");
			pesquisa.setSize(80, 30);
			pesquisa.setLocation(xAlign, yAlign + 30);
			
			JTextField textFieldPesquisa = new JTextField();
			textFieldPesquisa.setBounds(xAlign + 90, yAlign + 30, 660, 30);
			textFieldPesquisa.setColumns(1);
			
			JLabel votos = new JLabel("Votos: ");
			votos.setSize(80, 30);
			votos.setLocation(xAlign, yAlign + 60);
			
			JTextField textFieldVotos = new JTextField();
			textFieldVotos.setBounds(xAlign + 90, yAlign + 60, 660, 30);
			textFieldVotos.setColumns(1);
			
			JTextField textFieldId = new JTextField();
			textFieldId.setBounds(xAlign + 90, yAlign, 660, 30);
			textFieldId.setColumns(1);
			
			JLabel id = new JLabel("ID: ");
			id.setSize(80, 30);
			id.setLocation(xAlign, yAlign);
			
			if(jp.getName().equals("Registrar")) {
				jp.add(candidato);
				jp.add(textFieldCandidato);
				jp.add(pesquisa);
				jp.add(textFieldPesquisa);
				jp.add(votos);
				jp.add(textFieldVotos);
			}
			
			if(jp.getName().equals("Atualizar")) {
				jp.add(candidato);
				jp.add(textFieldCandidato);
				jp.add(pesquisa);
				jp.add(textFieldPesquisa);
				jp.add(votos);
				jp.add(textFieldVotos);
				jp.add(id);
				jp.add(textFieldId);
				
				candidato.setLocation(xAlign, yAlign + 30);
				textFieldCandidato.setLocation(xAlign + 90, yAlign + 30);
				
				pesquisa.setLocation(xAlign, yAlign + 60);
				textFieldPesquisa.setLocation(xAlign + 90, yAlign + 60);
				
				votos.setLocation(xAlign, yAlign + 90);
				textFieldVotos.setLocation(xAlign + 90, yAlign + 90);
			}
			
			if(jp.getName().equals("Deletar")) {
				jp.add(id);
				jp.add(textFieldId);
			}
			
			JButton confirmButton = new JButton("Confirmar");
			confirmButton.setSize(100, 30);
			confirmButton.setLocation(550, 485);
			confirmButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					Candidato c = new Candidato(0, "", "", false);
					Pesquisa p = new Pesquisa(0, "", "", "", 0, null, "");
					
					// Mesmo esquema: só pra não ferrar as deleções
					if(!jp.getName().equals("Deletar")) {
						try {
							c = new CandidatoController().Find(Integer.parseInt(textFieldCandidato.getText()));
							p = new PesquisaController().Find(Integer.parseInt(textFieldPesquisa.getText()));
						} catch (NumberFormatException e2) {
							e2.printStackTrace();
						} catch (Exception e2) {
							e2.printStackTrace();
						}
					}
					
					if (jp.getName().equals("Registrar")) {
						CandidatoXPesquisa cxp = new CandidatoXPesquisa(0, c, p, Integer.parseInt(textFieldVotos.getText()));
						
						CandidatoXPesquisaController cxpc = new CandidatoXPesquisaController();
						
						try {
							cxpc.Create(cxp);
						} catch (Exception e1) {
							JOptionPane.showMessageDialog(null, e1.toString());
							e1.printStackTrace();
						}
					}
					
					if (jp.getName().equals("Atualizar")) {
						CandidatoXPesquisa cxp = new CandidatoXPesquisa(Integer.parseInt(textFieldId.getText()), c, p,
																		Integer.parseInt(textFieldVotos.getText()));
						
						CandidatoXPesquisaController cxpc = new CandidatoXPesquisaController();
						
						try {
							cxpc.Update(cxp);
						} catch (Exception e1) {
							JOptionPane.showMessageDialog(null, e1.toString());
							e1.printStackTrace();
						}
					}
					
					if (jp.getName().equals("Deletar")) {
						try {
							cxpc.Delete(Integer.parseInt(textFieldId.getText()));
						} catch (Exception e1) {
							JOptionPane.showMessageDialog(null, e1.toString());
							e1.printStackTrace();
						}
					}
				}
			});
			jp.add(confirmButton);
			
			JButton cancelButton = new JButton("Cancelar");
			cancelButton.setSize(100, 30);
			cancelButton.setLocation(660, 485);
			cancelButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					textFieldId.setText("");
					textFieldCandidato.setText("");
					textFieldPesquisa.setText("");
					textFieldVotos.setText("");
				}
			});
			jp.add(cancelButton);
		} else {
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(xAlign, yAlign, 750, 465);
			
			JTable searchTable = new JTable();
			
			try {
				searchTable.setModel(new CandidatoXPesquisaTableModel(cxpc.Read()));
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			
			searchTable.setBounds(0, 0, scrollPane.getWidth(), scrollPane.getHeight());
			
			scrollPane.setViewportView(searchTable);
			jp.add(scrollPane);
		}
		
		jp.repaint();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JComboBox<String> cb = (JComboBox<String>) e.getSource();
		updateGui((String) cb.getSelectedItem(), (JPanel) cb.getParent());
	}
}
