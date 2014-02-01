import java.util.Random;
import java.util.Scanner;

/**
 * This file defines unit tests for different pieces of the COSC 311 Project 1.
 * 
 * @author Mordechai
 * @version 01-feb-2014
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
		/*dbStackTester();*/
		
		keyboard.close();
	}
	
	public static void indexTester() {
		Index ar = new Index(SIZE);
		for (int i = 0; i < SIZE-3; i++) {
			if (!(ar.insert(""+(generator.nextInt(90)+10),i))) {
				System.out.println("Error");
				System.exit(0);
			}
		}
		System.out.print(ar);

		keyboard.nextLine();
		ar.insert("05", 11);
		System.out.print(ar);
		keyboard.nextLine();
		ar.insert("10", 12);
		System.out.print(ar);
		keyboard.nextLine();
		ar.insert("33", 13);
		System.out.print(ar);
	}
	
	public static void dataStructureTester() {
		DataStructure test = new DataStructure();
	}
	
	public static void dbStackTester() {
		DBStack myStack = new DBStack(15);
		System.out.println("Brand new stack is empty?: "+myStack.isEmpty());
		System.out.println("Or is it full?: "+myStack.isFull());
		
		while (!myStack.isFull()) {
			myStack.push(generator.nextInt(90)+10);
		}
		while (!myStack.isEmpty()) {
			System.out.println(myStack.pop()+" ");
		}
	}
}
