/**
 * COSC311 - Program 3 (threaded)
 * 
 * This file describes a stack data type used to store the location of deleted
 * 	student records so those spaces can be filled by new student additions.
 * 
 * @author Mordechai Sadowsky
 * @version 02-feb-2014
 *
 */
public class DBStack {

	private int[] stack;
	private int pointer, size;
	
	public DBStack(int x) {
		pointer = 0;
		size = x;
		stack = new int[size];
	}
	
	public boolean isFull() {
		return (pointer == size);
	}
	
	public boolean isEmpty() {
		return (pointer == 0);
	}
	
	public void push(int x) {
		stack[pointer++] = x;
	}
	
	public int pop() {
		return stack[--pointer];
	}
}
