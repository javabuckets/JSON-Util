package com.thom.gui;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.thom.json.EnumFileType;
import com.thom.json.JSONFileCreator;
import com.thom.reference.PathReference;

@SuppressWarnings("serial")
public class GUIMenuItemJSON extends GuiScreen
{
	JPanel panel;
	
	JTextField itemName, modID;
	
	public GUIMenuItemJSON() 
	{
		initGui();
		drawScreen(getWidth(), getHeight());
	}
	
	private final int WIDTH = 800, HEIGHT = 600;
	
	public void initGui() 
	{
		setTitle("JSONUtil Items");
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
		
		itemName = drawTextField(width / 2 - 205, 210, 200, 25, PathReference.ITEMNAME, panel);
		modID = drawTextField(width / 2 + 5, 210, 200, 25, PathReference.MODID, panel);
		
		drawButton(0, 20, 290, 100, 20, "Path...", panel);
		drawString(20, 310, WIDTH, 25, PathReference.PATH, panel).setForeground(Color.white);
		
		if (PathReference.PATH != "")
			drawButton(1, width / 2 - 75, 350, 150, 25, "Create Item JSON", panel);
		
		drawButton(-1, width / 2 - 50, height - 70, 100, 25, "Return", panel);
	}
	
	@SuppressWarnings("deprecation")
	public void actionPerformed(Object button) 
	{
		switch (buttonMap.get(button)) 
		{
		case -1:
			GUIMainMenu mainMenu = new GUIMainMenu();
			mainMenu.show();
			this.dispose();
			break;
		case 0:
			GUIPathSelector pathSelector = new GUIPathSelector(true);
			pathSelector.setLocation(100, 200);
			pathSelector.show();
			
			PathReference.ITEMNAME = itemName.getText();
			PathReference.MODID = modID.getText();
			
			this.dispose();
			break;
		case 1:
			PathReference.ITEMNAME = itemName.getText();
			PathReference.MODID = modID.getText();
			JSONFileCreator fileCreator = new JSONFileCreator(EnumFileType.ITEM);
			fileCreator.generateJSONFile(itemName.getText().toLowerCase(), PathReference.PATH);
		default:
			break;
		}
	}
}