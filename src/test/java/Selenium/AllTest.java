package Selenium;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
    TestLogin.class,
    TestRegistro.class,
    TestMascota.class,
    TestPromocion.class
})  
public class AllTest {
    
}
