
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    private String delimiter = "[,\n]";
    private String delimiterEnd = "\n";
    private String newDelimiter = "[,]+";
    private String regexPattern = "\\[(.*?)\\]";

    public int Add(String numbers){

        if(numbers.isEmpty())
            return 0;

        if(numbers.startsWith("//")){
            numbers = preProcessTheString(delimiter,numbers.substring(2));
            delimiter = newDelimiter;
        }

        return addAll(numbers);
    }

    private int addAll(String numbers){
        String numbersArray[] = numbers.split(delimiter);
        List<Integer> negativeNumbers = new ArrayList<>();

        int result = 0;
        for(String number : numbersArray){
            int integerValue = stringToNumber(number);

            if(integerValue<0)
                negativeNumbers.add(stringToNumber(number));

            result = result + (integerValue>1000 ? 0 : integerValue);
        }

        checkForNegative(negativeNumbers);
        return result;
    }

    private String preProcessTheString(String delimiter,  String numbers) {
        String numbersArray[] =  numbers.split(delimiterEnd,2);

        regexPattern = (numbersArray[0].length()==1) ? numbersArray[0] : regexPattern;

        Pattern pattern = Pattern.compile(regexPattern);
        Matcher m = pattern.matcher(numbersArray[0]);
        while (m.find())
            numbersArray[1] = numbersArray[1].replaceAll(m.group(), ",");

        return numbers = numbersArray[1];
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