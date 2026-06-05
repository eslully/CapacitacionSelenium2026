package Selenium;

import java.time.Duration;

import org.junit.After;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestPromocion {

    private final String URL = "file://C:/Users/eslullitel/Documents/desafio_final_selenium_java.html";
    private WebDriver driver;


    @Before
    public final void iniciar(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(URL);    
    }

    @After
    public void cerrar() {
    if (driver != null) {
        driver.quit();
        }
    }

    private void login(String user, String pass) {
        driver.findElement(By.id("login-username")).sendKeys(user);
        driver.findElement(By.id("login-password")).sendKeys(pass);
        driver.findElement(By.id("login-submit")).click();
    }

    @Test
    public void verPromocion (){
    login("admin", "123456");

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(35));
    wait.until(ExpectedConditions.elementToBeClickable(By.id("promotion-button"))).click();

    // Manejar el alert de promoción
    wait.until(ExpectedConditions.alertIsPresent());
    Alert alerta = driver.switchTo().alert();
    String promoTexto = alerta.getText();
    assertEquals("🎁 Promoção liberada: 20% OFF em banho completo!", promoTexto);
    alerta.accept();

    // Logout después de aceptar la promo
    wait.until(ExpectedConditions.elementToBeClickable(By.id("logout-button"))).click();
    }

    

}   


    

