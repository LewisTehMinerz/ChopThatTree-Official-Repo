package com.lewislovesgames.chopthattree.minecraftservercreator;

import java.io.File;

import javax.swing.JOptionPane;

public class CreateServer {
	private static void infoBox(String infoMessage, String titleBar)
    {
        JOptionPane.showMessageDialog(null, infoMessage, "Minecraft Server Creator: " + titleBar, JOptionPane.INFORMATION_MESSAGE);
    }
 public void generate(String exportpath, String MOTD, String ServerName, boolean BukkitSpigot, boolean vanilla, boolean forge) {
	 
	 if (BukkitSpigot == true) { 
		 Object success = (new File(exportpath + "\\Bukkit / Spigot").mkdirs());
		 if ((boolean) success) {
			 System.out.println("[Minecraft Server Creator]: Created \"" + exportpath + "\\Bukkit / Spigot\" without any errors.");
			 
		 } else {
			 System.err.println("[Minecraft Server Creator] [ERROR]: Failed to create \"" + exportpath + "\\Bukkit / Spigot \". Error: " + success);
		 } 
		 if (forge == true) { 
			 Object success2 = (new File(exportpath + "\\forge").mkdirs());
			 if ((boolean) success2) {
				 System.out.println("[Minecraft Server Creator]: Created \"" + exportpath + "\\forge\" without any errors.");
				 
			 } else {
				 System.err.println("[Minecraft Server Creator] [ERROR]: Failed to create \"" + exportpath + "\\forge \". Error: " + success);
			 } 
			 if (vanilla == true) { 
				 Object success3 = (new File(exportpath + "\\vanilla").mkdirs());
				 if ((boolean) success3) {
					 System.out.println("[Minecraft Server Creator]: Created \"" + exportpath + "\\vanilla\" without any errors.");
					 
				 } else {
					 System.err.println("[Minecraft Server Creator] [ERROR]: Failed to create \"" + exportpath + "\\vanilla \". Error: " + success);
				 }
			 if ((BukkitSpigot == false) & (vanilla == false) & (forge == false)) {
				 infoBox("Error has occurred and Minecraft Server Creator has failed to create your server: No options selected", "Error");
			 }
			 MainWindow gui = new MainWindow();
			 gui.progressBar.setValue(1);
	 }
 }
 }
}
}