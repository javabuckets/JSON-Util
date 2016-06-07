package com.thom.gui;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.thom.reference.PathReference;

@SuppressWarnings("serial")
public class GUIPathSelector extends GuiScreen
{
	JPanel panel;
	JTextField pathField;
	
	boolean isItem;

	public GUIPathSelector(boolean isItem) 
	{
		this.isItem = isItem;
		
		initGui();
		drawScreen(getWidth(), getHeight());
	}

	public void initGui() 
	{
		setTitle("Path Selector");
		setAlwaysOnTop(true);
		setSize(600, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		panel = new JPanel(null);
		panel.setBackground(Color.DARK_GRAY);
		this.add(panel);

		buttonList.clear();
		buttonMap.clear();
	}

	public void drawScreen(int width, int height) 
	{
		drawString(width / 2 - 55, 10, 200, 20, "MCP Directory Path", panel).setForeground(Color.white);;
		pathField = drawTextField(width / 2 - 250, 30, 500, 20, "", panel);
		drawButton(0, width / 2 - 60, 100, 120, 25, "Set PATH", panel);
	}

	@SuppressWarnings("deprecation")
	@Override
	public void actionPerformed(Object button) 
	{
		switch (buttonMap.get(button)) 
		{
		case 0:
			PathReference.PATH = pathField.getText();
			
			if (isItem) 
			{
				GUIMenuItemJSON itemMenu = new GUIMenuItemJSON(); 
				itemMenu.show();
			} 
			else
			{
				GUIMenuBlockJSON blockMenu = new GUIMenuBlockJSON(); 
				blockMenu.show();
			}
			
			this.dispose();
			break;
		default:
			break;
		}
	}

//	public void actionPerformed(ActionEvent e) {        
//		if(e.getSource() == buttonOpenFile) {
//			final JFileChooser chooser = new JFileChooser();
//			chooser.setCurrentDirectory(new java.io.File("."));
//			chooser.setFileSelectionMode(chooser.DIRECTORIES_ONLY);
//			int returnVal = chooser.showOpenDialog(this);
//			if(returnVal == JFileChooser.APPROVE_OPTION) {
//				String path = chooser.getSelectedFile().getAbsolutePath();
//				System.out.println(path);
//			}else if(returnVal == JFileChooser.CANCEL_OPTION) {
//				System.out.println("Cancel");
//			}else if(returnVal == JFileChooser.ERROR_OPTION) {
//				System.out.println("Error");
//			}else {
//				System.out.println("WTF?");
//			}
//		}
	}