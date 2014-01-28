/**
  *	COSC 311 - Sverdlik, Winter 2014
  *	Program 1: Student Database with ordered arrays
  *		This file describes a database data type consisting of a 2D array.
  *	@author Mordechai Sadowsky
  *	@version 21-jan-14
  */
  
public class Database {

	private String data[][];
	private int dbPointer;
	private int size;
	
	public Database() {
		data = new String[3][80];
		dbPointer = 0;
		size = 10;
	}
	
	public Database(int sz) {
		data = new String[3][80];
		dbPointer = 0;
		size = sz;
	}
}