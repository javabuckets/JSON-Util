package com.thom.gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.thom.utility.GuiUtil;

@SuppressWarnings("serial")
public abstract class GuiScreen extends JFrame
{
	public GuiScreen INSTANCE = this;
	
	public abstract void initGui();
	
	public abstract void drawScreen(int width, int height);
	
	public List<JButton> buttonList = new ArrayList<JButton>();
	public HashMap<JButton, Integer> buttonMap = new HashMap<JButton, Integer>();
	
	public void drawTitle(int x, int y, JPanel panel)
	{
		GuiUtil guiUtil = new GuiUtil();
		JLabel title = new JLabel(new ImageIcon(guiUtil.addImage("./resources/image/title.png")));
		title.setBounds(x, y, 600, 125);
		panel.add(title);
		title.setVisible(true);
	}
	
	public JButton drawButton(int id, int x, int y, int width, int height, String text, JPanel panel)
	{
		JButton btn = new JButton(text);
		btn.setBounds(x, y, width, height);
		btn.setBackground(new Color(66, 119, 255));
		btn.setForeground(Color.white);
		panel.add(btn);
		buttonList.add(btn);
		buttonMap.put(btn, id);
		btn.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				INSTANCE.actionPerformed(e.getSource());
			}
		});
		btn.setVisible(true);
		return btn;
	}
	
	public JTextField drawTextField(int x, int y, int width, int height, String text, JPanel panel)
	{
		JTextField textField = new JTextField(text);
		textField.setBounds(x, y, width, height);
		panel.add(textField);
		textField.setVisible(true);
		return textField;
	}
	
	public JLabel drawString(int x, int y, int width, int height, String text, JPanel panel)
	{
		JLabel label = new JLabel(text);
		label.setBounds(x, y, width, height);
		panel.add(label);
		label.setVisible(true);
		return label;
	}
	
	public void actionPerformed(Object button)
	{
		
	}
}