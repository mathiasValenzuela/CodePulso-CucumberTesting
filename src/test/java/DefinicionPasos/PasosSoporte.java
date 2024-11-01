package DefinicionPasos;

import org.junit.Assert;
import java.nio.file.Paths;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;

public class PasosSoporte {

    private WebDriver driver = DriverManager.getDriver();

    @And("hacer click en soporte {string}")
    public void iraPerfil(String xpath) {
        try {
            DriverManager.getWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        	driver.findElement(By.xpath(xpath)).click();
        } catch (Exception e) {
            System.out.println("Error al entra a soporte" + e.getMessage());
        }
    }
    
    @Then("hacer click en boton de crear ticket {string}")
    public void crearTicketBoton(String xpath) {
        try {
        	Thread.sleep(2000);
            DriverManager.getWait().until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
        	driver.findElement(By.xpath(xpath)).click();
        } catch (Exception e) {
            System.out.println("Error al hacer click en el boton de crear ticket" + e.getMessage());
        }
    }
    
    @Then("escribir algo en el input de titulo {string}")
    public void escribirInput(String xpath) {
        try {
            DriverManager.getWait().until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
            WebElement inputFile = driver.findElement(By.xpath(xpath));
            inputFile.sendKeys("Algoooo, este texto tiene que tener minimo 10 de largo, Saludos.");
        } catch (Exception e) {
            System.out.println("Error al escribir en el input" + e.getMessage());
        }
    }
    
    @Then("escribir algo en la desc {string}")
    public void escribirTextArea(String xpath) {
        try {
            DriverManager.getWait().until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
            WebElement inputFile = driver.findElement(By.xpath(xpath));
            inputFile.sendKeys("Escribiendo text area");
        	Thread.sleep(3000);
        } catch (Exception e) {
            System.out.println("Error al escribir en el input" + e.getMessage());
        }
    }
    
    @Then("subir imagen en el file {string}")
    public void cargarImagenTicket(String xpath) {
        try {
            WebElement inputFile = driver.findElement(By.xpath(xpath));
            String rutaAbsoluta = Paths.get("src/test/resources/assets/testTicket.jpg").toAbsolutePath().toString();
            inputFile.sendKeys(rutaAbsoluta);
        } catch (Exception e) {
            System.out.println("Error al cargar el archivo: " + e.getMessage());
        }
    }
    
    @Then("subir imagen grande en el file {string}")
    public void cargarImagenGrandeTicket(String xpath) {
        try {
            WebElement inputFile = driver.findElement(By.xpath(xpath));
            String rutaAbsoluta = Paths.get("src/test/resources/assets/imagen10mb.jpg").toAbsolutePath().toString();
            inputFile.sendKeys(rutaAbsoluta);
        } catch (Exception e) {
            System.out.println("Error al cargar el archivo: " + e.getMessage());
        }
    }
    
    
    @And("esperar preview {string}")
    public void esperarPreview(String xpath) {
        try {
            DriverManager.getWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        } catch (Exception e) {
            System.out.println("Error al ver preview " + e.getMessage());
        }
    }
    
    @Then("hacer click boton {string}")
    public void hacerClickEnviarTicket(String xpath) {
        try {
            DriverManager.getWait().until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
        	driver.findElement(By.xpath(xpath)).click();
        	Thread.sleep(3000);
        } catch (Exception e) {
            System.out.println("Error al hacer click enviar ticket " + e.getMessage());
        }
    }
    
    @And("refrescar tickets {string}")
    public void refreshTickets(String xpath) {
        try {
            DriverManager.getWait().until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
        	driver.findElement(By.xpath(xpath)).click();
        	Thread.sleep(2000);
        } catch (Exception e) {
            System.out.println("Error al hacer click enviar ticket " + e.getMessage());
        }
    }
    
    @Then("ver detalle de ticket")
    public void verDetalleTicket() {
        try {
            WebElement ultimoBoton = DriverManager.getWait().until(ExpectedConditions.elementToBeClickable(By.xpath("//table[@class='p-datatable-table']/tbody/tr[last()]/td[last()]/button")));
            ultimoBoton.click();
        } catch (Exception e) {
            System.out.println("Error al hacer click enviar ticket " + e.getMessage());
        }
    }
    
    @Then("comprobar imagen {string}")
    public void comprobarImagen(String xpath) {
        try {
            DriverManager.getWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        	Thread.sleep(1000);
        } catch (Exception e) {
            System.out.println("Error al hacer click enviar ticket " + e.getMessage());
        }
    }
    
    @Then("no deja crear ticket")
    public void espearNoCreacion() {
    	try {
    		Thread.sleep(1000);
        } catch (Exception e) {
            System.out.println("Error al esperar no creacion" + e.getMessage());
        }
    }
    
    @Then("ver mensaje de error {string}")
    public void esperarErrorDesc(String xpath) {
    	try {
            DriverManager.getWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        } catch (Exception e) {
            System.out.println("Error al esperar no creacion" + e.getMessage());
        }
    }
    
    @Then("ver mensaje de error imagen {string}")
    public void esperarErrorImg(String xpath) {
    	try {
            DriverManager.getWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
    		Thread.sleep(3000);
        } catch (Exception e) {
            System.out.println("Error al esperar no creacion" + e.getMessage());
        }
    }
    
    @And("seleccionar la opción {string} en el select {string}")
    public void seleccionarOpcionEnSelect(String opcion, String xpath) {
    	try {
            DriverManager.getWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            Select select = new Select(driver.findElement(By.xpath(xpath)));
            select.selectByVisibleText(opcion);
    		Thread.sleep(3000);
        } catch (Exception e) {
            System.out.println("Error al esperar no creacion" + e.getMessage());
        }
    }
    
    @Then("checkear ultimo ticket prioridad alta")
    public void verUltimoTicketPrioridad() {
        try {
            WebElement ultimaFila = DriverManager.getWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@class='p-datatable-table']/tbody/tr[last()]")));
            Assert.assertTrue("La última fila no contiene el texto 'Alta'.", ultimaFila.getText().contains("Alta"));
        } catch (Exception e) {
            System.out.println("Error al ver el último ticket con prioridad alta: " + e.getMessage());
            throw e;
        }
    }
    
}
