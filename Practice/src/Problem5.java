import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;


public class Problem5 {	
	public static void main(String[] args) {
		Scanner scanner = null;
		try {
			scanner = new Scanner(new File("5.txt"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String hand = scanner.nextLine();
		
		String[] cards = hand.split(" ");
		System.out.println(Arrays.toString(cards));
		int hardCardPoints = 0;
		for (int i = 0; i < cards.length; i++) {
			hardCardPoints += hardCardPoints(cards[i]);
		}
	}
	
	public static int hardCardPoints(String card) {
		String value = card.substring(0, 1);
		if (value.equals("A")) {
			return 4;
		} else if (value.equals("K")) {
			return 3;
		} else if (value.equals("Q")) {
			return 2;
		} else if (value.equals("J")) {
			return 1;
		} else {
			return 0;
		}
	}
	
//	public static int quickTricks(String card1, ) {
//		String value = card.substring(0, 1);
//		String suit = card.substring(1);
//		
//		if (value.equals("A") ) {
//			
//		} else if () {
//			
//		} else if () {
//			
//		} else if () {
//			
//		} else if () {
//			
//		} else if () {
//			
//		} 
//	}
//	
//	public static boolean sameSuit(String card1, String card2) {
//		return card1.substring(1).equals(card2.substring(1));
//	}
//	
//	public static String[] getSuit(String[] cards, String suit) {
//		String[] newCards = 
//		for (int i = 0; i > cards.length; i++) {
//			
//		}
//	}
}
