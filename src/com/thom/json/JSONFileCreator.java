package com.thom.json;

import java.io.File;
import java.io.FileWriter;

import javax.swing.JOptionPane;

import com.thom.reference.PathReference;

public class JSONFileCreator 
{	
	EnumFileType fileType;
	
	public JSONFileCreator(EnumFileType fileType) 
	{
		this.fileType = fileType;
	}
	
	public void generateJSONFile(String name, String path)
	{
		try 
		{
			File jsonFile = new File(path + "/" + getPathFromFileType() + "/" + name + ".json");
			FileWriter fw = new FileWriter(jsonFile);
			writeJSONFile(jsonFile, fileType, name);
			fw.close();
			JOptionPane.showMessageDialog(null, name + ".json" + " successfully generated", "InfoBox: " + "JSON Util", JOptionPane.INFORMATION_MESSAGE);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			if (PathReference.i == 0) {
				JOptionPane.showMessageDialog(null, "ERROR! Path is wrong or invalid item/block name.", "JSON Util", JOptionPane.ERROR_MESSAGE); }
			
			PathReference.i++;
			
			if (PathReference.i == 3)
				PathReference.i = 0;
		}
	}
	
	public void writeJSONFile(File file, EnumFileType fileType, String name) throws Exception
	{
		JSONFileWriter fw = new JSONFileWriter();
		
		switch (fileType) 
		{
		case ITEM:
			fw.writeItemFile(file, name);
			break;
		case BLOCK:
			fw.writeBlockFile(file, name);
			break;
		case BLOCKSTATE:
			fw.writeBlockstateFile(file, name);
			break;
		case ITEMBLOCK:
			fw.writeItemBlockFile(file, name);
			break;
		}
	}
	
	private String getPathFromFileType()
	{
		switch(fileType)
		{
		case ITEM:
			return "src\\main\\resources\\assets\\" + PathReference.MODID + "\\models\\item";
		case BLOCK:
			return "src\\main\\resources\\assets\\" + PathReference.MODID + "\\models\\block";
		case BLOCKSTATE:
			return "src\\main\\resources\\assets\\" + PathReference.MODID + "\\blockstates";
		case ITEMBLOCK:
			return "src\\main\\resources\\assets\\" + PathReference.MODID + "\\models\\item";
		}
		return null;
	}
}