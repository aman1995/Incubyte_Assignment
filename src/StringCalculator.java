
import java.util.ArrayList;
import java.util.List;

public class StringCalculator {

    private String delimiter = "[,\n]";
    private String delimiterEnd = "\n";

    public int Add(String numbers){

        if(numbers.isEmpty())
            return 0;

        if(numbers.startsWith("//")){
            delimiter = numbers.charAt(2)+"";
            numbers = numbers.substring(numbers.indexOf(delimiterEnd)+1);
        }

        return addAll(numbers);
    }

    private int addAll(String numbers){
        String numbersArray[] = numbers.split(delimiter);
        List<Integer> negativeNumbers = new ArrayList<>();

        int result = 0;
        for(String number : numbersArray){
            if(stringToNumber(number)<0){
                negativeNumbers.add(stringToNumber(number));
            }
            result+=stringToNumber(number);
        }

        checkForNegative(negativeNumbers);
        return result;
    }


    private int stringToNumber(String number){
        return Integer.parseInt(number);
    }

    private void checkForNegative(List<Integer> negativeNumbers) {
        if(negativeNumbers.size()>0){
            throw new RuntimeException("Negatives not allowed: " + negativeNumbers.toString());
        }

    }

}

