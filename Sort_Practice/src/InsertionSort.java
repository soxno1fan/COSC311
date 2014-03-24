import java.util.Random;

public class InsertionSort {
	
	public static void main(String[] args) {
		
		Random generator = new Random();
		int[] array = new int[10];
		int temp = 0, i, j, k;
		
		for (k = 0; k < array.length; k++)
			array[k] = generator.nextInt(100);
		
		for (k = 0; k < array.length; k++)
			System.out.print(array[k]+" ");
		
		for (i = 1; i < array.length; i++) {
			temp = array[i];
			for (j = i; j > 0; j--) {
				if (temp > array[j - 1])
					break;
				array[j] = array[j - 1];
			}
			array[j] = temp;
		}
		
		System.out.println();
		for (k=0; k < array.length; k++)
			System.out.print(array[k]+" ");
	}
}
