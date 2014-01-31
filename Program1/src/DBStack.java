
public class DBStack {

	private int[] stack;
	private int maxSize;
	private int numberOfElements;
	
	public DBStack(int x) {
		maxSize = x;
		numberOfElements = 0;
		stack = new int[maxSize];
	}
	
	public boolean push(int x) {
		if (maxSize == numberOfElements)
			return false;
		
		return true;
	}
}
