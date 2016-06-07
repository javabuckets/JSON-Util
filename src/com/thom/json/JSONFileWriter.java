package com.thom.json;

import java.io.File;
import java.nio.file.Files;
import java.util.List;

import com.thom.reference.PathReference;

public class JSONFileWriter 
{	
	public void writeItemFile(File file, String name) throws Exception
	{
		writeLine(file, "{");
		writeLine(file, "	" + gs("parent") + ": " + gs("item/generated") + ",");
		writeLine(file, "	" + gs("textures") + ": {");
		writeLine(file, "		" + gs("layer0") + ": " + gs(PathReference.MODID + ":items/" + name));
		writeLine(file, "	}");
		writeLine(file, "}");
	}
	
	public void writeBlockFile(File file, String name) throws Exception
	{	
		writeLine(file, "{");
		writeLine(file, "	" + gs("parent") + ": " + gs("block/cube_all") + ",");
		writeLine(file, "	" + gs("textures") + ": {");
		writeLine(file, "		" + gs("all") + ": " + gs(PathReference.MODID + ":blocks/" + name));
		writeLine(file, "	}");
		writeLine(file, "}");
	}
	
	public void writeBlockstateFile(File file, String name) throws Exception
	{
		writeLine(file, "{");
		writeLine(file, "	" + gs("variants") + ": {");
		writeLine(file, "		" + gs("normal") + ": { " + gs("model") + ": " + gs(PathReference.MODID + ":" + name) + " }");
		writeLine(file, "	}");
		writeLine(file, "}");
	}
	
	public void writeItemBlockFile(File file, String name) throws Exception
	{
		writeLine(file, "{");
		writeLine(file, "	" + gs("parent") + ": " + gs(PathReference.MODID + ":" + "block/" + name));
		writeLine(file, "}");
	}
	
	private String gs(String string)
	{
		String s = "\"" + string + "\"";
		
		return s;
	}
	
	private void writeLine(File file, String line) throws Exception
	{
		List<String> lines = readJSONFile(file);
		
		lines.add(line);
		
		Files.write(file.toPath(), lines);
	}
	
	private List<String> readJSONFile(File file) throws Exception
	{
		return Files.readAllLines(file.toPath());
	}
}