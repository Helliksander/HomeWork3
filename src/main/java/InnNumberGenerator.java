import java.util.Arrays;

public class InnNumberGenerator {

    public static String generateNumberArray() {
        int[] wholeNumber = new int[12];

        int indexOfNumber;
        wholeNumber[0] = 7;
        wholeNumber[1] = 7;
        for (indexOfNumber = 2; indexOfNumber <= 10; indexOfNumber++) {
            wholeNumber[indexOfNumber] = (int) (Math.random() * 9);
        }
        wholeNumber[10] = (wholeNumber[0] * 7 + wholeNumber[1] * 2 + wholeNumber[2] * 4 + wholeNumber[3] * 10 + wholeNumber[4] * 3 + wholeNumber[5] * 5
                + wholeNumber[6] * 9 + wholeNumber[7] * 4 + wholeNumber[8] * 6 + wholeNumber[9] * 8) % 11;
        if (wholeNumber[10] > 9) {
            wholeNumber[10] = wholeNumber[10] % 10;
        }

        wholeNumber[11] = (wholeNumber[0] * 3 + wholeNumber[1] * 7 + wholeNumber[2] * 2 + wholeNumber[3] * 4 + wholeNumber[4] * 10 + wholeNumber[5] * 3
                + wholeNumber[6] * 5 + wholeNumber[7] * 9 + wholeNumber[8] * 4 + wholeNumber[9] * 6 + wholeNumber[10] * 8) % 11;

        if (wholeNumber[11] > 9) {
            wholeNumber[11] = wholeNumber[11] % 10;
        }
        String intArrayToString = Arrays.toString(wholeNumber);
        return intArrayToString;
    }

    public static String deleteExcessSymbols(String intArrayToString) {
        String removableSymbols = "[] ,";
        String stringToDeleteFrom = intArrayToString;

        for (char symbolFromStringToDeleteFrom : removableSymbols.toCharArray()) {
            stringToDeleteFrom = stringToDeleteFrom.replace(symbolFromStringToDeleteFrom, ' ');
        }
        String stringToDeleteFromCompleted = stringToDeleteFrom.replaceAll("\\W", "");
        return stringToDeleteFromCompleted;
    }
}
