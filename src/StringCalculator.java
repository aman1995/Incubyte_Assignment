
public class StringCalculator {

    private String delimiter = "[,\n]";
    private String delimiterEnd = "\n";

    public int Add(String numbers) {

        if (numbers.isEmpty())
            return 0;

        if (numbers.startsWith("//")) {
            delimiter = numbers.charAt(2) + "";
            numbers = numbers.substring(numbers.indexOf(delimiterEnd) + 1);
        }

        return addAll(numbers);
    }

    private int addAll(String numbers) {
        String numbersArray[] = numbers.split(delimiter);

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
