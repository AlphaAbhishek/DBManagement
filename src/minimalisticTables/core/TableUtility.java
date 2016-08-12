package minimalisticTables.core;

import java.util.ArrayList;
import java.util.List;

public class TableUtility {
	
	static final String newEntryLeftOverlap = "LO";
	static final String newEntryRightOverlap = "RO";
	static final String newEntryIsSubset = "NS";
	static final String newEntryIsSuperset = "NSS";
	static final String newEntryIsSame = "NE";
	static final String newEntryLeftTouching = "NLT";
	static final String newEntryRightTouching = "NRT";

	public static int getLowerBound(String str)
	{
		String[] values = str.split(" ");
		return Integer.parseInt(values[0]);
	}
	
	public static int getHigherBound(String str)
	{
		String[] values = str.split(" ");
		return Integer.parseInt(values[1]);
	}
	
	public static char getStatus(String str)
	{
		String[] values = str.split(" ");
		return values[2].toCharArray()[0];
	}
	
	public static int getTransferCode(String str)
	{
		String[] values = str.split(" ");
		return Integer.parseInt(values[3]);
	}
	
	public static boolean ifLiesInRange(int a,int l, int h)
	{
		return (a>=l)&&(a<=h);
	}
	
	public static boolean areRangesDisjoint(String original,String str2)
	{
		return getHigherBound(str2)<getLowerBound(original)||getHigherBound(original)<getLowerBound(str2);
	}
	
	public static boolean isActionRequired(String entry, String newEntry)
	{
		return (getActionCode(entry,newEntry)!=null)&&(getStatus(entry)!=getStatus(newEntry)||getTransferCode(entry)!=getTransferCode(newEntry));
	}
	
	public static String getActionCode(String entry,String newEntry)
	{
		if(areRangesDisjoint(entry,newEntry))
		{
			return null;
		}
		if(isNewEntryLeftTouching(entry,newEntry))
		{
			return newEntryLeftTouching;
		}
		if(isNewEntryRightTouching(entry,newEntry))
		{
			return newEntryRightTouching;
		}
		if(areRangesLeftOverLap(entry,newEntry))
		{
			return newEntryLeftOverlap;
		}
		if(areRangesRightOverLap(entry,newEntry))
		{
			return newEntryRightOverlap;
		}
		if(isNewEntrySubset(entry,newEntry))
		{
			return newEntryIsSubset;
		}
		if(isNewEntrySuperset(entry,newEntry))
		{
			return newEntryIsSuperset;
		}

		return newEntryIsSame;
		}

	private static boolean isNewEntryRightTouching(String entry, String newEntry) {
		return getLowerBound(newEntry)==getHigherBound(entry);
	}

	private static boolean isNewEntryLeftTouching(String entry, String newEntry) {
		return getLowerBound(entry)==getHigherBound(newEntry);
	}

	private static boolean isNewEntrySuperset(String entry, String newEntry) {
		return (getLowerBound(newEntry)<getLowerBound(entry))&&(getHigherBound(newEntry)>getHigherBound(entry));
	}

	private static boolean isNewEntrySubset(String entry, String newEntry) {
		return (getLowerBound(newEntry)>getLowerBound(entry))&&(getHigherBound(newEntry)<getHigherBound(entry));
	}

	private static boolean areRangesRightOverLap(String entry, String newEntry) {
		return (getLowerBound(entry)<getLowerBound(newEntry))&&(getLowerBound(newEntry)<getHigherBound(entry))&&(getHigherBound(entry)<=getHigherBound(newEntry));
	}

	private static boolean areRangesLeftOverLap(String entry, String newEntry) {
		return (getLowerBound(newEntry)<=getLowerBound(entry))&&(getLowerBound(entry)<getHigherBound(newEntry))&&(getHigherBound(newEntry)<getHigherBound(entry));
	}

	public static List<String> takeAction(String entry, String newEntry) {
		List<String> modifiedEntries = new ArrayList<>();
		switch(getActionCode(entry, newEntry)){
		case newEntryLeftOverlap :{
			modifiedEntries.add(newEntry);
			modifiedEntries.add(getHigherBound(newEntry)+1+" "+getHigherBound(entry)+" "+getStatus(entry)+" "+getTransferCode(entry));
			break;
		}
		case newEntryRightOverlap :{
			modifiedEntries.add(getLowerBound(entry)+" "+(getLowerBound(newEntry)-1)+" "+getStatus(entry)+" "+getTransferCode(entry));
			modifiedEntries.add(newEntry);
			break;
		}
		case newEntryIsSubset :{
			modifiedEntries.add(getLowerBound(entry)+" "+(getLowerBound(newEntry)-1)+" "+getStatus(entry)+" "+getTransferCode(entry));
			modifiedEntries.add(newEntry);
			modifiedEntries.add(getHigherBound(newEntry)+1+" "+getHigherBound(entry)+" "+getStatus(entry)+" "+getTransferCode(entry));
			break;
		}
		case newEntryIsSuperset :{
			modifiedEntries.add(getLowerBound(newEntry)+" "+(getLowerBound(entry)-1)+" "+getStatus(newEntry)+" "+getTransferCode(newEntry));
			modifiedEntries.add(entry);
			modifiedEntries.add(getHigherBound(entry)+1+" "+getHigherBound(newEntry)+" "+getStatus(newEntry)+" "+getTransferCode(newEntry));
			break;
		}
		case newEntryLeftTouching :{
			modifiedEntries.add(newEntry);
			modifiedEntries.add(getHigherBound(newEntry)+1+" "+getHigherBound(entry)+" "+getStatus(entry)+" "+getTransferCode(entry));
			break;
		}
		case newEntryRightTouching :{
			modifiedEntries.add(getLowerBound(entry)+" "+(getLowerBound(newEntry)-1)+" "+getStatus(entry)+" "+getTransferCode(entry));
			modifiedEntries.add(newEntry);
			break;
		}
		case newEntryIsSame :{
			modifiedEntries.add(newEntry);
			break;
		}
		}
		return modifiedEntries;
	}
}
