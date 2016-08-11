package minimalisticTables.test;

import java.util.Scanner;

import minimalisticTables.core.MinimalTable;

public class Test {
public static void main(String[] args) {
	Scanner inputStream = new Scanner(System.in);
	String temp = inputStream.nextLine();
	while(!temp.equals("END"))
	{
		MinimalTable m1 = new MinimalTable(temp);
		temp = inputStream.nextLine();
		while(!temp.equals("0"))
		{
			m1.addEntry(temp);
			temp = inputStream.nextLine();
		}
		m1.display();
		temp = inputStream.nextLine();
	}
	
}
}
