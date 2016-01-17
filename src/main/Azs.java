package main;

import javax.swing.JCheckBox;

public class Azs {
String name;
int number;
String outboundFolder;
String inboundFolder;
JCheckBox checkBox;



public JCheckBox getCheckBox() {
	return checkBox;
}
public void setCheckBox(JCheckBox checkBox) {
	this.checkBox = checkBox;
}

public boolean isChecked(){
	return this.checkBox.isSelected();
}

public void setSelect(boolean b){
	this.checkBox.setSelected(b); 
}

public Azs(String name, int number, String inboundFolder, String outboundFolder
		) {
	super();
	this.checkBox = new JCheckBox(name);
	this.checkBox.setSelected(false);
	this.name = name;
	this.number = number;
	this.outboundFolder = outboundFolder;
	this.inboundFolder = inboundFolder;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getNumber() {
	return number;
}
public void setNumber(int number) {
	this.number = number;
}
public String getOutboundFolder() {
	return outboundFolder;
}
public void setOutboundFolder(String outboundFolder) {
	this.outboundFolder = outboundFolder;
}
public String getInboundFolder() {
	return inboundFolder;
}
public void setInboundFolder(String inboundFolder) {
	this.inboundFolder = inboundFolder;
}



	
}
