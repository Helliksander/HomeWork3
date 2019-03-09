import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import static java.lang.String.valueOf;


public class DateOfBirth {


    public static GregorianCalendar generateDateIfBirth() {
        GregorianCalendar randomizedDateOfBirth = new GregorianCalendar();
        int randomizedYear =  randomizeBetweenMinMax(1900, 2019);
        randomizedDateOfBirth.set(randomizedDateOfBirth.YEAR, randomizedYear);
        int randomizedDayOfYear = randomizeBetweenMinMax(1, randomizedDateOfBirth.getActualMaximum(randomizedDateOfBirth.DAY_OF_YEAR));

        randomizedDateOfBirth.set(randomizedDateOfBirth.DAY_OF_YEAR, randomizedDayOfYear);



        return randomizedDateOfBirth;
    }

    public static int randomizeBetweenMinMax(int minimumValue, int maximumValue) {
        int minMaxRandomizationResult = minimumValue + (int)Math.round(Math.random()*(maximumValue-minimumValue));

        return minMaxRandomizationResult;

    }

    public static ArrayList<String> prepareToCellInsertationFormat(GregorianCalendar randomizedDateOfBirth) {

        ArrayList<String> birhInfoArray = new ArrayList<String>(2);

        String formatedString = (randomizedDateOfBirth.get(randomizedDateOfBirth.DAY_OF_MONTH) + "-" + (randomizedDateOfBirth.get(randomizedDateOfBirth.MONTH)+1)
                                                            + "-"  + randomizedDateOfBirth.get(randomizedDateOfBirth.YEAR));

        GregorianCalendar currentDateData = new GregorianCalendar();
        int currentYear = currentDateData.get(Calendar.YEAR);
        int currentDayOfTheYear = currentDateData.get(Calendar.DAY_OF_YEAR);

        int currentAge = currentYear - randomizedDateOfBirth.get(randomizedDateOfBirth.YEAR);
        if (currentDayOfTheYear > randomizedDateOfBirth.DAY_OF_YEAR) {
            currentAge--;
        }

        birhInfoArray.add(formatedString);
        birhInfoArray.add(valueOf(currentAge));
        return birhInfoArray;
    }




}

