package com.thom.gui;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.thom.utility.GuiUtil;

@SuppressWarnings("serial")
public class GUIMainMenu extends GuiScreen
{
	GuiUtil guiUtil = new GuiUtil();
	
	JPanel panel;
	
	public GUIMainMenu() 
	{
		initGui();
		drawScreen(getWidth(), getHeight());
	}

	private final int WIDTH = 800, HEIGHT = 600;

	public void initGui()
	{
		setTitle("JSONUtil Main Menu");
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
		
		drawButton(0, width / 2 - 220, height / 2 - 20, 200, 40, "ITEMS", panel).setFocusable(false);
		drawButton(1, width / 2 + 20, height / 2 - 20, 200, 40, "BLOCKS", panel).setFocusable(false);

		drawButton(-1, width / 2 - 50, height - 30, 100, 20, "Return", panel);
	}

	@Override
	public void actionPerformed(Object button) 
	{
		switch (buttonMap.get(button)) 
		{
		case 0:
			GUIMenuItemJSON menuItem = new GUIMenuItemJSON();
			menuItem.setVisible(true);
			this.dispose();
			break;	
		case 1:
			GUIMenuBlockJSON menuBlock = new GUIMenuBlockJSON();
			menuBlock.setVisible(true);
			this.dispose();
			break;
		default:
			System.out.println("Default statement called in switch 'actionPerformed' in class GUIMainMenu");
			break;
		}
	}
}