package minimalisticTables.test;

import minimalisticTables.core.MinimalTable;

public class Test2 {
public static void main(String[] args) {
	MinimalTable m1 = new MinimalTable("temp");
	m1.addEntry("1 100000 A 1");
	//m1.display();
	m1.addEntry("12345 12345 B 1");
	//m1.display();
	m1.addEntry("12000 12999 A 2");
	m1.display();
}
}
