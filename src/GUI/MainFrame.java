package GUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import main.Azs;
import main.SendButtonEngine;

import org.ini4j.Ini;

public class MainFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	public static int kolvo;
	public static int width;
	public static int height;
	static String azsSpis="";

	static String[] azsTempSpis;
	JPanel windowContent;
	JPanel rightPanel;
	JPanel northPanel;
	JTextField sqlName;
	JButton sendButton;
	JTextArea sqlText;
	JCheckBox selectAll;
	
	static JCheckBox temp;
	static public ArrayList<Azs> azsList = new ArrayList<Azs>();
	//чтение ини
	public static void readIni(String file) throws IOException{
		String inboundFolder, outboundFolder;
		Ini ini = new Ini(new FileReader(file));
		azsSpis= ini.get("app").fetch("azsList");
		width=Integer.parseInt(ini.get("app").fetch("width"));
		height=Integer.parseInt(ini.get("app").fetch("height"));
		
		azsTempSpis = azsSpis.split(";");
		kolvo = azsTempSpis.length;
		inboundFolder = ini.get("app").fetch("inboundFolder");
		outboundFolder = ini.get("app").fetch("outboundFolder");
		
		System.out.println(kolvo);
		System.out.println(inboundFolder);
		System.out.println(outboundFolder);
		System.out.println(azsSpis);
		//создаем список азс и заполняем данные
		for (int i = 1; i <= kolvo; i++) {
			azsList.add(new Azs("azs "+azsTempSpis[i-1],  Integer.parseInt(azsTempSpis[i-1]),  inboundFolder+"azs"+azsTempSpis[i-1], outboundFolder+"azs"+azsTempSpis[i-1] ));
			
		}
	}
// главная форма
	public MainFrame() throws IOException {
		super("AZS_SQL");
		readIni("config.ini");
		SendButtonEngine sendButtonEngine;
		windowContent = new JPanel();
		rightPanel = new JPanel();
		rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));
		for (Azs azs : azsList) {
			rightPanel.add(azs.getCheckBox());
		}
		//создаем чекбокс выбрать все
		selectAll = new JCheckBox("Выбрать все");
		selectAll.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				for (Azs azs : azsList) {
					azs.setSelect(selectAll.isSelected());
				}
			}
		});
		//-------------------------------
		rightPanel.add(selectAll, 0);
		windowContent.setLayout(new BorderLayout());
		sendButton =  new JButton("Отправить");
		sendButtonEngine = new SendButtonEngine();
		sendButton.addActionListener(sendButtonEngine);
		northPanel = new JPanel();
		northPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		JLabel jl = new JLabel("Имя SQL файла");
		sqlName = new JTextField("sqlFileName");
		sqlName.setPreferredSize(new Dimension(200, 20));
		northPanel.add(jl);
		northPanel.add(sqlName);
		
		sqlText = new JTextArea();
		sqlText.setPreferredSize(new Dimension(width,height));
		windowContent.add(sqlText, BorderLayout.CENTER);
		windowContent.add(sendButton,BorderLayout.SOUTH);
		windowContent.add(rightPanel, BorderLayout.EAST);
		windowContent.add(northPanel, BorderLayout.NORTH);
		setContentPane(windowContent);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack();
		setVisible(true);
		
		
	}
}
