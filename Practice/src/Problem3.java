import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;


public class Problem3 {

	public static void main(String[] args) {
		Scanner scanner = null;
		try {
			scanner = new Scanner(new File("3.txt"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (int i = 0; i < 5; i++) {
		String time = scanner.nextLine();
		int[] timeDigits = {
				Integer.parseInt(time.substring(0, 1)),
				Integer.parseInt(time.substring(1, 2)),
				Integer.parseInt(time.substring(3, 4)),
				Integer.parseInt(time.substring(4, 5))
		};
		
		String timeCheck = scanner.nextLine();
		int[] timeCheckDigits = {
				Integer.parseInt(timeCheck.substring(0, 1)),
				Integer.parseInt(timeCheck.substring(1, 2)),
				Integer.parseInt(timeCheck.substring(3, 4)),
				Integer.parseInt(timeCheck.substring(4, 5))
		};
		
			int total = 0;
			do {
//				System.out.println(Arrays.toString(timeDigits));
				if (timeDigits[0] == timeDigits[1] - 1) {
					total++;
				}
				if (timeDigits[1] == timeDigits[2] - 1) {
					total++;
				}
				if (timeDigits[2] == timeDigits[3] - 1) {
					total++;
				}
				timeDigits = incrementTimeDigits(timeDigits);
			} while (!Arrays.equals(timeDigits,
					incrementTimeDigits(timeCheckDigits)));
			System.out.println(total);
		}
	}
	
	public static int[] incrementTimeDigits(int[] digit) {
		int[] digits = digit.clone();
		
		// add second
		// if 00:09
		if (digits[3] == 9) {
			digits[3] = 0;
			// if 00:59
			if(digits[2] == 5) {
				digits[2] = 0;
				// 23:59
				if (digits[0] == 2 && digits[1] == 3) {
					// 00:00
					digits = new int[] {0, 0, 0, 0}; 
				} 
				// 09:59 or 19:59
				else if (digits[1] == 9) {
					// 10:00 or 20:00
					digits[0]++;
					digits[1] = 0;
				}
				//04:59
				else {
					// 5:00
					digits[1]++;
					digits[2] = 0;
				}
			} else {
				digits[2]++;
				digits[3] = 0;
			}
			
		} else {
			// else do 00:00 -> 00:01
			digits[3]++;
		}
		
		return digits;
	}
	

}
