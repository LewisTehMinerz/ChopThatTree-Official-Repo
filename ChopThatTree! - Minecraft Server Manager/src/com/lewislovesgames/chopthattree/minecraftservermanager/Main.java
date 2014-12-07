package com.lewislovesgames.chopthattree.minecraftservermanager;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.jar.JarFile;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JCheckBox;
import javax.swing.filechooser.FileFilter;



//import com.lewislovesgames.chopthattree.minecraftservermanager.utils;


public class Main extends JFrame {
	private final JFileChooser fcSelectServerJar = new JFileChooser();
	private final JButton btnStartTheServer = new JButton("Start The Server");
	private final JButton btnStopTheServer = new JButton("Stop The Server");
	private final JEditorPane console = new JEditorPane();
	private final JTextField commandInput = new JTextField();
	private final JLabel lblCommand = new JLabel("Command:");
	private final JLabel lblConsoleOutput = new JLabel("Console Output");
	private final JButton btnInfo = new JButton("Info");
	private final JCheckBox chckbxsay = new JCheckBox("/say");
	private final JButton btnSend = new JButton("Send");
	private final JButton btnRestart = new JButton("Restart (Coming Soon)");
	private final JButton btnKill = new JButton("Kill (Coming Soon)");
	private final JTextField folder = new JTextField();
	private final JButton btnSelectServerJar = new JButton("Select Server Jar File");

	public Main() {
		btnSelectServerJar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				fcSelectServerJar.setFileFilter(new JarFilter());
				int returnVal = fcSelectServerJar.showOpenDialog(btnSelectServerJar);
				File file = fcSelectServerJar.getSelectedFile();
				folder.setText(file.getName());
			}
		});
		folder.setText("None Selected");
		folder.setEditable(false);
		folder.setColumns(10);
		btnKill.setEnabled(false);
		btnKill.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnStopTheServer.setEnabled(false);
			}
		});
		commandInput.setColumns(10);
		console.setEditable(false);
		
		initGUI();
	}
	
	private void initGUI() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		final utils utils = new utils();
		this.setSize(960, 727);
		utils.print("Running GUI");
		setTitle("ChopThatTree! - Minecraft Server Manager");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Lewis\\Downloads\\Diamond-Axe-icon.png"));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(371)
					.addComponent(lblConsoleOutput)
					.addPreferredGap(ComponentPlacement.RELATED, 345, Short.MAX_VALUE)
					.addComponent(btnInfo)
					.addGap(110))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(144)
					.addComponent(lblCommand)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(chckbxsay)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(commandInput, GroupLayout.PREFERRED_SIZE, 317, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnSend)
					.addGap(42)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnSelectServerJar)
						.addComponent(folder, GroupLayout.PREFERRED_SIZE, 241, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(43, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addGap(36)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(console, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 892, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnStartTheServer)
							.addGap(112)
							.addComponent(btnRestart)
							.addGap(119)
							.addComponent(btnKill)
							.addPreferredGap(ComponentPlacement.RELATED, 109, Short.MAX_VALUE)
							.addComponent(btnStopTheServer)))
					.addGap(26))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblConsoleOutput)
						.addComponent(btnInfo))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(console, GroupLayout.PREFERRED_SIZE, 520, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnSelectServerJar)
					.addGap(2)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(chckbxsay)
						.addComponent(lblCommand)
						.addComponent(commandInput, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnSend)
						.addComponent(folder, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(20)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnStartTheServer)
						.addComponent(btnStopTheServer)
						.addComponent(btnRestart)
						.addComponent(btnKill))
					.addGap(41))
		);
		btnRestart.setEnabled(false);
		btnInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Info info = new Info();
				info.setVisible(true);
			}
		});
		btnStopTheServer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnStartTheServer.setEnabled(true);
				btnStopTheServer.setEnabled(false);
				utils.print("Stopping Server...");
			}
		});
		btnStopTheServer.setEnabled(false);
		btnStartTheServer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnStartTheServer.setEnabled(false);
				btnStopTheServer.setEnabled(true);
				utils.print("Starting Server...");
			}
		});
		getContentPane().setLayout(groupLayout);
	}
}
