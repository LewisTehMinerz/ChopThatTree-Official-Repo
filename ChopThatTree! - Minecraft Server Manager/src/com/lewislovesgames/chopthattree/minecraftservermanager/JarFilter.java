package com.lewislovesgames.chopthattree.minecraftservermanager;

import java.io.File;

import javax.swing.filechooser.FileFilter;

public class JarFilter extends FileFilter {

	@Override
	public boolean accept(File arg0) {
		 if (arg0.isDirectory()) {
		        return true;
		    }

		    String extension = utils.getExtension(arg0);
		    if (extension != null) {
		        if (extension.equals(utils.jar)) {
		                return true;
		        } else {
		            return false;
		        }
		    }

		    return false;
	}

	@Override
	public String getDescription() {
		return "Jar File (*.jar)";
	}

}
