
public class DBStack {

	private int[] stack;
	private int top, bottom, size;
	
	public DBStack(int x) {
		top = 0;
		bottom = 1;
		size = x;
		stack = new int[size];
	}
	
	public boolean isFull() {
		return (top == bottom);
	}
	
	public boolean isEmpty() {
		return (bottom-top == 1);
	}
	
	public boolean push(int x) {
		if (isFull())
			return false;
		stack[bottom++] = x;
		if (bottom == size)
			bottom = 0;
		return true;
	}
	
	public int pop() {
		if (isEmpty())
			return -1;
		int temp = stack[top++];
		if (top == size)
			top = 0;
		return temp;
	}
}
