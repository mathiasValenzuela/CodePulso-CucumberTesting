package DefinicionPasos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.junit.Assert;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;
import java.util.List;

public class PasosReporteTickets {
    private WebDriver driver = DriverManager.getDriver();

    @And("hacer click en el recurso llamado Tickets {string}")
    public void hacerClickEnRecursoTickets(String xpath) {
        WebElement recursoTickets = DriverManager.getWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        recursoTickets.click();
    }

    @Then("se visualiza el historial completo de tickets")
    public void visualizarHistorialCompletoTickets() {
        WebElement historialTickets = DriverManager.getWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='panel:r0:2']/div/div")));
        
        List<WebElement> filasTickets = driver.findElements(By.xpath("//*[@id='panel:r0:2']/div/div/table/tbody/tr"));
        boolean tieneRegistros = !filasTickets.isEmpty();
        
        Assert.assertTrue("El historial de tickets no se muestra correctamente.", historialTickets.isDisplayed());
        
        if (tieneRegistros) {
            System.out.println("Historial de tickets cargado correctamente con registros visibles.");
        } else {
            System.out.println("Historial de tickets cargado pero no contiene registros.");
        }
        
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
