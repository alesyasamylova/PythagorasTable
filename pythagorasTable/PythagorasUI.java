/**
 * 
 */
package pythagorasTable;
import java.util.Scanner;

import pythagorasTable.ZodiacHoroscope.*;
import pythagorasTable.PythagorasSquare.*;
import java.util.Calendar;
import java.util.Date;
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;

/**
 * @author Alesia Samylova
 *
 */
@SuppressWarnings("unused")
public class PythagorasUI {

	public static void readFileToConsole(String fileName){
		try {
			File horoscopeFile = new File(fileName);
			Scanner myReader = new Scanner(horoscopeFile);
			while (myReader.hasNextLine()) {
				String data = myReader.nextLine();
				System.out.println(data);
			}
			myReader.close();
		} catch (IOException e) {
			System.out.println("An error occured");
			e.printStackTrace();
		}
	}

	public static void getAge(int bDay, int bMonth, int bYear){
		LocalDate today = LocalDate.now();
		LocalDate birthday= LocalDate.of(bYear, bMonth, bDay);

		Period p = Period.between(birthday, today);

		System.out.println("Age: " + p.getYears() + " year(s), " + p.getMonths() 
							+ " month(s), " + p.getDays() + " day(s)");
	}

	public static void defineLeapYear(int bYear){
		if ((bYear % 4 != 0) || (bYear % 100 == 0 && bYear % 400 != 0)) {
			System.out.println("<" + bYear + ">" + " is not leap year");
		}
		else {
			System.out.println("<" + bYear + ">" + " is leap year");
		}
	}

	public static void defineDayOfWeek(int bDay, int bMonth, int bYear) throws ParseException {
		String input_date = bDay + "/" + bMonth + "/" + bYear;
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date birthDate = simpleDateFormat.parse(input_date);

		Calendar calendar = Calendar.getInstance();
		calendar.setTime(birthDate);
		String[] days = new String[] {"Sunday", "Monday", "Tuesday", "Wednesday",
									  "Thursday", "Friday", "Saturday"};
		System.out.println("Day of Week: <" + days[calendar.get(Calendar.DAY_OF_WEEK) - 1] +">");
	}

	public static void main(String[] args) throws ParseException, UnsupportedEncodingException {	
		int ret= 0;
		Scanner in = new Scanner(System.in);
		do {
			System.out.println("--------------------------------------------------\n"
					+ "Welcome to program of astrological calculations!\n"
					+"--------------------------------------------------\n"
					+"Fill in input data of birth");
			System.out.println("Day: ");
			int bDay = in.nextInt();
			System.out.println("Month: ");
			int bMonth = in.nextInt();
			System.out.println("Year: ");
			int bYear = in.nextInt();

			System.out.println("--------------------------------------------------\n"
					+ "Your date of birth (Day.Month.Year):\n"
					+ bDay + "." + bMonth + "." + bYear
					+ "\n--------------------------------------------------");

			//Age calculation
			getAge(bDay, bMonth, bYear);

			// Leap year identification
			defineLeapYear(bYear);

			// Define day of the week
			defineDayOfWeek(bDay, bMonth, bYear);

			// Define Horoscope
			System.out.println("--------------------------------------------------\n"
					+ "--------- Zodiacal Sign: ----------");
			ZodiacHoroscopeSigns horoscopeSign = ZodiacHoroscope.defineZodiac(bDay, bMonth);
			ZodiacElements element = ZodiacHoroscope.defineElement(horoscopeSign);
			String horoscopeFileName = "src\\horoscopeInfo\\" + horoscopeSign.getValue() + "_"
										+ horoscopeSign.toString().toLowerCase() + ".txt";

			System.out.println(horoscopeSign.toString() + "\n");
			System.out.println("This sign has ordinal number equals to " + horoscopeSign.getValue() + "\n");

			readFileToConsole(horoscopeFileName);
			System.out.println("--------------------------------------------------\n");

			System.out.println("Element: " + element.toString() +"\n");
			readFileToConsole("src\\horoscopeInfo\\" + element.toString().toLowerCase().strip()+"_signs.txt");

			// Pythagoras Table Calculation
			PythagorasSquare.getPythagorasSquare(bDay, bMonth, bYear);

			System.out.println("Press 1 to continue or any number to close the window...\n");
			ret = in.nextInt();
		} while (ret==1);
		System.out.println("Bye!");
		in.close();
	}
}
