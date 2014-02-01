
public class IndexRecord {
	private String key;
	private int recordNumber;
	
	public IndexRecord(String k, int rN) {
		key = k;
		recordNumber = rN;
	}
	
	public int compareToByKey(IndexRecord otherRecord) {
		return (this.key.compareTo(otherRecord.key));
	}

	public String toString() {
		return (key+" "+recordNumber);
	}
}
