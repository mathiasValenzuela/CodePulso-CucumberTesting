package DefinicionPasos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en.And;

public class PasosEstadoTickets {

    private WebDriver driver = DriverManager.getDriver();
    
    @And("hacer click en el recurso llamado tickets {string}")
    public void hacerClickEnRecursoDashboard(String xpath) {
        try {
            WebElement recursoDashboard = DriverManager.getWait().until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
            recursoDashboard.click();
            Thread.sleep(1000);
        } catch (Exception e) {
            System.out.println("Error al ingresar a tickets: " + e.getMessage());
        }
    }
    
    @Then("esperar la lista de tickets {string}")
    public void esperarListaTickets(String xpath) {
        try {
            DriverManager.getWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        } catch (Exception e) {
            System.out.println("Error al esperar la lista de tickets " + e.getMessage());
        }
    }
    
    
    @Then("ordenar lista de tickets {string}")
    public void ordenarLista(String xpath) {
        try {
           WebElement botonOrdenar = DriverManager.getWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
           botonOrdenar.click();
        } catch (Exception e) {
            System.out.println("Error al ordenar la lista " + e.getMessage());
        }
    }
    
    @And("abrir el ticket")
    public void abrirelPrimerTicket() {
    	try {
            WebElement primerBoton = DriverManager.getWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@class='p-datatable-table']/tbody/tr[1]/td[last()]/button")));
            primerBoton.click();
    	} catch (Exception e) {
            System.out.println("Error al abrir el ticket"+ e.getMessage());
    	}
    }
    
    @Then("apretar el boton de resolver {string}")
    public void apretarBoton(String xpath) {
        try {
           WebElement resolver = DriverManager.getWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
           resolver.click();
        } catch (Exception e) {
            System.out.println("Error al apretar el boton resolver " + e.getMessage());
        }
    }
    
    @Then("insertar texto en el textarea {string} el titulo {string}")
    public void insertarTextoTextArea(String xpath, String xpathTitle) {
        try {
            WebElement textArea = DriverManager.getWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            WebElement titleTicket = DriverManager.getWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathTitle)));
            String titleString = titleTicket.getText();
            textArea.sendKeys("Titulo del ticket a resolver: " + titleString);
        } catch (Exception e) {
            System.out.println("Error al insertar el texto en el textarea: " + e.getMessage());
        }
    }
    
    @And("cambiar el estado a cerrado {string}")
    public void cambiarEstadoCerrado(String xpath) {
        try {
            DriverManager.getWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            Select select = new Select(driver.findElement(By.xpath(xpath)));
            select.selectByVisibleText("Cerrado");
        } catch (Exception e) {
            System.out.println("Error cambiar el estado: " + e.getMessage());
        }
    }
    
    @And("cambiar el estado a enproceso {string}")
    public void cambiarEstadoProceso(String xpath) {
        try {
            DriverManager.getWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            Select select = new Select(driver.findElement(By.xpath(xpath)));
            select.selectByVisibleText("Cerrado");
        } catch (Exception e) {
            System.out.println("Error cambiar el estado: " + e.getMessage());
        }
    }
    
    @Then("hacer click en actualizar ticket {string}")
    public void clickBotonActualizar(String xpath) {
        try {
            WebElement botonActualizar = DriverManager.getWait().until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
            botonActualizar.click();
        } catch (Exception e) {
            System.out.println("Error cambiar el estado: " + e.getMessage());
        }
    }
    
    @Then("esperar el mensaje de error solucion {string}")
    public void esperarMensajeSolucion(String xpath) {
        try {
        	DriverManager.getWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        } catch (Exception e) {
            System.out.println("Error cambiar el estado: " + e.getMessage());
        }
    }
    
}
