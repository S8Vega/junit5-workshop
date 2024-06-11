package co.com.the_chaos_company.model.shoppingcart;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SuiteDisplayName;

@Suite
@SuiteDisplayName("Shopping Cart Test Suite")
@SelectClasses({ShoppingCartTest.class, ShoppingCartTest2.class})
public class ShoppingCartTestSuite {
}
