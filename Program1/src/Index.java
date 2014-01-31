/**
 * COSC 311 - Program 1
 * 
 * This file defines the Index data type as an ordered 2D array of Strings.
 * 	Index instances can be added to, searched, deleted from and displayed:
 * 		insert(), find(), delete(), toString()
 * 
 * @author Mordechai Sadowsky
 * @version 28-jan-2014
 *
 */
public class Index {

	private IndexRecord[] records; //each row consists of [Record][Record Number]
	private int size;
	private int numberOfElements;
	
	public Index(int sz) {
		size = sz;
		records = new IndexRecord[size];
		numberOfElements = 0;
	}
	
	public boolean isEmpty() {
		return (numberOfElements == 0);
	}
	
	public boolean isFull() {
		return (numberOfElements == size);
	}
	
	public boolean insert(String key, int num) {
		IndexRecord newRecord = new IndexRecord(key, num);
		if (isFull())
			return false;
		if (isEmpty()) {
			records[0] = newRecord;
			numberOfElements++;
			return true;
		}
		int i;
		for(i = numberOfElements-1; i >= 0; i--) {
			if (newRecord.compareTo(records[i]) < 0)
				records[i+1] = records[i];
			else
				break;
		}
		records[i+1] = newRecord;
		numberOfElements++;
		return true;
	}
	
	public boolean delete(int value) {
		return true;
	}
	
	public int find (String value) {
		return 0;
	}
	
	public String toString() {
		String s = new String();
		for (int i = 0; i < numberOfElements; i++)
			s += i + ": " + records[i].toString()+"\n";
		return s;
	}
}
