import java.util.Random;

public class ExchangeSort {

	public static void main (String[] args) {

		Random generator = new Random();
		int[] array = new int[10];		
		int smaller, i, j, k;
		
		for (k = 0; k < array.length; k++) {
			array[k] = generator.nextInt(100);
			System.out.print(array[k]+" ");
		}
		
		for (i = 0; i < array.length-1; i++) {
			for (j = i; j < array.length-(i+1); j++) {
				if (array[j] > array[j+1]) {
					smaller = array[j];
					array[j] = array[j+1];
					array[j+1] = smaller;
				}
			}
		}
		
		System.out.println();
		for (k = 0; k < array.length; k++)
			System.out.print(array[k]+" ");
	}
}
