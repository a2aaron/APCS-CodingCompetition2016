import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Problem4 {

	public static void main(String[] args) {
		Scanner scanner = null;
		try {
			scanner = new Scanner(new File("4.txt"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (int i = 0; i < 5; i++) {
			String date = scanner.nextLine();
			int firstDash = date.indexOf('-');
			int lastDash = date.lastIndexOf('-');
			int day = Integer.parseInt(date.substring(0, firstDash));
			String month = date.substring(firstDash + 1, lastDash)
					.toLowerCase();
			int year = Integer.parseInt(date.substring(lastDash + 1));
			boolean leapYear = isLeapYear(year);
			if (!leapYear) {
				if (month.equals("jan")) {
					day += 0;
				} else if (month.equals("feb")) {
					day += 31;
				} else if (month.equals("mar")) {
					day += 59;
				} else if (month.equals("apr")) {
					day += 90;
				} else if (month.equals("may")) {
					day += 120;
				} else if (month.equals("jun")) {
					day += 151;
				} else if (month.equals("jul")) {
					day += 181;
				} else if (month.equals("aug")) {
					day += 212;
				} else if (month.equals("sep")) {
					day += 243;
				} else if (month.equals("oct")) {
					day += 273;
				} else if (month.equals("nov")) {
					day += 304;
				} else if (month.equals("dec")) {
					day += 334;
				}
			} else {
				if (month.equals("jan")) {
					day += 0;
				} else if (month.equals("feb")) {
					day += 31;
				} else if (month.equals("mar")) {
					day += 59 + 1;
				} else if (month.equals("apr")) {
					day += 90 + 1;
				} else if (month.equals("may")) {
					day += 120 + 1;
				} else if (month.equals("jun")) {
					day += 151 + 1;
				} else if (month.equals("jul")) {
					day += 181 + 1;
				} else if (month.equals("aug")) {
					day += 212 + 1;
				} else if (month.equals("sep")) {
					day += 243 + 1;
				} else if (month.equals("oct")) {
					day += 273 + 1;
				} else if (month.equals("nov")) {
					day += 304 + 1;
				} else if (month.equals("dec")) {
					day += 334 + 1;
				}
			}
			if (day > 364) {
				System.out.println("NYD");
			} else {
				if (day % 28 == 0) {
					System.out.println(day / 28 + " " + 28);
				} else {
					System.out.println(1 + (day / 28) + " " + day % 28);
				}
			}
		}

	}

	public static boolean isLeapYear(int year) {
		if (year % 4 != 0) {
			return false;
		} else if (year % 100 != 0) {
			return true;
		} else if (year % 400 != 0) {
			return false;
		} else {
			return true;
		}
	}
}
