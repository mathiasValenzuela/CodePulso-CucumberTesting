package DefinicionPasos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PasosControlDeAcceso {

    private WebDriver driver;
    
    @Before
    public void setUp() {
        DriverManager.initializeDriver();
        driver = DriverManager.getDriver();
    }
    
    @After
    public void tearDown() {
        DriverManager.quitDriver();
    }
    
    @Given("al navegar hasta la url {string}")
    public void al_navegar_hasta_la_url(String url) {
        driver.get(url);
    }

    @When("hacer click en el campo de usuario {string}")
    public void hacer_click_en_el_campo_de_usuario(String input) {
        DriverManager.getWait().until(ExpectedConditions.elementToBeClickable(By.xpath(input))).click();
    }

    @When("coloca en el campo usuario {string} el usuario {string}")
    public void coloca_en_el_campo_usuario_el_texto(String campoUsuario, String usuario) {
        driver.findElement(By.xpath(campoUsuario)).sendKeys(usuario);
    }

    @When("hacer click en el campo de contraseña {string}")
    public void hacer_click_en_el_campo_de_pass(String input) {
        driver.findElement(By.xpath(input)).click();
    }

    @When("coloca en el campo contraseña {string} la contraseña {string}")
    public void coloca_en_el_campo_pass_la_pass(String campoPassword, String password) {
        driver.findElement(By.xpath(campoPassword)).sendKeys(password);
    }

    @Then("apretar boton de inicio sesion {string}")
    public void apreta_el_boton(String boton) {
        driver.findElement(By.xpath(boton)).click();
    }

    @Then("esperar el inicio de sesion {string}")
    public void espera_la_sesion(String menu) {
        DriverManager.getWait().until(ExpectedConditions.elementToBeClickable(By.xpath(menu)));
    }

    @Then("esperar el mensaje de error {string}")
    public void espera_el_error(String msg) {
        DriverManager.getWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath(msg)));
    }
}
