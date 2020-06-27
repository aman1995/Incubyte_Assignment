
import java.util.ArrayList;
import java.util.List;

public class StringCalculator {

    private String delimiter = "[,\n]";
    private String delimiterEnd = "\n";

    public int Add(String numbers) {

        if (numbers.isEmpty())
            return 0;

        if (numbers.startsWith("//")) {
            delimiter = changeDelimiter(numbers);
            numbers = preProcessTheString(numbers);
        }

        return addAll(numbers);
    }

    private int addAll(String numbers) {
        String numbersArray[] = numbers.split(delimiter);
        List<Integer> negativeNumbers = new ArrayList<>();

        int result = 0;
        for (String number : numbersArray) {
            int integerValue = stringToNumber(number);

            if (integerValue < 0)
                negativeNumbers.add(stringToNumber(number));

            result = result + (integerValue > 1000 ? 0 : integerValue);
        }

        checkForNegative(negativeNumbers);
        return result;
    }

    private String preProcessTheString(String numbers) {

        numbers = numbers.substring(numbers.indexOf(delimiterEnd) + 1);
        return numbers;
    }

    private String changeDelimiter(String numbers) {

        delimiter = numbers.charAt(2) + "";
        return delimiter;
    }

    private int stringToNumber(String number) {
        return Integer.parseInt(number);
    }

    private void checkForNegative(List<Integer> negativeNumbers) {
        if (negativeNumbers.size() > 0) {
            throw new RuntimeException("Negatives not allowed: " + negativeNumbers.toString());
        }

    }
}

