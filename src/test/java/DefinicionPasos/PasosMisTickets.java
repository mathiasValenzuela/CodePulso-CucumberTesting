package DefinicionPasos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;
import org.junit.Assert;

public class PasosMisTickets {

    private WebDriver driver = DriverManager.getDriver();

    @Then("espero carga de datos mis tickets")
    public void esperoCargaDeDatosMisTickets() {
        try {
            DriverManager.getWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='root']/div/main/section/div[2]/div[1]/table/tbody/tr/td[1]")));
        } catch (Exception e) {
            System.out.println("Error al esperar la carga de datos de mis tickets: " + e.getMessage());
        }
    }

    @Then("visualizo mis tickets")
    public void visualizoMisTickets() {
        try {
            Thread.sleep(3000);
            System.out.println("Esperando a que mis tickets se visualicen...");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Error durante la espera: " + e.getMessage());
        }
    }

    @And("hacer click en el modulo del menu llamado Soporte {string}")
    public void hacerClickEnModuloSoporte(String xpath) {
        WebElement moduloSoporte = DriverManager.getWait().until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
        moduloSoporte.click();
    }
    
    @Then("hacer click el botón de editar del último ticket registrado {string}")
    public void hacerClickEnBotonEditarUltimoTicket(String xpath) {
        WebElement botonEditar = DriverManager.getWait().until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
        botonEditar.click();
    }

    @Then("visualizar detalle de mi ticket {string}")
    public void visualizarDetalleDeMiTicket(String xpath) {
        try {
            WebElement detalleTicket = DriverManager.getWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            Assert.assertTrue("El detalle del ticket no está visible.", detalleTicket.isDisplayed());
            System.out.println("Los detalles del ticket se visualizan correctamente.");
        } catch (Exception e) {
            System.out.println("Error al visualizar los detalles del ticket: " + e.getMessage());
        }
        
        try {
            Thread.sleep(3000);
            System.out.println("Esperando a que mi detalle de ticket se visualice...");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Error durante la espera: " + e.getMessage());
        }
    }

    @Then("cerrar detalle de mi ticket {string}")
    public void cerrarDetalleDeMiTicket(String xpath) {
        try {
            WebElement botonCerrar = DriverManager.getWait().until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
            botonCerrar.click();
            System.out.println("Detalle del ticket cerrado exitosamente.");
        } catch (Exception e) {
            System.out.println("Error al cerrar el detalle del ticket: " + e.getMessage());
        }
        
        try {
            Thread.sleep(3000);
            System.out.println("Esperando a que mi detalle de ticket se cierre...");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Error durante la espera: " + e.getMessage());
        }
    }

    @Then("hacer click en resolucion del ticket {string}")
    public void clickResolucionTicket(String xpath) {
        try {
            WebElement botonResolucion = DriverManager.getWait().until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
            botonResolucion.click();
            System.out.println("Resolucion del ticket visualizado exitosamente.");
        } catch (Exception e) {
            System.out.println("Error al visualizar resolucion del ticket: " + e.getMessage());
        }
        
        try {
            Thread.sleep(2000);
            System.out.println("Esperando a que mi resolucion de ticket se vea...");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Error durante la espera: " + e.getMessage());
        }
    }
}
