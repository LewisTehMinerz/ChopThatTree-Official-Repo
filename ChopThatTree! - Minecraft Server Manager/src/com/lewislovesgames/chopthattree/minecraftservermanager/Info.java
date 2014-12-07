package com.lewislovesgames.chopthattree.minecraftservermanager;
import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;


public class Info extends JFrame {
	private final JLabel lblCreatedByLewislovesgames = new JLabel("Created By Lewislovesgames");
	public Info() {
		initGUI();
	}
	private void initGUI() {
		this.setSize(926, 725);
		setTitle("ChopThatTree! Minecraft Server Manager - Info");
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblCreatedByLewislovesgames)
					.addContainerGap(188, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(59)
					.addComponent(lblCreatedByLewislovesgames)
					.addContainerGap(184, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);
	}

}
