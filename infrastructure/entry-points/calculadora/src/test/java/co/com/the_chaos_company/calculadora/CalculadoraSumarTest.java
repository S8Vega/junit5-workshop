package co.com.the_chaos_company.calculadora;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculadoraSumarTest {

    @Test
    void sumar() {
        int a = 2;
        int b = 3;
        int expected = 5;

        int result = Calculadora.sumar(a, b);

        assertEquals(expected, result);
    }
}