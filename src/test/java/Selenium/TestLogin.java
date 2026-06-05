package Selenium;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import junit.framework.Assert;

public class TestLogin {

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

@Test// 1Prueba de login con credenciales incorrectas
    public void LoginError() throws InterruptedException {
        login("admin", "12345");
        Thread.sleep(2000);
        String err = driver.findElement(By.id("login-error")).getText();
        Assert.assertTrue("Error message not shown", err.contains("❌ Usuário ou senha inválidos. Use admin / 123456"));
        Thread.sleep(2000);
    }
@Test// 2Prueba de login exitoso
    public void LoginCorrecto() throws InterruptedException {
        login("admin", "123456");
        Thread.sleep(2000);
        String ok = driver.findElement(By.id("login-success")).getText();
        Assert.assertTrue("Success message not shown", ok.contains("✅ Login realizado! Redirecionando...")); // Verificar mensaje de bienvenida
        Thread.sleep(2000);

        
        
    }

@Test// 3Prueba de login exitoso y cierre de sesión
    public void LoginSalir() throws InterruptedException {
        login("admin", "123456");
        Thread.sleep(2000); 
        driver.findElement(By.id("logout-button")).click();
        Thread.sleep(2000);
        driver.quit();
    }

}
