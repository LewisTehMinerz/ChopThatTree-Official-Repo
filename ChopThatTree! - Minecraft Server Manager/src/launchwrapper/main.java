package launchwrapper;
import com.lewislovesgames.chopthattree.minecraftservermanager.Main;

public class main {

 public static void main(String[] args) {
	 if (args.length != 0) { 
	  if  (args[0] == "--nogui") {
		  System.err.println("NOGUI not made");
	  } else {
	   System.err.println("[Minecraft Server Manager]: Argument does not exist.");
	  }
	 } else {
		 System.out.println("[Main & Minecraft Server Manager]: No arguments have been detected.");
	 }
	 System.out.println("[Main]: Running Main Window");
	 Main main = new Main();
	 main.setVisible(true);
	
	 }
 }


 

