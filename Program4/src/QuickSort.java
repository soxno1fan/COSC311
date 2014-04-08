import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class QuickSort {
	
	private static final int SIZE = 10000;
	private static int[] theArray = new int[SIZE];
	private static final String PATH =
			"/afs/umich.edu/user/p/o/polyphon/Documents/M/workspace/COSC311/Program4/src/";
	
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		
		System.out.print("Welcome to QuickSort.\n\nPlease enter an input data file name: ");
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
		
		for (int i = 0; i < SIZE; i++)
			theArray[i] = fileInput.nextInt();
		
		long initialTime = System.currentTimeMillis();
		quickSort();
		long finalTime = System.currentTimeMillis();
		
		for (int i = 0; i < SIZE; i++)
			fileOutput.println(theArray[i]);
		
		System.out.print("File successfully sorted and output stored in ");
		System.out.println(PATH+inputName);
		System.out.print("Sort algorithm execution time (in milliseconds): ");
		System.out.print(finalTime-initialTime);
		
		fileOutput.close();
		fileInput.close();
		keyboard.close();
	}
	
	public static void quickSort() {
		recQuickSort(0, SIZE-1);
	}

	public static void recQuickSort(int left, int right) {
		int size = right-left+1;
		if(size < 10)
			insertionSort(left, right);
		else {
			int pivot = generatePivot(left, right);
			int partition = partitionIt(left, right, pivot);
			recQuickSort(left, partition-1);
			recQuickSort(partition+1, right);
		}
	}

	public static int generatePivot(int left, int right) {
		int center = (left+right)/2;

		if (theArray[left] > theArray[center])
			swap(left, center);

		if (theArray[left] > theArray[right])
			swap(left, right);

		if (theArray[center] > theArray[right])
			swap(center, right);
		
		swap(center, right-1);

		return theArray[right-1];
	}

	public static void swap(int index1, int index2) {
		int temp = theArray[index1];
		theArray[index1] = theArray[index2];
		theArray[index2] = temp;
	}

	public static int partitionIt(int left, int right, long pivot) {
		int leftPtr = left;
		int rightPtr = right - 1;
		while(true)
		{
			while(theArray[++leftPtr] < pivot) {}
			while(theArray[--rightPtr] > pivot) {}
			
			if(leftPtr >= rightPtr)
				break;
			else
				swap(leftPtr, rightPtr);
		}
		swap(leftPtr, right-1);
		return leftPtr;
	}
	
	public static void insertionSort(int left, int right) {
		int in, out;
		for(out=left+1; out<=right; out++) {
			int temp = theArray[out];
			in = out;
			while(in>left && theArray[in-1] >= temp) {
				theArray[in] = theArray[in-1];
				in--;
			}
			theArray[in] = temp;
		}
	}
}