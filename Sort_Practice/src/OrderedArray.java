/**
 * @author Mordechai Sadowsky
 * @version 21-jan-14
 */
public class OrderedArray {

	private int maxSize;
	private int numberOfElements;
	private int[] values;

	public OrderedArray(int sz) {
		maxSize = sz;
		numberOfElements = 0;
		values = new int[maxSize];
	}
	
	public boolean isFull() {
		return (numberOfElements == maxSize);
	}
	
	public boolean isEmpty() {
		return (numberOfElements == 0);
	}
	
	public boolean insert(int x) {
		if (isFull())
			return false;
		if (isEmpty()) {
			values[0] = x;
			numberOfElements++;
			return true;
		}
		int i;
		for(i = numberOfElements-1; i >= 0; i--) {
			if (x < values[i])
				values[i+1] = values[i];
			else
				break;
		}
		values[i+1] = x;
		numberOfElements++;
		return true;
	}
	
	public int find(int x) {
		int index = -1;
		
		
		
		return index;
	}

	public String toString() {
		String s = new String();
		for (int i = 0; i < values.length; i++)
			s += values[i] + " ";
		s += "\n";
		return s;
	}
}
