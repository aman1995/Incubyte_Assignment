
public class StringCalculator {

    private final String delimiter = ",|\n";

    public int Add(String numbers) {

        if (numbers.isEmpty())
            return 0;

        String numbersArray[] = numbers.split(delimiter);

        int result = addAll(numbersArray);
        return result;
    }

    private int addAll(String numbersArray[]) {

        int result = 0;
        for (String number : numbersArray) {
            result += stringToNumber(number);
        }
        return result;
    }

    private int stringToNumber(String number) {
        return Integer.parseInt(number);
    }
}
