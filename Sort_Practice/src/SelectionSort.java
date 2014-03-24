import java.util.Random;

public class SelectionSort {

	public static void main (String[] args) {
		
		Random generator = new Random();
		int[] array = new int[10];		
		int indexOfMinimum, minimum, i, j, k;
		
		for (k = 0; k < array.length; k++)
			array[k] = generator.nextInt(100);
		
		for (k=0; k < array.length; k++)
			System.out.print(array[k]+" ");
		
		for (i=0;i<array.length-1;i++) {
			indexOfMinimum = i;
			for (j=i+1; j<array.length; j++) {
				if (array[indexOfMinimum] > array[j])
					indexOfMinimum = j;
			}
			minimum = array[indexOfMinimum];
			array[indexOfMinimum] = array[i];
			array[i] = minimum;
		}
		
		System.out.println();
		for (k=0; k < array.length; k++)
			System.out.print(array[k]+" ");
	}
}
