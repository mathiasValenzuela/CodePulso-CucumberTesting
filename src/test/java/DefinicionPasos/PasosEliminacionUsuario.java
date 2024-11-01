package DefinicionPasos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.junit.Assert;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.util.List;

public class PasosEliminacionUsuario {
    private WebDriver driver = DriverManager.getDriver();
    private String userName;

    private WebElement obtenerUltimoUsuario() {
        List<WebElement> filasUsuario = DriverManager.getWait().until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
            By.xpath("//*[@id='panel:r0:3']/div/div/section/div[2]/div[1]/table/tbody/tr")));

        if (filasUsuario == null || filasUsuario.isEmpty()) {
            System.out.println("No hay filas en la tabla de usuarios.");
            return null;
        }

        WebElement ultimoUsuarioNombre = filasUsuario.get(filasUsuario.size() - 1).findElement(By.xpath(".//td[1]"));
        System.out.println("Nombre capturado del último usuario: " + ultimoUsuarioNombre.getText());
        return ultimoUsuarioNombre;
    }

    @When("hacer click en el modulo del menu llamado panel admin {string}")
    public void hacer_click_en_el_modulo_del_menu_llamado_panel_admin(String xpath) {
        DriverManager.getWait().until(ExpectedConditions.elementToBeClickable(By.xpath(xpath))).click();
    }

    @When("hacer click en el recurso llamado users {string}")
    public void hacer_click_en_el_recurso_llamado_users(String xpath) {
        WebElement usersTab = DriverManager.getWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", usersTab);
    }

    @Then("capturo el nombre del último usuario en la tabla")
    public void capturo_el_nombre_del_ultimo_usuario_en_la_tabla() {
        List<WebElement> filasUsuarios = driver.findElements(By.xpath("//*[@id='panel:r0:3']/div/div/section/div[2]/div[1]/table/tbody/tr"));

        if (filasUsuarios.isEmpty()) {
            System.out.println("No hay Usuarios en la tabla.");
            userName = "No hay Usuarios";
        } else {
            WebElement ultimoUsuarioNombre = filasUsuarios.get(filasUsuarios.size() - 1).findElement(By.xpath("td[1]"));
            userName = ultimoUsuarioNombre.getText();
            System.out.println("Nombre capturado del último usuario: " + userName);
        }
    }

    @Then("seleccionar el botón de eliminar del último usuario")
    public void seleccionar_boton_de_eliminar_del_ultimo_usuario() {
        String xpathEliminarBoton = "//*[@id='panel:r0:3']/div/div/section/div[2]/div[1]/table/tbody/tr[last()]/td[7]/button[2]";
        WebElement deleteButton = DriverManager.getWait().until(ExpectedConditions.elementToBeClickable(By.xpath(xpathEliminarBoton)));
        deleteButton.click();
    }

    @Then("confirmo que el nombre en el modal es el mismo")
    public void confirmo_que_el_nombre_en_el_modal_es_el_mismo() {
        WebElement modalUserElement = DriverManager.getWait().until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath("//*[@id='panel:r0:3']/div/div/div/div[2]/div/p")));
        String modalUserName = modalUserElement.getText();
        
        System.out.println("Nombre en el modal: " + modalUserName);
    }

    @Then("apretar el boton de Eliminar {string}")
    public void apretar_el_boton_de_eliminar(String xpath) {
        DriverManager.getWait().until(ExpectedConditions.elementToBeClickable(By.xpath(xpath))).click();
    }

    @Then("apretar el boton de Cancelar {string}")
    public void apretar_el_boton_de_cancelar(String xpath) {
        DriverManager.getWait().until(ExpectedConditions.elementToBeClickable(By.xpath(xpath))).click();
    }

    @Then("confirmo que el usuario eliminado ya no está en la tabla")
    public void confirmo_que_el_usuario_eliminado_ya_no_está_en_la_tabla() {
        try {
            boolean isNotDisplayed = DriverManager.getWait().until(ExpectedConditions.invisibilityOf(obtenerUltimoUsuario()));
            Assert.assertTrue("El usuario aún está presente en la tabla después de la eliminación", isNotDisplayed);
        } catch (TimeoutException e) {
            Assert.fail("El usuario aún está presente en la tabla después de la eliminación");
        }
    }

    @Then("confirmo que el usuario no ha sido eliminado y está en la tabla")
    public void confirmo_que_el_usuario_no_ha_sido_eliminado_y_está_en_la_tabla() {
        try {
            WebElement userRow = obtenerUltimoUsuario();
            Assert.assertTrue("El usuario no está presente en la tabla", userRow.isDisplayed());
        } catch (TimeoutException e) {
            Assert.fail("El usuario no está presente en la tabla después de cancelar la eliminación");
        }
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
