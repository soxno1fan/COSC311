/**
 * COSC 311 - Program 2
 * 
 * This file defines the Index data type as a double-ended doubly linked list.
 * 	Index instances can be added to, searched, and deleted from.
 * 
 * @author Mordechai Sadowsky
 * @version 23-feb-2014
 *
 */
public class Index {

	private IndexRecord front, back;
	
	/**
	 * This inner class describes the <code>IndexRecord</code> data type.
	 * 	IndexRecords contain a key value (e.g. first name); a reference number
	 * 	so they can be associated with the main record in the database; and
	 * 	references to next and previous <code>IndexRecords</code> in the list.
	 *
	 */
	private class IndexRecord {
		
		private IndexRecord previous, next;
		private String key;
		private int recordNumber;
		
		public IndexRecord(String k, int rN) {
			key = k;
			recordNumber = rN;
			previous = null;
			next = null;
		}
		
		public int compareTo(IndexRecord otherRecord) {
			return (this.key.compareTo(otherRecord.key));
		}
	}
	
	public Index() {
		front = null;
		back = null;
	}
	
	public boolean isEmpty() {
		return (front == null);
	}
	
	public int length() {
		int count =0;
		IndexRecord temp = front;
		
		while (temp != null) {
			temp = temp.next;
			count++;
		}
		
		return count;
	}
	
	/**
	 * Adds a new student to the <code>Index</code>
	 * 
	 * @param key is the new value (e.g. first name)
	 * @param recNum is the new <code>recordNumber</code> reference to the full
	 * 	student record in the <code>database</code>
	 */
	public void insert(String key, int recNum) {
		IndexRecord newRecord = new IndexRecord(key, recNum);
		IndexRecord temp = front;
		if (isEmpty()) {
			front = newRecord;
			back = newRecord;
		}
		else {
			while (temp != null && newRecord.compareTo(temp) > 0) {
				temp = temp.next;
			}
            //3 cases:
			if (temp == null) { //new record belongs at the back
				newRecord.previous = back;
				back.next = newRecord;
				back = newRecord;
			}
			else if (temp == front) { //new record belongs at the front
				newRecord.next = front;
				front.previous = newRecord;
				front = newRecord;
			}
			else { //new record belongs in the middle
				newRecord.next = temp;
				newRecord.previous = temp.previous;
				temp.previous.next = newRecord;
				temp.previous = newRecord;
			}
		}

	}
	
	/**
	 * Removes a student record from the <code>Index</code>
	 * 
	 * @param recNum is the reference <code>recordNumber</code> of the student
	 * 	to be deleted
	 */
	public IndexRecord delete(int recNum) {
		IndexRecord temp = front;
		while (temp !=null && temp.recordNumber != recNum) {
			temp = temp.next;
		}
        //3 cases:
		if ((temp == front) && (front != null)) { //record to delete is in front
			front.next.previous=null;
			front = front.next;
		}
		else if ((temp == back) && (back != null)) { //record is in back
			back.previous.next = null;
			back = back.previous;
		}
		else if (temp != null) { //record is in the middle
			temp.next.previous = temp.previous;
			temp.previous.next = temp.next;
		}

		return temp;
	}
	
	/**
	 * Linear search for a record in list of <code>IndexRecord</code>s
	 * 
	 * @param key is the value (e.g. student ID) that is searched for
	 * @return <code>recordNumber</code> of goal; -1 if not found
	 */
	public int find(String key) {
		IndexRecord temp = front;
		int recNum = -1;
		
		while (temp != null && temp.key.compareTo(key) < 0) {
			temp = temp.next;
		}
		if (temp != null && temp.key.equals(key))
			recNum = temp.recordNumber;
		
		return recNum;
	}
	
	/**
	 * Traverses the list forward from <code>front</code>.
	 * 
	 * @param position Number of steps through list to traverse
	 * @return the <code>recordNumber</code> of the <code>IndexRecord</code>
	 * 		at <code>position</code> in the list.
	 */
	public int getRecordNumberForward(int position) {
		int recNum = -1;
		int count = 0;
		IndexRecord temp = front;
		while (temp != null && count < position) {
			temp = temp.next;
			count++;
		}
		if (temp != null) {
			recNum = temp.recordNumber;
		}
		return recNum;
	}
	
	/**
	 * Traverses the list backwards from <code>back</code>.
	 * 
	 * @param position Number of steps through list to traverse
	 * @return the <code>recordNumber</code> of the <code>IndexRecord</code>
	 * 		at <code>position</code> in the list.
	 */
	public int getRecordNumberBackward(int position) {
		int recNum = -1;
		int count = 0;
		IndexRecord temp = back;
		while (temp != null && count < position) {
			temp = temp.previous;
			count++;
		}
		if (temp != null) {
			recNum = temp.recordNumber;
		}
		return recNum;
	}
	
	public String toString() {
		String s = new String();
		IndexRecord temp = front;
		while (temp != null) {
			s += temp.recordNumber+" "+temp.key+"\n";
			temp = temp.next;
		}
		return s;
	}
}
