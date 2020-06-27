import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

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
    public void n_numbers_comma_and_newline_delimited_sum() {
        assertEquals(stringCalculator.Add("1,2\n3,4\n5"), 15);
    }

    @Test
    public void n_numbers_new_delimiter_delimited_sum() {
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
}
