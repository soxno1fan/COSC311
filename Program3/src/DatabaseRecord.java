/**
 * COSC 311 - Project 3 (threaded)
 *	
 * This file defines the DatabaseRecord type. Each record describes a student,
 *	with a first name, last name and ID number.
 *
 * @author Mordechai Sadowsky
 * @version 02-feb-2014
 *
 */
public class DatabaseRecord {

	private String firstName;
	private String lastName;
	private String idNumber;
	
	public DatabaseRecord(String f, String l, String i) {
		firstName = f;
		lastName = l;
		idNumber = i;
	}
	
	public String toString() {
		return firstName+" "+lastName+" "+idNumber;
	}
}