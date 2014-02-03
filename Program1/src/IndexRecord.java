/**
 * COSC 311 - Program 1
 * 
 * This file describes the IndexRecord data type.
 * 	IndexRecords contain a key value (e.g. first name), and a reference number
 * 	so they can be associated with the main record in the database.
 * 
 * @author Mordechai Sadowsky
 * @version 02-feb-2014
 *
 */
public class IndexRecord {
	
	private String key;
	private int recordNumber;
	
	public IndexRecord(String k, int rN) {
		key = k;
		recordNumber = rN;
	}
	
	public int getRecordNumber() {
		return recordNumber;
	}
	
	public int compareTo(IndexRecord otherRecord) {
		return (this.key.compareTo(otherRecord.key));
	}
}
