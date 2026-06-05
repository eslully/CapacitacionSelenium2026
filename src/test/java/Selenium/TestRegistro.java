package Selenium;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestRegistro {
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
@Test// Prueba de registro de una mascota con todos los campos completos
    public void registrarMascota() throws InterruptedException{
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
        driver.findElement(By.id("save-pet-button")).click();//Guardar la mascota
        Thread.sleep(2000);
        assert driver.findElement(By.id("pets-table-body")).getText().contains("Lola");//Verificar que la mascota se haya registrado correctamente
        driver.quit();

    }   

@Test// 5Prueba de limpieza del formulario de registro de mascotas
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
        driver.findElement(By.id("clear-form-button")).click();//limpiar registro de la mascota
        Thread.sleep(2000);
        driver.quit();
        
    }
    
    
}
