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

		entries.add(str);
		debugEntries();
		removeOverlaps();
		
	}
	
	private void debugEntries()
	{
		
	}
	
	private void removeOverlaps()
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
