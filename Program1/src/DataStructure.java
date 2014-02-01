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
	private final String PATH = "C:\\Users\\212394821\\git\\COSC311\\Program1\\src\\data.txt";
	/*private final String PATH = "/Users/Mordechai/git/COSC311/Program1/src/data.txt";*/
	
	public DataStructure() {
		Scanner inputStream = null;
		int lines = 0;
		try {
			inputStream = new Scanner(new FileInputStream(PATH));
		
			//Compute length of data file
			while (inputStream.hasNext()) {
				inputStream.nextLine();
				lines++;
			}
			System.out.println(lines);
			
			inputStream.close();
			inputStream = new Scanner(new FileInputStream(PATH));
		}
		catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
			System.out.println("Don't forget to update path name for the system!");
			System.exit(1);
		}
		
		//initialize data members
		database = new DatabaseRecord[lines];
		firstNames = new Index(lines);
		lastNames =  new Index(lines);
		ids =  new Index(lines);
		databasePointer = 0;
		
		//Read in database from external file
		for (int i = 0; i < database.length; i++) {
			String first = inputStream.next(), last = inputStream.next(), id = inputStream.next();
			database[i] = new DatabaseRecord(first, last, id);
			firstNames.insert(first, databasePointer);
			lastNames.insert(last, databasePointer);
			ids.insert(id, databasePointer);
			databasePointer++;
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
