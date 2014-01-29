import java.util.Random;
import java.util.Scanner;

/**
 * This file defines unit tests for different pieces of the COSC 311 Project 1.
 * 
 * @author Mordechai
 * @version 28-jan-2014
 *
 */
public class UnitTester {

	private static final int SIZE = 10;
	private static Random generator;
	private static Scanner keyboard;

	public static void main(String[] args) {
		generator = new Random();
		keyboard = new Scanner(System.in);
		
		/*indexTester();*/
		
		dataStructureTester();
		
		keyboard.close();
	}
	
	public static void indexTester() {
		Index ar = new Index(SIZE);
		for (int i = 0; i < SIZE-3; i++) {
			if (!(ar.insert(""+generator.nextInt(100),""+i))) {
				System.out.println("Error");
				System.exit(0);
			}
		}
		System.out.print(ar);

		keyboard.nextLine();
		ar.insert("05", "11");
		System.out.print(ar);
		keyboard.nextLine();
		ar.insert("10", "12");
		System.out.print(ar);
		keyboard.nextLine();
		ar.insert("3", "13");
		System.out.print(ar);
	}
	
	public static void dataStructureTester() {
		DataStructure test = new DataStructure();
	}
}
