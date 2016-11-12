import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class Problem1 {
	public static void main(String[] args) {
		
		//Scanner scanner = new Scanner(System.in);
		
		Scanner scanner = null;
		try {
			scanner = new Scanner(new File("2.txt"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for (int i = 0; i < 5; i++) {
			String code = scanner.nextLine();
			String guess = scanner.nextLine();
			if (i != 4) {
				scanner.nextLine(); //skip blank space
			}
			int numBlack = numBlack(code, guess);
			int numWhite = numWhite(code, guess);
			System.out.println(numBlack + " " + numWhite);
		}
	}
	
	public static int numBlack(String code, String guess) {
		int count = 0;
		for (int i = 0; i < code.length(); i++) {
			if (code.charAt(i) == guess.charAt(i)) {
				count++;
			}
		}
		return count;
	}
	
	public static int numWhite(String code, String guess) {
		int count = 0;
		for (int i = 0; i < code.length(); i++) {
			for (int j = 0; j < guess.length(); j++) {
//				System.out.println("CODE: " + code + " GUESS: "+ guess);
				//System.out.println("CODE I: " + code.charAt(i) + " GUESS J: "+ guess.charAt(j));
				if (code.charAt(i) == guess.charAt(j) && i != j) {
//					System.out.println("MATCH");
					count++;
				}
			}
		}
		return count;
	}
}
