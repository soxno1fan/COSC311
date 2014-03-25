public class Index {

	private class IndexRecord {
		
		IndexRecord left, right;
		String key;
		int recordNumber;
		boolean leftIsThread, rightIsThread;
		
		IndexRecord(String k, int recNum) {
			this.key = k;
			this.recordNumber= recNum;
			
			left = null;
			right = null;
			leftIsThread = true;
			rightIsThread = true;
		}
	}
	
	private IndexRecord root;
	private IndexRecord iterator;
	
	public Index() {
		root = null;
		iterator = null;
	}
	
	public boolean isEmpty() {
		return root == null;
	}
	
	public void insert(String k, int rN) {
		IndexRecord newRecord = new IndexRecord(k, rN);
		
		if (this.isEmpty()) {
			root = newRecord;
			return;
		}
		IndexRecord rover = root, roverParent = root;
		int comparison = 0;
		boolean wentLeft = false;
		
		while (rover != null) {
			roverParent = rover;
			comparison = newRecord.key.compareTo(rover.key);
			if (comparison >= 0) {
				newRecord.left = rover; //setting left thread
				wentLeft = false;
				rover = rover.right;
			}
			else {
				newRecord.right = rover; //setting right thread
				rover = rover.left;
				wentLeft = true;
			}
		}
		if (wentLeft) {
			roverParent.left = newRecord;
			roverParent.leftIsThread = false;
		}
		else {
			roverParent.right = newRecord;
			roverParent.rightIsThread = false;
		}
	}
	
	public void resetIterator() {
		iterator = root;
		while (iterator.left != null) {
			iterator = iterator.left;
		}
	}
	
	public void iterate() {
		if (!iterator.rightIsThread) {
			iterator = getSuccessor(iterator);
		}
		else
			iterator = iterator.right;
	}
	
	public int getIteratorRecNum() {
		return iterator.recordNumber;
	}
	
	public IndexRecord getSuccessor(IndexRecord n) {
		IndexRecord rover = root;
		
		return rover;
	}
}
