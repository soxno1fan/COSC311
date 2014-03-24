import java.util.Random;
import java.util.Scanner;

public class OrdArrayDriver {
	
	private static final int SIZE = 10;
	
	public static void main(String[] args) {
		Random generator = new Random();
		Scanner keyboard = new Scanner(System.in);
		
		OrderedArray ar = new OrderedArray(SIZE);
		for (int i = 0; i < SIZE-3; i++) {
			if (!(ar.insert(generator.nextInt(100)))) {
				System.out.println("Error");
				System.exit(0);
			}
		}
		System.out.print(ar);
		
		keyboard.nextLine();
		ar.insert(5);
		System.out.print(ar);
		keyboard.nextLine();
		ar.insert(10);
		System.out.print(ar);
		keyboard.nextLine();
		ar.insert(3);
		System.out.print(ar);
	}
}
