import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestStringCalculator {

    private StringCalculator stringCalculator;

    @Before
    public void init() {
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
}