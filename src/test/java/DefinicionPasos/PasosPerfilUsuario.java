package DefinicionPasos;

import java.nio.file.Paths;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;

public class PasosPerfilUsuario {

    private WebDriver driver = DriverManager.getDriver();

    @And("hacer click en perfil {string}")
    public void iraPerfil(String xpath) {
        try {
        	driver.findElement(By.xpath(xpath)).click();
        } catch (Exception e) {
            System.out.println("Error al entra al perfil" + e.getMessage());
        }
    }
    
    @Then("cargar archivo en el campo de carga de imagen {string} con el archivo")
    public void cargarArchivo(String xpath) {
        try {
            WebElement inputFile = driver.findElement(By.xpath(xpath));
            String rutaAbsoluta = Paths.get("src/test/resources/assets/imagen10mb.jpg").toAbsolutePath().toString();
            inputFile.sendKeys(rutaAbsoluta);
        } catch (Exception e) {
            System.out.println("Error al cargar el archivo: " + e.getMessage());
        }
    }
    
    @Then("esperar mensaje de error {string}")
    public void esperarError(String xpath) {
        try {
            DriverManager.getWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            Thread.sleep(1000);
        } catch (Exception e) {
            System.out.println("Error al cargar el archivo: " + e.getMessage());
        }
    }
}
