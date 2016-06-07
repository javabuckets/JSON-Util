package com.thom.gui;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.thom.json.EnumFileType;
import com.thom.json.JSONFileCreator;
import com.thom.reference.PathReference;

@SuppressWarnings("serial")
public class GUIMenuBlockJSON extends GuiScreen
{
	JPanel panel;
	
	JTextField blockName, modID;
	
	public GUIMenuBlockJSON() 
	{
		initGui();
		drawScreen(getWidth(), getHeight());
	}
	
	private final int WIDTH = 800, HEIGHT = 600;
	
	public void initGui() 
	{
		setTitle("JSONUtil Blocks");
		setSize(WIDTH, HEIGHT);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel = new JPanel(null);
		panel.setBackground(new Color(76, 76, 76));
		this.add(panel);
		
		buttonList.clear();
		buttonMap.clear();
	}

	public void drawScreen(int width, int height) 
	{
		drawTitle(width / 2 - 300, 25, panel);
		
		blockName = drawTextField(width / 2 - 205, 210, 200, 20, PathReference.BLOCKNAME, panel);
		modID = drawTextField(width / 2 + 5, 210, 200, 20, PathReference.MODID, panel);
		
		drawButton(0, 20, 290, 100, 20, "Path...", panel);
		drawString(20, 310, WIDTH, 20, PathReference.PATH, panel).setForeground(Color.white);
		
		if (PathReference.PATH != "")
			drawButton(1, width / 2 - 90, 350, 180, 25, "Create Block JSON's", panel);
			
		drawButton(-1, width / 2 - 50, height - 70, 100, 25, "Return", panel);
	}
	
	public void actionPerformed(Object button) 
	{
		switch (buttonMap.get(button)) 
		{
		case -1:
			GUIMainMenu mainMenu = new GUIMainMenu();
			mainMenu.setVisible(true);
			this.dispose();
			break;
		case 0:
			GUIPathSelector pathSelector = new GUIPathSelector(false);
			pathSelector.setLocation(100, 200);
			pathSelector.setVisible(true);
			
			PathReference.ITEMNAME = blockName.getText();
			PathReference.MODID = modID.getText();
			
			this.dispose();
			break;
		case 1:
			PathReference.ITEMNAME = blockName.getText();
			PathReference.MODID = modID.getText();
			JSONFileCreator fileCreator = new JSONFileCreator(EnumFileType.BLOCK);
			fileCreator.generateJSONFile(blockName.getText().toLowerCase(), PathReference.PATH);
			JSONFileCreator fileCreator2 = new JSONFileCreator(EnumFileType.BLOCKSTATE);
			fileCreator2.generateJSONFile(blockName.getText().toLowerCase(), PathReference.PATH);
			JSONFileCreator fileCreator3 = new JSONFileCreator(EnumFileType.ITEMBLOCK);
			fileCreator3.generateJSONFile(blockName.getText().toLowerCase(), PathReference.PATH);
			break;
		default:
			break;
		}
	}
}