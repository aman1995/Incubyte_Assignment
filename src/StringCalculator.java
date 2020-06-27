public class StringCalculator {

    public int Add(String numbers) {

        if (numbers.isEmpty())
            return 0;

        String numbersArray[] = numbers.split(",");

        if (numbersArray.length == 1)
            return stringToNumber(numbersArray[0]);


        else return (stringToNumber(numbersArray[0]) +
                stringToNumber(numbersArray[1]));
    }

    private int stringToNumber(String number) {
        return Integer.parseInt(number);
    }

}
