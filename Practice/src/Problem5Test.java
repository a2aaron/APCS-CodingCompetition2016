import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Problem5Test {
	public static void main(String[] args) {
		Scanner scanner = null;
		try {
			scanner = new Scanner(new File("5.txt"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		for (int j = 0; j < 5; j++) {
			String hand = scanner.nextLine();
			ArrayList<String> cards = new ArrayList<String>();
			String[] cardArray = hand.split(" ");
			for (int i = 0; i < cardArray.length; i++) {
				cards.add(cardArray[i]);
			}
			int hardCardPoints = 0;
			for (int i = 0; i < cards.size(); i++) {
				hardCardPoints += hardCardPoints(cards.get(i));
			}
			double quickTricks = 0;
			
			ArrayList<String> spades = getSuit(cards, "S");
			
			ArrayList<String> hearts = getSuit(cards, "H");
			ArrayList<String> clubs = getSuit(cards, "C");
			ArrayList<String> diamonds = getSuit(cards, "D");
			quickTricks += quickTricks(spades);
			quickTricks += quickTricks(hearts);
			quickTricks += quickTricks(clubs);
			quickTricks += quickTricks(diamonds);
			int longSuits = 0;
			longSuits += longSuits(spades);
			longSuits += longSuits(hearts);
			longSuits += longSuits(clubs);
			longSuits += longSuits(diamonds);
			int[] lengths = { spades.size(), hearts.size(), clubs.size(),
					diamonds.size() };
			Arrays.sort(lengths);
			boolean balenced = isBalenced(lengths);
			System.out.println((hardCardPoints ) + " POINTS");
			System.out.println(quickTricks + " QT");
			if (balenced) {
				System.out.println("BALANCED");
			} else {
				System.out.println("UNBALANCED");
			}
			System.out.println();
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

	public static double quickTricks(ArrayList<String> cardsOfSameSuit) {
		boolean aceExists = hasValue(cardsOfSameSuit, "A");
		boolean kingExists = hasValue(cardsOfSameSuit, "K");
		boolean queenExists = hasValue(cardsOfSameSuit, "Q");
//		System.out.println(cardsOfSameSuit);
		if (aceExists && kingExists && queenExists) {
//			System.out.println("AKQ");
			return 3;
		} else if (aceExists && kingExists) {
//			System.out.println("AK");
			return 2;
		} else if (aceExists && queenExists) {
//			System.out.println("AQ");
			return 1.5;
		} else if (kingExists && queenExists) {
//			System.out.println("KQ");
			return 1;
		} else if (kingExists) {
//			System.out.println("K");
			return 0.5;
		} else if (aceExists) {
//			System.out.println("A");
			return 1;
		} else {
			return 0;
		}
	}

	public static boolean isBalenced(int[] lengths) {
		if (Arrays.equals(lengths, new int[] { 2, 3, 4, 4 })
		 || Arrays.equals(lengths, new int[] { 3, 3, 3, 4 })
		 || Arrays.equals(lengths, new int[] { 2, 3, 3, 5 })) {
			return true;
		} else {
			return false;
		}
	}

	public static int longSuits(ArrayList<String> cardsOfSameSuit) {
		if (cardsOfSameSuit.size() < 6) {
			
			return 0;
		} else {
			return cardsOfSameSuit.size() - 5;
		}
	}

	public static boolean sameSuit(String card1, String card2) {
		return card1.substring(1).equals(card2.substring(1));
	}

	public static boolean suitIs(String card, String suit) {
		return card.substring(1).equals(suit);
	}

	public static ArrayList<String> getSuit(ArrayList<String> cards, String suit) {
		ArrayList<String> newCards = new ArrayList<String>();
		for (int i = 0; i < cards.size(); i++) {
			String card = cards.get(i);
			
			if (suitIs(card, suit)) {
				newCards.add(card);
			}
		}
		return newCards;
	}

	public static boolean hasValue(ArrayList<String> cards, String value) {
		for (int i = 0; i < cards.size(); i++) {
			if (cards.get(i).substring(0, 1).equals(value)) {
				return true;
			}
		}
		return false;
	}
}
