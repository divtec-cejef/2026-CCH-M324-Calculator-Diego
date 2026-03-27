package ch.divtec;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class CalculatorTest {
    private final Calculator calc = new Calculator();
    private final double DELTA = 0.0001; // Marge d'erreur pour la comparaison de doubles

    // --- TESTS ADDITION ---
    @Test
    void testAddPositifs() {
        assertEquals(8.5, calc.add(5.2, 3.3), DELTA);
    }

    @Test
    void testAddNegatifs() {
        assertEquals(-10.0, calc.add(-7.0, -3.0), DELTA);
    }

    @Test
    void testAddMixte() {
        assertEquals(2.0, calc.add(5.0, -3.0), DELTA);
    }

    @Test
    void testSubtractPositifs() {
        assertEquals(1.5, calc.subtract(5.0, 3.5), DELTA);
    }

    @Test
    void testSubtractNegatifs() {
        // -5 - (-3) = -2
        assertEquals(-2.0, calc.subtract(-5.0, -3.0), DELTA);
    }

    @Test
    void testSubtractVersZero() {
        assertEquals(0.0, calc.subtract(10.5, 10.5), DELTA);
    }

    @Test
    void testMultiplyVirgule() {
        assertEquals(7.5, calc.multiply(2.5, 3.0), DELTA);
    }

    @Test
    void testMultiplyParZero() {
        assertEquals(0.0, calc.multiply(125.0, 0.0), DELTA);
    }

    @Test
    void testMultiplyNegatifs() {
        assertEquals(15.0, calc.multiply(-3.0, -5.0), DELTA);
    }

    @Test
    void testDivideStandard() {
        assertEquals(2.5, calc.divide(5.0, 2.0), DELTA);
    }

    @Test
    void testDivideParZero() {
        // En Java, double / 0.0 donne Infinity (pas d'exception)
        assertTrue(Double.isInfinite(calc.divide(10.0, 0.0)));
    }

    @Test
    void testDivideResultatPeriodique() {
        assertEquals(3.3333, calc.divide(10.0, 3.0), DELTA);
    }

    @Test
    void testFactorialStandard() {
        assertEquals(120, calc.factorial(5));
    }

    @Test
    void testFactorialZero() {
        assertEquals(1, calc.factorial(0));
    }

    @Test
    void testFactorialGrandNombre() {
        assertEquals(479001600L, calc.factorial(12));
    }

    @Test
    void testFactorialInvalidInput() {
        assertThrows(IllegalArgumentException.class, () -> calc.factorial(5.5));
    }
}