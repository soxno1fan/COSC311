/**
  *	COSC 311 - Project 1
  *	
  *	This file defines the DatabaseRecord type.
  *
  *	@author Mordechai Sadowsky
  *	@version 28-jan-2014
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