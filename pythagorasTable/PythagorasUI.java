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

/**
 * @author Alesia Samylova
 *
 */
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


	public static void main(String[] args) throws ParseException, UnsupportedEncodingException{	
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

			// Leap year calculation
			Boolean isLeapYear = false;
			if ((bYear % 4 != 0) || (bYear % 100 == 0 && bYear % 400 != 0))
				isLeapYear = false;
			else
				isLeapYear = true;

			if (isLeapYear) {
				System.out.println("<" + bYear + ">" + " is leap year");
			} else {
				System.out.println("<" + bYear + ">" + " is not leap year");
			}
			String input_date = bDay + "/" + bMonth + "/" + bYear;
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
			Date birthDate = simpleDateFormat.parse(input_date);

			Calendar calendar = Calendar.getInstance();
			calendar.setTime(birthDate);
			int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
			String strDayOfWeek = "";

			switch (dayOfWeek) {
			case 1: strDayOfWeek = "Sunday"; break;
			case 2: strDayOfWeek = "Monday"; break;
			case 3: strDayOfWeek = "Tuesday"; break;
			case 4: strDayOfWeek = "Wednesday"; break;
			case 5: strDayOfWeek = "Thurday"; break;
			case 6: strDayOfWeek = "Friday"; break;
			case 7: strDayOfWeek = "Saturday"; break;
			default:
			}

			System.out.println("Day of Week: <" + strDayOfWeek +">");

			System.out.println("--------------------------------------------------\n"
					+ "--------- Zodiacal Sign: ----------");
			// Reading Horoscope
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

			//Pythagoras Table Calculation
			PythagorasSquare.getPythagorasSquare(bDay, bMonth, bYear);

			System.out.println("Press 1 to continue or any number to close the window...\n");
			ret = in.nextInt();
		} while (ret==1);
		System.out.println("Bye!");
		in.close();
	}
}
