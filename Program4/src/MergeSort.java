import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class MergeSort {
	
	private static final int SIZE = 10000;
	private static int[] theArray = new int[SIZE];
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
		
		for (int i = 0; i < SIZE; i++)
			theArray[i] = fileInput.nextInt();
		
		long initialTime = System.currentTimeMillis();
		mergeSort();
		long finalTime = System.currentTimeMillis();
		
		for (int i = 0; i < SIZE; i++)
			fileOutput.println(theArray[i]);
		
		System.out.print("File successfully sorted and output stored in");
		System.out.println(PATH+inputName);
		System.out.print("Sort algorithm execution time (in milliseconds): ");
		System.out.print(finalTime-initialTime);
		
		fileOutput.close();
		fileInput.close();
		keyboard.close();
	}
	
	public static void mergeSort() {
		int[] workSpace = new int[SIZE];
		recMergeSort(workSpace, 0, SIZE-1);
	}

	private static void recMergeSort(int[] workSpace, int lowerBound, int upperBound) {
		if(lowerBound == upperBound)
			return;
		else {
			int mid = (lowerBound+upperBound) / 2;
			recMergeSort(workSpace, lowerBound, mid);
			recMergeSort(workSpace, mid+1, upperBound);
			merge(workSpace, lowerBound, mid+1, upperBound);
		}
	}

	private static void merge(int[] workSpace, int lowPtr, int highPtr, int upperBound) {
		int j = 0;
		int lowerBound = lowPtr;
		int mid = highPtr-1;
		int n = upperBound-lowerBound+1;
		while(lowPtr <= mid && highPtr <= upperBound) {
			if(theArray[lowPtr] < theArray[highPtr])
				workSpace[j++] = theArray[lowPtr++];
			else
				workSpace[j++] = theArray[highPtr++];
		}
		while(lowPtr <= mid) {
			workSpace[j++] = theArray[lowPtr++];
		}
		while(highPtr <= upperBound) {
			workSpace[j++] = theArray[highPtr++];
		}
		for(j=0; j<n; j++)
			theArray[lowerBound+j] = workSpace[j];
	}
}
