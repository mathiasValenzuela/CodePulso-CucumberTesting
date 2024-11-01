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

public class PasosDeshabilitarUsuario {
    private WebDriver driver = DriverManager.getDriver();
    
    @And("esperar renderizar tabla {string}")
    public void esperarRenderizar(String xpath) {
        try {
            DriverManager.getWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        } catch (Exception e) {
            System.out.println("Error al entra a soporte" + e.getMessage());
        }
    }
    
    
    @Then("accionar el boton editar del primer usuario {string}")
    public void primeraAccion(String xpath) {
        try {
            WebElement editButton = DriverManager.getWait().until(ExpectedConditions.elementToBeClickable(By.xpath(xpath + "/tbody/tr[1]/td[last()]/button[1]")));
            editButton.click();
        } catch (Exception e) {
            System.out.println("Error al accionar el botón de editar: " + e.getMessage());
        }
    }
    
    @And("ordenar por rol {string}")
    public void ordenarRol(String xpath) {
        try {
            DriverManager.getWait().until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
        	driver.findElement(By.xpath(xpath)).click();
        } catch (Exception e) {
            System.out.println("Error al clickear el toggle" + e.getMessage());
        }
    }
    
    @And("ordenar por estado {string}")
    public void ordenarEstado(String xpath) {
        try {
            DriverManager.getWait().until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
        	driver.findElement(By.xpath(xpath)).click();
        } catch (Exception e) {
            System.out.println("Error al clickear el toggle" + e.getMessage());
        }
    }
    
    @And("clickear el toggle {string}")
    public void clickToggle(String xpath) {
        try {
            DriverManager.getWait().until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
        	driver.findElement(By.xpath(xpath)).click();
        } catch (Exception e) {
            System.out.println("Error al clickear el toggle" + e.getMessage());
        }
    }
    
    @Then("esperar el mensaje de exito {string}")
    public void esperarToast(String xpath) {
        try {
            DriverManager.getWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        } catch (Exception e) {
            System.out.println("Error al ver el toast " + e.getMessage());
        }
    }
    
}
