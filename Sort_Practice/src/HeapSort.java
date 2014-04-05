import java.util.Random;


public class HeapSort {
	
	private static final int SIZE = 20;
	private static int[] theHeap = new int[SIZE+1];
	private static int next = 0;
	
	public static void main(String[] args) {
		Random generator = new Random();
		
		for (int i = 0; i < SIZE; i++) {
			theHeap[i] = generator.nextInt(100);
			next++;
		}
		print("Random, unsorted array:\n");
		printHeap();
		
		heapify();
		print("Array heapified:\n");
		printHeap();
		
		heapSort();
		print("Array sorted:\n");
		printHeap();
	}
	
	public static void heapify() {
		int i = (next-1)/2;
		for (int j = i; j >= 0; j--)
			trickleDown(j);
	}
	
	public static void heapSort() {
		int limit = next;
		for (int i =1; i <= limit; i++) {
			int x = pop();
			theHeap[next] = x;
		}
	}
	
	public static void trickleDown(int index) {
		int largerChild;
		int topValue = theHeap[index];
		while (index < next/2) {
			int left = 2*index+1;
			int right = left+1;
			if (right < next && theHeap[left] < theHeap[right])
				largerChild = right;
			else
				largerChild = left;
			
			if (topValue >= theHeap[largerChild])
				break;
			
			theHeap[index] = theHeap[largerChild];
			index = largerChild;
		}
		theHeap[index] = topValue;
	}
	
	public static int pop() {
		int x = theHeap[0];
		theHeap[0] = theHeap[--next];
		trickleDown(0);
		return x;
	}
	
	public static void printHeap() {
		for (int i = 0; i < SIZE; i++)
			System.out.println(theHeap[i]);
	}
	
	public static void print(String s) {
		System.out.print(s);
	}
}
