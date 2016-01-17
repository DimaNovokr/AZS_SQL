package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import GUI.MainFrame;

public class SendButtonEngine implements ActionListener {
	File sqlFile;
	File inboundFolder;
	File outboundFolder;

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		for (Azs azs : MainFrame.azsList) {
			if (azs.isChecked()) {

				inboundFolder = new File(azs.getInboundFolder());
				outboundFolder = new File(azs.getOutboundFolder());
				System.out.println(azs.getInboundFolder());
				if (inboundFolder.exists()) {
					System.out.println("es");
				}
			}
		}
	}

}
