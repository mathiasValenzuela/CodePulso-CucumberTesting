package DefinicionPasos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.junit.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.util.List;

public class PasosMenuPrincipal {
    private WebDriver driver = DriverManager.getDriver();
    
    @And("verificar correcta visualizacion {string}")
    public void esperarMenu(String xpath) {
        try {
            DriverManager.getWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        } catch (Exception e) {
            System.out.println("Error al entra a soporte" + e.getMessage());
        }
    }
    
    @Then("navegar a seccion {string}")
    public void navegarSeccion(String xpath) {
        try {
            WebElement seccion = DriverManager.getWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            seccion.click();
        } catch (Exception e) {
            System.out.println("Error al entra a soporte" + e.getMessage());
        }
    }
    
    @Then("verificar seccion {string} con texto {string}")
    public void verificarSeccion(String xpath, String textoVerificar) {
        try {
            WebElement tituloSeccion = DriverManager.getWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            String tituloText = tituloSeccion.getText();
            Assert.assertEquals(textoVerificar, tituloText);
        } catch (Exception e) {
            System.out.println("Error al entra a soporte" + e.getMessage());
        }
    }
    
    
}
