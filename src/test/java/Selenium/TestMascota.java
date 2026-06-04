package Selenium;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestMascota {
    private final String URL = "file:///C:/Users/eslullitel/Documents/desafio_final_selenium_java.html";
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

@Test
    public void testLoginError() {
        login("admin", "12345");
        WebElement errorMsg = driver.findElement(By.id ("login-error"));
        assertEquals("❌ Usuário ou senha inválidos. Use admin / 123456", errorMsg.getText());
    }

   @Test
    public void testLogin() {
        login("admin", "123456");
        WebElement mensajeTexto = driver.findElement(By.id("login-submit"));
        //assertEquals("✅ Login realizado! Redirecionando...", mensajeTexto.getText());
        assertTrue(mensajeTexto.getText().contains("✅ Login realizado! Redirecionando..."));
        
    }
    
    @Test
    public void testLoginSalir() {
        login("admin", "123456");
        driver.findElement(By.id("logout-button")).click();
        
        //WebElement loginForm = driver.findElement(By.id("login-form"));
        //assertTrue(loginForm.isDisplayed());
    }
     

    private void login(String user, String pass) {
        driver.findElement(By.id("login-username")).sendKeys(user);
        driver.findElement(By.id("login-password")).sendKeys(pass);
        driver.findElement(By.id("login-submit")).click();
    }

    @Test
    public void verPromocionSalir () throws InterruptedException{
        login("admin", "123456");
        Thread.sleep(4000);
        driver.findElement(By.id("promotion-button")).click();
        Thread.sleep(4000);
        //driver.findElement(By.id("promotion-message")).click();
        //Thread.sleep(4000);
        driver.findElement(By.id("logout-button")).click();
        Thread.sleep(4000);
        driver.quit();
    }   

        @Test
    public void registrarMascota() throws InterruptedException{
        login("admin", "123456");
        Thread.sleep(4000);
        driver.findElement(By.id("nav-register")).click();
        Thread.sleep(4000);
        driver.findElement(By.id("pet-name")).sendKeys("Lola");//nombre de la mascota
        Thread.sleep(4000);
        driver.findElement(By.id("pet-owner")).sendKeys("Ernesto");//nombre del propietario
        driver.findElement(By.id("pet-species")).sendKeys("Cachorro");//Especie de la mascota
        Thread.sleep(4000);
        driver.findElement(By.id("pet-age")).sendKeys("9 años");//Edad de la mascota
        Thread.sleep(4000);
        driver.findElement(By.id("pet-notes")).sendKeys("Mascota muy juguetona");//Notas de la mascota
        Thread.sleep(4000);
        driver.findElement(By.id("pet-vaccinated")).click();//VAcunacion a tiempo
        Thread.sleep(4000);
        driver.findElement(By.id("pet-photo")).sendKeys("C:\\Users\\eslullitel\\Documents\\imagen_Lola.png");//Foto de la mascota
        Thread.sleep(4000);
        driver.findElement(By.id("save-pet-button")).click();//Guardar la mascota
        Thread.sleep(4000);
        assert driver.findElement(By.id("pets-table-body")).getText().contains("Lola");//Verificar que la mascota se haya registrado correctamente
        driver.quit();

    }   

        @Test
    public void LimpiarRegistro() throws InterruptedException{
        login("admin", "123456");
        Thread.sleep(2000);
        driver.findElement(By.id("nav-register")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("pet-name")).sendKeys("Lola");//nombre de la mascota
        Thread.sleep(2000);
        driver.findElement(By.id("pet-owner")).sendKeys("Ernesto");//nombre del propietario
        driver.findElement(By.id("pet-species")).sendKeys("Cachorro");//Especie de la mascota
        Thread.sleep(2000);
        driver.findElement(By.id("pet-age")).sendKeys("9 años");//Edad de la mascota
        Thread.sleep(2000);
        driver.findElement(By.id("pet-notes")).sendKeys("Mascota muy juguetona");//Notas de la mascota
        Thread.sleep(2000);
        driver.findElement(By.id("pet-vaccinated")).click();//VAcunacion a tiempo
        Thread.sleep(2000);
        driver.findElement(By.id("pet-photo")).sendKeys("C:\\Users\\eslullitel\\Documents\\imagen_Lola.png");//Foto de la mascota
        Thread.sleep(2000);
        driver.findElement(By.id("clear-form-button")).click();//limpiar registro de la mascota
        Thread.sleep(2000);
        driver.quit();
        
    }
    

}
