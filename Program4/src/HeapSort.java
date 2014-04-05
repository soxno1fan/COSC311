import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class HeapSort {

	private static final int SIZE = 10000;
	private static int[] theHeap = new int[SIZE];
	private static int next = 0;
	private static final String PATH =
			"/afs/umich.edu/user/p/o/polyphon/Documents/M/workspace/COSC311/Program4/src/";
	
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		
		System.out.print("Welcome to HeapSort.\n\nPlease enter an input data file name: ");
		String inputName = keyboard.next();
		System.out.print("\nPlease enter an output data file name: ");
		String outputName = keyboard.next();
		
		Scanner fileInput = null;
		PrintWriter fileOutput = null;
		try {
			fileInput = new Scanner(new FileInputStream(PATH+inputName));
			File outFile = new File(PATH+outputName);
			outFile.createNewFile();
			fileOutput = new PrintWriter(new FileOutputStream(outFile));
		}
		catch (IOException e) {
			System.out.println(e.getMessage());
			System.out.println("Don't forget to update file path name!");
			System.exit(1);
		}
		
		for (int i = 0; i < SIZE; i++) {
			theHeap[i] = fileInput.nextInt();
			next++;
		}
		long initialTime = System.currentTimeMillis();
		heapify();
		heapSort();
		long finalTime = System.currentTimeMillis();
		
		for (int i = 0; i < SIZE; i++)
			fileOutput.println(theHeap[i]);
		
		System.out.print("File successfully sorted and output stored in");
		System.out.println(PATH+inputName);
		System.out.print("Sort algorithm execution time (in milliseconds): ");
		System.out.print(finalTime-initialTime);
		
		fileOutput.close();
		fileInput.close();
		keyboard.close();
	}

	private static void heapify() {
		int i = (next-2)/2;
		for (int j = i; j >= 0; j--)
			trickleDown(j);
		
	}
	
	private static void heapSort() {
		int limit = next;
		for (int i =1; i <= limit; i++) {
			int x = pop();
			theHeap[next] = x;
		}
	}
	
	public static void trickleDown(int index) {
		int largerChild;
		int value = theHeap[index];
		while (index < next/2) {
			int left = 2*index+1;
			int right = 2*index+2;
			if (right < next && theHeap[left] < theHeap[right])
				largerChild = right;
			else
				largerChild = left;
			
			if (value >= theHeap[largerChild])
				break;
			
			theHeap[index] = theHeap[largerChild];
			index = largerChild;
		}
		theHeap[index] = value;
	}
	
	public static int pop() {
		int x = theHeap[0];
		theHeap[0] = theHeap[--next];
		trickleDown(0);
		return x;
	}
}
