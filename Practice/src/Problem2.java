import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class Problem2 {

	public static void main(String[] args) {
		Scanner scanner = null;
		try {
			scanner = new Scanner(new File("1.txt"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for (int i = 0; i < 5; i++) {
			int coins = scanner.nextInt();
			int pirates = scanner.nextInt();
			int coinsTaken = 0;
			for (int j = 0; j < pirates; j++) {
				coinsTaken = coins / pirates + coins % pirates;
				coins = coins - coinsTaken;
				System.out.print(coinsTaken + " ");
			}
			System.out.println(coins);
		}

	}

}
