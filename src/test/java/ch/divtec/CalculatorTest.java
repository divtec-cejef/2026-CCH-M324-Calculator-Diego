package ch.divtec;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class CalculatorTest {
    private final Calculator calc = new Calculator();
    @Test
    void testAdd() {
        int result = calc.add(5, 3);

        assertEquals(8, result, "5 + 3 = 8");
    }

    @Test
    void testAddNegative() {
        assertEquals(2, calc.add(5, -3), "5 + (-3) = 2");
    }
}
