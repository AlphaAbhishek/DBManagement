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
		List<String> tempEntries = new ArrayList<>();
		if(entries.size()!=1){
			String lastEntry = entries.get(entries.size()-1);
			entries.remove(entries.size()-1);
			boolean isModified = false;
			for(String entry : entries)
			{
				if(TableUtility.isActionRequired(entry, lastEntry))
				{
					List<String> modifiedEntries = modifyEntries(entry,lastEntry);
					tempEntries.addAll(modifiedEntries.subList(0, modifiedEntries.size()-1));
					lastEntry = modifiedEntries.get(modifiedEntries.size()-1);
					isModified = true;
				}
				else{
					tempEntries.add(entry);
				}
			}
			if(isModified){
			entries=tempEntries;
			}
			entries.add(lastEntry);
		
		}
	}
	
	
	
	private List<String> modifyEntries(String entry, String newEntry) {
	  return TableUtility.takeAction(entry,newEntry);
	}

	private void removeOverlaps()
	{
		List<String> tempEntries = new ArrayList<>();
		for(String entry : entries)
		{
			if(TableUtility.getLowerBound(entry)<=TableUtility.getHigherBound(entry))
			{
				tempEntries.add(entry);
			}
		}
		entries = tempEntries;
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
