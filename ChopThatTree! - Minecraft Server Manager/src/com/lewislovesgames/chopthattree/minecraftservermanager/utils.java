package com.lewislovesgames.chopthattree.minecraftservermanager;

import java.io.File;

public class utils {
	public final static String jar = "jar";
	 public void print(String string) {
		 System.out.println("[Minecraft Server Manager]: " + string);
	 }
	    public static String getExtension(File f) {
	        String ext = null;
	        String s = f.getName();
	        int i = s.lastIndexOf('.');

	        if (i > 0 &&  i < s.length() - 1) {
	            ext = s.substring(i+1).toLowerCase();
	        }
	        return ext;
	    }
}
