import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;


public class Problem6 {

	public static void main(String[] args) {
		Scanner scanner = null;
		try {
			scanner = new Scanner(new File("6.txt"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int startX = scanner.nextInt();
		int startY = scanner.nextInt();
		int[] start = {startX, startY};
		int endX = scanner.nextInt();
		int endY = scanner.nextInt();
		int[] end = {endX, endY};
		int numMoves = scanner.nextInt();
		boolean reachable = false;
		while(numMoves != 0) {
			int[][] newMoves = allPossibleMoves(start);
			for (int i = 0; i < newMoves.length; i++) {
				if (Arrays.equals(newMoves[i], end)) {
					reachable = true;
				}
			}
			numMoves--;
		}
		if (reachable) {
			System.out.println("TRUE");
		} else {
			System.out.println("FALSE");
		}
	}
	
	public static int[][] allPossibleMoves(int[] start) {
		int startX = start[0];
		int startY = start[1];
		int[][] moves = new int[8][2];
		for (int i = 0; i < 8; i++) {
			if (i < 4) {
				moves[i][0] += boolToInt(i % 2 == 0);   
				moves[i][1] += 2 * boolToInt(i % 4== 0);
			} else {
				moves[i][0] += 2 * boolToInt(i % 2== 0);   
				moves[i][1] += boolToInt(i % 4== 0);
			}
		}
		return moves;
	}
	
	public static int boolToInt(boolean isTrue) {
		if (isTrue) {
			return 1;
		} return -1;
	}
}
