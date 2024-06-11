package co.com.the_chaos_company.calculadora;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculadoraRestarTest {

    @Test
    void restar() {
        int a = 2;
        int b = 3;
        int expected = -1;

        int result = Calculadora.restar(a, b);

        assertEquals(expected, result);
    }
}