import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * This file defines the DataStructure type with an array of DatabaseRecords
 * 	and three Index objects. 
 * 
 * @author Mordechai Sadowsky
 * @version 28-jan-2014
 *
 */
public class DataStructure {

	private DatabaseRecord[] database;
	private Index firstNames, lastNames, ids;
	private int databasePointer;
	
	public DataStructure() {
		Scanner inputStream = null;
		try {
			inputStream = new Scanner(new FileInputStream("/Users/Mordechai/git/COSC311/Program1/src/data.txt"));
		}
		catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
			System.exit(0);
		}
		
		//Compute length of data file
		int lines = 0;
		while (inputStream.hasNext()) {
			inputStream.nextLine();
			lines++;
		}
		
		//initialize data members
		database = new DatabaseRecord[lines];
		firstNames = new Index(lines);
		lastNames =  new Index(lines);
		ids =  new Index(lines);
		
		for (int i = 0; i < database.length; i++) {
			database[i] = new DatabaseRecord(inputStream.next(), inputStream.next(), inputStream.next());
			
		}
	}
	
	public boolean search(String id) {
		return true;
	}
	
	public void insert(String f, String l, String i) {
		
	}
	
	public void listIt(int a, int b) {
		
	}
}
