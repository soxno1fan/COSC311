/**
 * This will be the main driver program for many of your programs. Specifically,
 * you will need to define a data structure and related algorithms to use with this program.
 * We will be using the data file I have provided for you: a file of 68 records. Each record is composed
 * of three fields:
 *      String lastName
 *      String firstName
 *      String ID
 * ID may be implemented as an integer, but it is easier to implement as a string. Both lastName and firstName
 * may not be unique, but the ID **is** unique.
 * 
 * @author Bill Sverdlik, Mordechai Sadowsky
 * @version Version 1.0
 */

import java.util.Scanner;

public class COSC311Driver {

	private static Scanner keyboard;
	private static DataStructure myStructure;
	
	public static void main(String[] args) {
		 
		keyboard = new Scanner(System.in);
		myStructure = new DataStructure();
		int response;

		do {
			System.out.println(" 1 Add a new student");
			System.out.println(" 2 Delete a student");
			System.out.println(" 3 Find a student by ID");
			System.out.println(" 4 List students by ID increasing");
			System.out.println(" 5 List students by first name increasing");
			System.out.println(" 6 List students by last name increasing");
			System.out.println(" 7 List students by ID decreasing");
			System.out.println(" 8 List students by first name decreasing");
			System.out.println(" 9 List students by last name decreasing");
			System.out.println(" ");
			System.out.println(" 0 End");

			response = keyboard.nextInt();

			switch (response) {
				case 1: addIt();
					break;
				case 2: deleteIt();
					break;
				case 3: findIt();
					break;
				case 4: listItIncreasingID();		// or see below for programming trick
					break;
				case 5: listItIncreasingfName();	
					break;
				case 6: listItIncreasinglName();
					break;
				/*case 7: listItDecreasingID();
					break;
				case 8: listItDecreasingfName();
					break;
				case 9: listItDecreasinglName();
					break;*/
				default:        
			}
		} while (response != 0);
	}

	// Case 1: Add a new student. We need a unique ID number
	public static void addIt() {
		String name1, name2, tempID;
		boolean found;

		do {
			System.out.println("Enter a unique ID number to add");
			tempID = keyboard.nextLine();

			//is it unique?
			found = myStructure.search(tempID);
			if (found)
			{
				System.out.print("ID already in use: ");
				System.out.println("Please re-enter a unique ID");
			}
		} while (found);

		// We found a unique ID. Now ask for first and last name
		System.out.println("Enter first name");
		name1 = keyboard.nextLine();
		System.out.println("Enter last name");
		name2 = keyboard.nextLine();

		// add to our data structure
		myStructure.insert(name1,name2,tempID);
	}


	// Case 2: delete a student. A student ID must be prompted for. If the ID number does not exist in the database,
	//    print out a message indicating a such, otherwise delete the entire record
	public static void deleteIt() {
		// you must provide the code!!
	}

	//Case 3: find a student. A student ID must be prompted for. If the ID number is not found, print out a
	//    message indicating as such. Otherwise print out the entire record

	public static void findIt() {

		// you must provide the code!!

	}

	// Cases 4,5,6,7,8,9
	// A little programming trickery. All of the listing methods below can call the SAME method in DataStructure.
	// We'll pass 2 parameters: the first indicates which field, the second indicates which order
	// fieldNum=1 first name
	// fieldNum=2 last name
	// fieldNum=3 ID
	// orderNum=1 increasing
	// orderNum=2 decreasing

	public static void listItIncreasingID() {
		myStructure.listIt(3,1);
	}

	public static void listItIncreasingfName() {
		myStructure.listIt(1,1);
	}

	public static void listItIncreasinglName() {
		myStructure.listIt(2,1);
	}


}    
