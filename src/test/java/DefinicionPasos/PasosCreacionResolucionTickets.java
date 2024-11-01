package DefinicionPasos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.JavascriptExecutor;
import org.junit.Assert;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class PasosCreacionResolucionTickets {

    private WebDriver driver = DriverManager.getDriver();

    @And("hacer click en el recurso de Tickets para resolución {string}")
    public void hacerClickEnRecursoTicketsResolucion(String xpath) {
        WebElement recursoTickets = DriverManager.getWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        recursoTickets.click();
    }

    @And("hacer click el botón de editar del último ticket registrado")
    public void hacerClickEnBotonEditarUltimoTicket() {
        WebElement botonEditarUltimoTicket = DriverManager.getWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='panel:r0:2']/div/div/section/div[2]/div[1]/table/tbody/tr[last()]/td[5]/button")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", botonEditarUltimoTicket);
        botonEditarUltimoTicket.click();
    }

    @And("hacer click el botón de resolver {string}")
    public void hacerClickBotonResolver(String xpath) {
        WebElement botonResolver = DriverManager.getWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        botonResolver.click();
    }

    @And("seleccionar en el combo desplegable opcion cerrado {string}")
    public void seleccionarOpcionCerrado(String opcionXpath) {
        WebElement opcionCerrado = DriverManager.getWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath(opcionXpath)));
        opcionCerrado.click();
    }

    @And("hacer click el botón de actualizar ticket {string}")
    public void hacerClickBotonActualizarTicket(String xpath) {
        WebElement botonActualizarTicket = DriverManager.getWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        botonActualizarTicket.click();
    }

    @Then("visualizo mensaje debes presentar un solucion {string}")
    public void visualizo_mensaje_debes_presentar_un_solucion(String xpath) {
        WebElement mensaje = DriverManager.getWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        Assert.assertTrue("El mensaje 'debes presentar una solución' no se muestra correctamente.", mensaje.isDisplayed());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    @And("seleccionar y hacer click en boton editar de un ticket que su estado sea cerrado")
    public void seleccionar_y_hacer_click_en_boton_editar_de_un_ticket_que_su_estado_sea_cerrado() {
        try {
            WebElement estadoElemento = DriverManager.getWait().until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//*[@id='panel:r0:2']/div/div/section/div[2]/div[1]/table/tbody/tr[4]/td[3]/div/p")));

            String estado = estadoElemento.getText().trim();
            Assert.assertEquals("Cerrado", estado);

            WebElement botonEditar = DriverManager.getWait().until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//*[@id='panel:r0:2']/div/div/section/div[2]/div[1]/table/tbody/tr[4]/td[5]/button")));

            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", botonEditar);
            botonEditar.click();
        } catch (Exception e) {
            System.out.println("No se encontró el elemento de estado o el botón de edición");
        }
    }

    @Then("visualizo estado y mensaje de usuario {string}")
    public void visualizoEstadoYMensajeDeUsuario(String xpathMensaje) {
        WebElement estadoElemento = DriverManager.getWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathMensaje)));
        Assert.assertTrue("No se muestra el mensaje.", estadoElemento.isDisplayed());

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    @And("seleccionar y hacer click en boton editar de un ticket que su estado sea abierto")
    public void seleccionar_y_hacer_click_en_boton_editar_de_un_ticket_que_su_estado_sea_abierto() {
        try {
            WebElement estadoElemento = DriverManager.getWait().until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//*[@id='panel:r0:2']/div/div/section/div[2]/div[1]/table/tbody/tr[1]/td[3]/div/p")));

            String estado = estadoElemento.getText().trim();
            Assert.assertEquals("Abierto", estado);

            WebElement botonEditar = DriverManager.getWait().until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//*[@id='panel:r0:2']/div/div/section/div[2]/div[1]/table/tbody/tr[1]/td[5]/button")));

            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", botonEditar);
            botonEditar.click();
        } catch (Exception e) {
            System.out.println("No se encontró el elemento de estado o el botón de edición");
        }
    }
    
    @And("hacer click en el boton actualizar {string}")
    public void hacerClickEnBotonActualizar(String xpath) {
        try {
            WebElement botonActualizar = DriverManager.getWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            DriverManager.getWait().until(ExpectedConditions.elementToBeClickable(botonActualizar)); // Espera que sea clickeable
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", botonActualizar); // Asegúrate de que el botón esté visible
            botonActualizar.click();
        } catch (Exception e) {
            System.out.println("Error al hacer clic en el botón de actualizar: " + e.getMessage());
        }
    }

    @Then("visualizo refresh de tabla")
    public void visualizoRefreshDeTabla() {
        WebElement tablaTickets = DriverManager.getWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='panel:r0:2']/div/div/section/div[2]/div[1]/table/tbody")));
        Assert.assertTrue("La tabla de tickets no se ha actualizado correctamente.", tablaTickets.findElements(By.tagName("tr")).size() > 0);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    @And("coloca en el campo de respuesta {string} la respuesta {string}")
    public void colocaEnElCampoDeRespuesta(String xpath, String respuesta) {
        WebElement campoRespuesta = DriverManager.getWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        campoRespuesta.sendKeys(respuesta);
    }

    @Then("visualizo mensaje cargando {string}")
    public void visualizoMensajeCargando(String xpath) {
        WebElement botonCargando = DriverManager.getWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        DriverManager.getWait().until(ExpectedConditions.textToBePresentInElement(botonCargando, "Cargando..."));
        
        Assert.assertTrue("El botón no está deshabilitado cuando debería estarlo.", !botonCargando.isEnabled());

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

}
