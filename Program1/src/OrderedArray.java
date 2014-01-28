/**
 * 
 * @author Mordechai Sadowsky
 * @version 21-jan-14
 *
 */
public class OrderedArray {

	private int records[][];
	private int size;
	private int numberOfElements;
	
	public OrderedArray() {
		size = 10;
		records = new int[2][size];
		numberOfElements = 0;
	}
	
	public OrderedArray(int sz) {
		size = sz;
		records = new int[2][size];
		numberOfElements = 0;
	}
	
	public boolean isEmpty() {
		return true;
	}
	
	public boolean isFull() {
		return true;
	}
	
	public boolean insert(int newValue) {
		return true;
	}
	
	public boolean delete(int value) {
		return true;
	}
	
	public int find (String value) {
		return 0;
	}
}
