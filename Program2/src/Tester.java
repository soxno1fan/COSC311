import java.util.Random;
import java.util.Scanner;

/**
 * This file defines unit tests for different pieces of the COSC 311 Project 2.
 * 
 * @author Mordechai
 * @version 23-feb-2014
 *
 */
public class Tester {

	private static final int SIZE = 10;
	private static Random generator;
	private static Scanner keyboard;

	public static void main(String[] args) {
		generator = new Random();
		keyboard = new Scanner(System.in);
		
		indexTester();
		/*dataStructureTester();*/
		/*dbStackTester();*/
		
		keyboard.close();
	}
	
	public static void indexTester() {
		Index index = new Index();
		for (int i = 0; i < SIZE; i++) {
			int random = generator.nextInt(90)+10;
			index.insert(""+(random),i);
			System.out.print(random+" ");
		}
		
		System.out.print(index);

		keyboard.nextLine();
		index.insert("05", 11);
		System.out.print(index);
		
		System.out.println("Hit enter to delete record 5");
		keyboard.nextLine();
		index.delete(5);
		System.out.println(index);
	}
	
	@SuppressWarnings("unused")
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
