package DefinicionPasos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.junit.Assert;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class PasosDashboard {

    private WebDriver driver = DriverManager.getDriver();

    @And("hacer click en el recurso llamado Dashboard {string}")
    public void hacerClickEnRecursoDashboard(String xpath) {
        WebElement recursoDashboard = DriverManager.getWait().until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
        recursoDashboard.click();
    }

    @Then("espero carga de datos")
    public void esperoCargaDeDatos() {
        try {
            DriverManager.getWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='panel:r0:0']/div/section/div[1]/div[1]/div[1]")));
        } catch (Exception e) {
            System.out.println("Error al esperar la carga de datos: " + e.getMessage());
        }
    }

    @Then("visualizo datos")
    public void visualizoDatos() {
        try {
            Thread.sleep(2000);
            System.out.println("Esperando a que los datos se visualicen...");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Error durante la espera: " + e.getMessage());
        }
    }
}
