package com.lewislovesgames.chopthattree.minecraftservercreator;

import javax.swing.JFrame;

import java.awt.Toolkit;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JToggleButton;
import javax.swing.JLabel;
import javax.swing.AbstractAction;

import com.lewislovesgames.chopthattree.minecraftservercreator.utils.filters;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import javax.swing.JProgressBar;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

import org.apache.commons.io.FileUtils;

public class MainWindow extends JFrame {
	private final JTextField txtServerNameHere = new JTextField();
	private final JTextField txtMotd = new JTextField();
	private final JButton btnSet = new JButton("Set");
	private final JButton btnSet_1 = new JButton("Set");
	private final JToggleButton tglbtnBukkitSpigot = new JToggleButton("Bukkit / Spigot");
	private final JLabel lblServerType = new JLabel("Server Type");
	private final JToggleButton tglbtnVanilla = new JToggleButton("Vanilla");
	public final JProgressBar progressBar = new JProgressBar();
	private final JButton btnStart = new JButton("Start"); 
	private final JLabel lblCurrently = new JLabel("Currently: ");
	private final JToggleButton tglbtnForge = new JToggleButton("Forge");
	private final JTextField txtExportJarHere = new JTextField();
	private final JButton btnSelect = new JButton("Select");
	private final JFileChooser flExportJar = new JFileChooser();
	public boolean forge = false;
	public boolean vanilla = false;
	public boolean BukkitSpigot = false;
	public String exportpath = null;
	public MainWindow() {
		btnSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				flExportJar.setVisible(true);
				flExportJar.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				//flExportJar.setFileFilter(new filters());
				int returnVal = flExportJar.showOpenDialog(btnSelect);
				File file = flExportJar.getSelectedFile();
				txtExportJarHere.setText(file.getName());
			}
		});
		txtExportJarHere.setEditable(false);
		txtExportJarHere.setText("Export to...");
		txtExportJarHere.setColumns(10);
	
		progressBar.setStringPainted(true);
		tglbtnBukkitSpigot.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent ev) {
				
				if(ev.getStateChange() == ItemEvent.SELECTED){
			        BukkitSpigot = true;
			      } else if(ev.getStateChange() == ItemEvent.DESELECTED){
			        BukkitSpigot = false;
			      }
				
			}

		
		});
		txtMotd.setText("MOTD");
		txtMotd.setColumns(10);
		txtServerNameHere.setText("Server Name Here");
		txtServerNameHere.setColumns(10);
		
		initGUI();
	}
	
	private void initGUI() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Lewis\\Downloads\\Diamond-Axe-icon.png"));
		setTitle("ChopThatTree! - Minecraft Server Creator");
		setSize(805, 575);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(69)
					.addComponent(tglbtnBukkitSpigot)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(tglbtnVanilla)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
									.addGroup(groupLayout.createSequentialGroup()
										.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
											.addComponent(txtMotd, Alignment.LEADING)
											.addComponent(txtServerNameHere, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE)
											.addComponent(txtExportJarHere))
										.addPreferredGap(ComponentPlacement.RELATED)
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
											.addComponent(btnSelect)
											.addComponent(btnSet)
											.addComponent(btnSet_1)))
									.addGroup(groupLayout.createSequentialGroup()
										.addComponent(progressBar, GroupLayout.PREFERRED_SIZE, 468, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)))
								.addComponent(tglbtnForge)))
						.addComponent(lblServerType))
					.addContainerGap(86, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(89)
					.addComponent(lblCurrently)
					.addPreferredGap(ComponentPlacement.RELATED, 317, Short.MAX_VALUE)
					.addComponent(btnStart)
					.addGap(284))
		);
		tglbtnVanilla.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent ev) {
				
				if(ev.getStateChange() == ItemEvent.SELECTED){
			        vanilla = true;
			      } else if(ev.getStateChange() == ItemEvent.DESELECTED){
			        vanilla = false;
			      }
				
			}
		});
		tglbtnForge.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent ev) {
				
				if(ev.getStateChange() == ItemEvent.SELECTED){
			        forge = true;
			      } else if(ev.getStateChange() == ItemEvent.DESELECTED){
			        forge = false;
			      }
			}
		});
		btnSet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String motd = txtMotd.getText();
			}
		});
		btnSet_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String servername = txtServerNameHere.getText();
			}
		});
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CreateServer server = new CreateServer();
				tglbtnBukkitSpigot.setEnabled(false);
				tglbtnVanilla.setEnabled(false);
				tglbtnForge.setEnabled(false);
				btnSet_1.setEnabled(false);
				btnSet.setEnabled(false);
				btnSelect.setEnabled(false);
				try {
					exportpath = FileUtils.readFileToString(flExportJar.getSelectedFile());
				} catch (IOException e1) {
					
					System.err.println("[Minecraft Server Creator] [ERROR]: IOException has just been caught. Stacktrace: " + e1.getStackTrace());
				}
				server.generate(exportpath, txtMotd.getText(), txtServerNameHere.getText(), BukkitSpigot, vanilla, forge);
			}
		});
		
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(31)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtServerNameHere, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnSet_1))
					.addGap(29)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtMotd, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnSet))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(18)
							.addComponent(lblServerType)
							.addGap(33)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(tglbtnVanilla)
								.addComponent(tglbtnBukkitSpigot)
								.addComponent(tglbtnForge)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(32)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(btnSelect)
								.addComponent(txtExportJarHere, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addGap(272)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCurrently)
						.addComponent(btnStart))
					.addGap(18)
					.addComponent(progressBar, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(18, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);
	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
}
