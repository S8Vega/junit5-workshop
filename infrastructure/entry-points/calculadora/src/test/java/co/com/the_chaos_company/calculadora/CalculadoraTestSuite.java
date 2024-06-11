package co.com.the_chaos_company.calculadora;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SuiteDisplayName;

@Suite
@SuiteDisplayName("Calculadora Test Suite")
@SelectClasses({CalculadoraSumarTest.class, CalculadoraRestarTest.class})
public class CalculadoraTestSuite {
}
