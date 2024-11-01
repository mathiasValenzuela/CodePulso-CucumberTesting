package DefinicionPasos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;

import java.util.List;

import org.junit.Assert;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class PasosResolucionTickets {

    private WebDriver driver = DriverManager.getDriver();

    @And("hacer click en el recurso de Tickets para resolución {string}")
    public void hacerClickEnRecursoTicketsResolucion(String xpath) {
        WebElement recursoTickets = DriverManager.getWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        recursoTickets.click();
    }

    @And("hacer click el botón de editar del último ticket registrado")
    public void hacerClickEnBotonEditarUltimoTicket() {
        try {
            WebElement botonEditarUltimoTicket = DriverManager.getWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/main/div[2]/div[3]/div/div/section/div[2]/div[1]/table/tbody/tr[last()]/td[5]/button")));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", botonEditarUltimoTicket);
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", botonEditarUltimoTicket);
        } catch (Exception e) {
            System.out.println("Error al hacer clic en el botón de editar: " + e.getMessage());
        }
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

    @And("hacer click en boton editar de un ticket que su estado sea cerrado")
    public void hacer_click_en_boton_editar_de_un_ticket_que_su_estado_sea_cerrado() {
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        try {
            List<WebElement> filas = DriverManager.getWait().until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
                    By.xpath("//*[@id='panel:r0:2']/div/div/section/div[2]/div[1]/table/tbody/tr")));
            
            boolean ticketCerradoEncontrado = false;
            for (WebElement fila : filas) {
                try {
                    String estado = fila.findElement(By.xpath(".//td[3]/div/p")).getText().trim();
                    if (estado.equals("Cerrado")) {
                        ticketCerradoEncontrado = true;

                        // Hacer clic en el botón editar de esta fila
                        WebElement botonEditar = fila.findElement(By.xpath(".//td[5]/button"));
                        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", botonEditar);
                        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", botonEditar);
                        return;
                        
                    }
                } catch (NoSuchElementException e) {
                    System.out.println("Estado no encontrado en esta fila: " + e.getMessage());
                }
            }

            if (!ticketCerradoEncontrado) {
                System.out.println("No se encontró un ticket cerrado.");
            }
        } catch (Exception e) {
            System.out.println("No se encontró el elemento de estado o el botón de edición: " + e.getMessage());
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

    @And("hacer click en boton editar de un ticket que su estado sea abierto")
    public void hacer_click_en_boton_editar_de_un_ticket_que_su_estado_sea_abierto() {
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        try {
            List<WebElement> filas = DriverManager.getWait().until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
                    By.xpath("//*[@id='panel:r0:2']/div/div/section/div[2]/div[1]/table/tbody/tr")));
            
            boolean ticketAbiertoEncontrado = false;
            for (WebElement fila : filas) {
                try {
                    String estado = fila.findElement(By.xpath(".//td[3]/div/p")).getText().trim();

                    if (estado.equals("Abierto")) {
                    	ticketAbiertoEncontrado = true;

                        // Hacer clic en el botón editar de esta fila
                        WebElement botonEditar = fila.findElement(By.xpath(".//td[5]/button"));
                        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", botonEditar);
                        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", botonEditar);
                        return;
                        
                    }
                } catch (NoSuchElementException e) {
                    System.out.println("Estado no encontrado en esta fila: " + e.getMessage());
                }
            }

            if (!ticketAbiertoEncontrado) {
                System.out.println("No se encontró un ticket abierto.");
            }
        } catch (Exception e) {
            System.out.println("No se encontró el elemento de estado o el botón de edición: " + e.getMessage());
        }
    }
    @And("hacer click en el boton actualizar {string}")
    public void hacerClickEnBotonActualizar(String xpath) {
        try {
            WebElement botonActualizar = DriverManager.getWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            DriverManager.getWait().until(ExpectedConditions.elementToBeClickable(botonActualizar));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", botonActualizar);
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
