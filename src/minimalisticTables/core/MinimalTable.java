package minimalisticTables.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MinimalTable {
	
	private String name;
	private List<String> entries;
	
	public MinimalTable(String name){
		
		this.name = name;
		entries = new ArrayList<>();
	}
	
	public void addEntry(String str)
	{
		//add entry to list
		//FIXME
		entries.add(str);
		debugEntries();
		
	}
	
	private void debugEntries()
	{
		
	}
	
	private void removeDuplicates()
	{
		//minimize if you have to.
	}
	
	public void display()
	{
		System.out.println();
		System.out.println(name);
		for(String s: entries)
		{
			System.out.println(s);
		}
		
	}
}
