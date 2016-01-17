package main;
import java.io.IOException;

import GUI.MainFrame;


public class First {
	
	
	

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
	java.awt.EventQueue.invokeLater(new Runnable() {
		
		@Override
		public void run() {
			try {
				new MainFrame();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	});
	}

}
