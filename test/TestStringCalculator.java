import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestStringCalculator {


    private StringCalculator stringCalculator;

    @Before
    public void init(){
        stringCalculator = new StringCalculator();
    }

    @Test
    public void empty_String_is_Zero() {
        assertEquals(stringCalculator.Add(""), 0);
    }

    @Test
    public void should_return_single_value() {
        assertEquals(stringCalculator.Add("75"), 75);
    }

    @Test
    public void two_numbers_sum_returned() {
        assertEquals(stringCalculator.Add("75,23"), 98);
    }

    @Test
    public void n_numbers_comma_delimited_sum() {
        assertEquals(stringCalculator.Add("1,2,3,4,5"), 15);
    }
    @Test
    public void comma_and_newline_delimited_sum() {
        assertEquals(stringCalculator.Add("1,2\n3,4\n5"), 15);
    }

    @Test
    public void new_delimiter_delimited_sum() {
        assertEquals(stringCalculator.Add("//;\n1;2;3;4"), 10);
    }

    @Test(expected=Exception.class)
    public void negative_numbers_exception_thrown() {
        stringCalculator.Add("3,-1,3,4");
    }

    @Test
    public void negative_numbers_should_be_shown() {

        try
        {
            stringCalculator.Add("3,-1,3,-4");
        }
        catch(RuntimeException re)
        {
            String message = "Negatives not allowed: [-1, -4]";
            assertEquals(message, re.getMessage());
        }
    }

    @Test
    public void should_ignore_numbers_greater_than_1000() {
        assertEquals(stringCalculator.Add("1000,1,3,1002,4"), 1008);
    }

    @Test
    public void delimiter_can_have_any_length() {
        assertEquals(stringCalculator.Add("//[***]\n1***2***3"), 6);
    }

    @Test
    public void multiple_delimiter_allowed() {
        assertEquals(stringCalculator.Add("//[*][%]\n1*2%3"), 6);
    }

    @Test
    public void multiple_delimiter_any_length_allowed() {
        assertEquals(stringCalculator.Add("//[***][%%]\n1***2%%3"), 6);
    }
}
