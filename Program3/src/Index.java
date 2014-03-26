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
	private int size;
	
	public Index() {
		root = null;
		iterator = null;
		size = 0;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public void insert(String k, int rN) {
		IndexRecord newRecord = new IndexRecord(k, rN);
		size++;
		if (this.isEmpty()) {
			root = newRecord;
			return;
		}
		IndexRecord rover = root;
		int comparison = 0;
		boolean wentLeft = false;
		
		while (true) {
			comparison = newRecord.key.compareTo(rover.key);
			if (comparison >= 0) {
				newRecord.left = rover; //setting left thread
				wentLeft = false;
				if (rover.rightIsThread)
					break;
				else
					rover = rover.right;
			}
			else {
				newRecord.right = rover; //setting right thread
				wentLeft = true;
				if (rover.leftIsThread)
					break;
				else
					rover = rover.left;
			}
		}
		if (wentLeft) {
			rover.left = newRecord;
			rover.leftIsThread = false;
		}
		else {
			rover.right = newRecord;
			rover.rightIsThread = false;
		}
	}
	
	public void delete(int recordToDelete) {
		this.size--;
		IndexRecord rover = root, roverParent = root;
		boolean wentLeft = false;
		
		while (true) {			
			if (recordToDelete == rover.recordNumber)
				break;
			
			roverParent = rover;
			if (recordToDelete > rover.recordNumber) {
				wentLeft = false;
				rover = rover.right;
			}
			else {
				wentLeft = true;
				rover = rover.left;
			}
		}
		
		if (rover.leftIsThread && rover.rightIsThread) { //if rover is a leaf
			if (wentLeft) {
				roverParent.left = rover.left;
				roverParent.leftIsThread = true;
			}
			else {
				roverParent.right = rover.right;
				roverParent.rightIsThread = true;
			}
		}
		else if (rover.leftIsThread || rover.rightIsThread) { //has one child
			if (wentLeft) {
				if (rover.leftIsThread)
					roverParent.left = rover.right;
				else
					roverParent.left = rover.left;
			}
			else {
				if (rover.leftIsThread)
					roverParent.right = rover.right;
				else
					roverParent.right = rover.left;
			}
		}
		else { //rover/IndexRecord to delete has two children
			IndexRecord successor = getSuccessorForDeletion(rover);
			
			if (rover == root)
				root = successor;
			else if (wentLeft)
				roverParent.left = successor;
			else
				roverParent.right = successor;
			
			successor.left = rover.left;	
		}
	}
	
	public void setIteratorFront() {
		iterator = root;
		while (iterator.left != null) {
			iterator = iterator.left;
		}
	}
	
	public void setIteratorBack() {
		iterator = root;
		while (iterator.right != null) {
			iterator = iterator.right;
		}
	}
	
	public void iterateForward() {
		if (!iterator.rightIsThread)
			iterator = getSuccessor(iterator);
		else
			iterator = iterator.right;
	}
	
	public void iterateBackward() {
		if (!iterator.leftIsThread)
			iterator = getPredecessor(iterator);
		else
			iterator = iterator.left;
	}
	
	public int getIteratorRecNum() {
		return iterator.recordNumber;
	}
	
	
	/**
	 * Returns the in-order successor of a given IndexRecord, while passing
	 * 	the successor's children to the successor's parent and taking on the
	 * 	right child of the given IndexRecord.
	 * @param n
	 * @return
	 */
	public IndexRecord getSuccessorForDeletion(IndexRecord n) {
		IndexRecord successor = n, successorParent = n, rover = n.right;
		
		while (rover != n) { //interesting artifact of threading
			successorParent = successor;
			successor = rover;
			rover = rover.left;
		}
		if (successor != n.right) {
			successorParent.left = successor.right;
			if (successor.rightIsThread) {
				successorParent.leftIsThread = true;
				successor.rightIsThread = false; //because next statement
			}									 //will be hard link
			successor.right = n.right;
		}
		return successor;
	}
	
	public IndexRecord getSuccessor(IndexRecord n) {
		IndexRecord successor = n.right;
		
		while (successor.left != n) { //interesting artifact of threading
			successor = successor.left;
		}
		return successor;
	}
	
	public IndexRecord getPredecessor(IndexRecord n) {
		IndexRecord predecessor = n.left;
		while (predecessor.right != n) { //interesting artifact of threading
			predecessor = predecessor.right;
		}
		return predecessor;
	}

	public int find(String key) {
		IndexRecord rover = root;
		int recNum = 0, comparison = 0;
		
		while (true) {
			comparison = key.compareTo(rover.key);
			if (comparison == 0) {
				recNum = rover.recordNumber;
				break;
			}
			else if (comparison > 0) {
				if (rover.rightIsThread) //reached end of Index without finding
					break;
				else
					rover = rover.right;
			}
			else {
				if (rover.leftIsThread) //reached end of Index without finding
					break;
				else
					rover = rover.left;
			}
		}
		return recNum;
	}

	public int getLength() {
		return size;
	}
}