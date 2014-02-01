/**
 * COSC 311 - Program 1
 * 
 * This file defines the Index data type as an ordered 2D array of Strings.
 * 	Index instances can be added to, searched, deleted from and displayed:
 * 		insert(), find(), delete(), toString()
 * 
 * @author Mordechai Sadowsky
 * @version 31-jan-2014
 *
 */
public class Index {

	private IndexRecord[] records;
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
	
	/**
	 * Adds a new record to the Index
	 * 
	 * @param key is the new value
	 * @param num is the new record number
	 * @return (record successfully inserted == true)
	 */
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
			if (newRecord.compareToByKey(records[i]) < 0)
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
	
	/**
	 * Searches for a record in IndexRecord array records
	 * 
	 * @param goal is an IndexRecord that is being looked for in Index
	 * @return array index of goal in records, -1 if not found
	 */
	public int findByKey(IndexRecord goal) {
		int low = 0, middle = 0, high = numberOfElements-1;
		while (low <= high) {
			middle = (high-low)/2;
			if (goal.compareToByKey(records[middle]) > 0)
				low = middle+1;
			else if (goal.compareToByKey(records[middle]) < 0)
				high = middle-1;
			else
				return middle;
		}
		return -1;
	}
	
	public int findByKey(String key) {
		int low = 0, middle = 0, high = numberOfElements-1;
		while (low <= high) {
			middle = (high - low)/2;
			if (true);
		}
		return -1;
	}
	
	public String toString() {
		String s = new String();
		for (int i = 0; i < numberOfElements; i++)
			s += i + ": " + records[i].toString()+"\n";
		return s;
	}
}
