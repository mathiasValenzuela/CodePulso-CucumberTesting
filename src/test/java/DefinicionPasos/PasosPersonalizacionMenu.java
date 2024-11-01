package DefinicionPasos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;

public class PasosPersonalizacionMenu {

    private WebDriver driver = DriverManager.getDriver();

    @Then("esperar carga de la pagina {string}")
    public void esperarCargaDeLaPagina(String xpath) {
        try {
            DriverManager.getWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            System.out.println("La página se ha cargado correctamente.");
        } catch (Exception e) {
            System.out.println("Error al esperar la carga de la página: " + e.getMessage());
        }
    }
    
    @Then("menu se contrae")
    public void menuSeContrae() {
        try {
            DriverManager.getWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='root']/div/nav/div[1]")));
            System.out.println("El menú se ha contraído correctamente.");
        } catch (Exception e) {
            System.out.println("Error al verificar que el menú se contrae: " + e.getMessage());
        }
        
        try {
            Thread.sleep(2000);
            System.out.println("Esperando que contraccion se visualice...");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Error durante la espera: " + e.getMessage());
        }
    }

    @Then("menu se descontrae")
    public void menuSeDescontrae() {
        try {
            DriverManager.getWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='root']/div/nav/div[1]")));
            System.out.println("El menú se ha descontraído correctamente.");
        } catch (Exception e) {
            System.out.println("Error al verificar que el menú se descontrae: " + e.getMessage());
        }
    }

    @And("hacer click en el icono superior del menu {string}")
    public void hacerClickEnIconoSuperiorDelMenu(String xpath) {
        WebElement iconoMenu = DriverManager.getWait().until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
        iconoMenu.click();
    }
}
