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
import static org.junit.Assert.assertEquals;

public class PasosControlDeAcceso {
    private WebDriver driver;
    private int intentosFallidos = 0;

    @Before
    public void setUp() {
        DriverManager.initializeDriver();
        driver = DriverManager.getDriver();
        esperar(1);
    }

    @After
    public void tearDown() {
        DriverManager.quitDriver();
        esperar(1);
    }

    private void esperar(int segundos) {
        try {
            Thread.sleep(segundos * 1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    @Given("al navegar hasta la url {string}")
    public void al_navegar_hasta_la_url(String url) {
        driver.get(url);
        esperar(1);
    }

    @When("hacer click en el campo de usuario {string}")
    public void hacer_click_en_el_campo_de_usuario(String input) {
        DriverManager.getWait().until(ExpectedConditions.elementToBeClickable(By.xpath(input))).click();
        esperar(1);
    }

    @When("coloca en el campo usuario {string} el usuario {string}")
    public void coloca_en_el_campo_usuario_el_texto(String campoUsuario, String usuario) {
        WebElement campoUsuarioElemento = DriverManager.getWait().until(ExpectedConditions.elementToBeClickable(By.xpath(campoUsuario)));
        campoUsuarioElemento.clear();
        campoUsuarioElemento.sendKeys(usuario);
        esperar(1);
    }

    @When("hacer click en el campo de contraseña {string}")
    public void hacer_click_en_el_campo_de_pass(String input) {
        DriverManager.getWait().until(ExpectedConditions.elementToBeClickable(By.xpath(input))).click();
        esperar(1);
    }

    @When("coloca en el campo contraseña {string} la contraseña {string}")
    public void coloca_en_el_campo_pass_la_pass(String campoPassword, String password) {
        WebElement campoPasswordElemento = DriverManager.getWait().until(ExpectedConditions.elementToBeClickable(By.xpath(campoPassword)));
        campoPasswordElemento.clear();
        campoPasswordElemento.sendKeys(password);
        esperar(1);
    }

    @Then("apretar boton de inicio sesion {string}")
    public void apreta_el_boton(String boton) {
        DriverManager.getWait().until(ExpectedConditions.elementToBeClickable(By.xpath(boton))).click();
        esperar(1);
    }

    @Then("esperar el inicio de sesion {string}")
    public void espera_la_sesion(String menu) {
        DriverManager.getWait().until(ExpectedConditions.elementToBeClickable(By.xpath(menu)));
        esperar(1);
    }

    @Then("esperar el mensaje de error {string}")
    public void espera_el_error(String msg) {
        DriverManager.getWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath(msg)));
        esperar(1);
    }

    @Then("verificar mensaje de error {string}")
    public void verificar_mensaje_de_error(String mensajeEsperado) {
        WebElement mensajeError = driver.findElement(By.xpath("//*[@id='root']/section/section/div[1]/div/div/div[2]"));
        DriverManager.getWait().until(ExpectedConditions.visibilityOf(mensajeError));
        assertEquals(mensajeEsperado, mensajeError.getText());
        esperar(1);
    }

    @Then("incrementar contador de intentos fallidos")
    public void incrementar_intentos_fallidos() {
        intentosFallidos++;
        esperar(1);
    }

    @Then("verificar bloqueo de cuenta {string}")
    public void verificar_bloqueo(String mensajeBloqueo) {
        if (intentosFallidos >= 3) {
            DriverManager.getWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath(mensajeBloqueo)));
        }
        esperar(1);
    }

    @When("hace click en el botón de inicio de sesión sin ingresar usuario")
    public void hace_click_sin_usuario() {
        driver.findElement(By.xpath("//*[@id='root']/section/section/div[2]/form/button")).click();
        esperar(1);
    }

    @Then("verificar que el campo usuario es necesario")
    public void verificar_campo_usuario_necesario() {
        WebElement mensajeError = driver.findElement(By.xpath("//*[@id='root']/section/section/div[1]/div/div/div[2]"));
        DriverManager.getWait().until(ExpectedConditions.visibilityOf(mensajeError));
        assertEquals("Este campo es necesario", mensajeError.getText());
        esperar(1);
    }

    @When("cerrar sesión en el sistema")
    public void cerrar_sesion() throws InterruptedException {
        WebElement botonCerrarSesion = DriverManager.getWait().until(ExpectedConditions.elementToBeClickable(By.xpath("//li[@class='logout flex']")));
        botonCerrarSesion.click();
        esperar(1);
    }

    @Then("verificar redirección_login {string}")
    public void verificar_redireccion_login(String url) throws InterruptedException {
        DriverManager.getWait().until(ExpectedConditions.urlToBe(url));
        esperar(1);
    }

    @When("hacer click en el botón {string} {string}")
    public void hacer_click_en_el_boton(String boton, String xpath) throws InterruptedException {
        DriverManager.getWait().until(ExpectedConditions.elementToBeClickable(By.xpath(xpath))).click();
        esperar(1);
    }

    @Given("el usuario está en la página de login")
    public void elUsuarioEstáEnLaPáginaDeLogin() {
        driver.get("https://bridge.codepulso.com/login");
        esperar(1);
    }  

    

    @When("cambia el idioma a Inglés en la aplicación")
    public void cambia_el_idioma_a_ingles_en_la_aplicacion() {
        try {
            Thread.sleep(3000);

            WebElement englishOption = driver.findElement(By.xpath("//*[@id='root']/section/div/div[1]/p"));
            englishOption.click();

            System.out.println("Idioma cambiado a Inglés.");
        } catch (InterruptedException e) {
            System.out.println("La espera fue interrumpida: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error al cambiar el idioma: " + e.getMessage());
        }
    }
    
    @When("cambia el idioma a Español en el login")
    public void cambia_el_idioma_a_español_en_la_aplicacion() {
        try {
            Thread.sleep(3000);

            WebElement englishOption = driver.findElement(By.xpath("//*[@id='root']/section/div/div[2]/p"));
            englishOption.click();

            System.out.println("Idioma cambiado a Español.");
        } catch (InterruptedException e) {
            System.out.println("La espera fue interrumpida: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error al cambiar el idioma: " + e.getMessage());
        }
    }

    @Then("verifica que todo el contenido esté en ingles en el login")
    public void verifica_contenido_en_ingles_en_app() {
        WebElement contenido = driver.findElement(By.xpath("//*[@id='root']/section/div/div[1]/p"));
        assertEquals("Login", contenido.getText());
        esperar(1);
    }

    @When("ingresa un nuevo correo {string} y guarda los cambios")
    public void ingresa_nuevo_correo_y_guarda(String nuevoCorreo) {
        WebElement emailField = driver.findElement(By.id("email"));
        emailField.clear();
        emailField.sendKeys(nuevoCorreo);
        WebElement confirmButton = driver.findElement(By.id("confirm-email"));
        confirmButton.click();
        esperar(1);
    }

    @Then("verifica que el correo se haya actualizado correctamente")
    public void verifica_actualizacion_de_correo() {
        WebElement successMessage = driver.findElement(By.className("success-message"));
        assertEquals("Correo actualizado exitosamente", successMessage.getText());
        esperar(1);
    }

    @When("ingresa un nuevo número de teléfono {string} y guarda los cambios")
    public void ingresa_nuevo_numero_telefono(String nuevoNumero) {
        WebElement phoneField = driver.findElement(By.id("phone"));
        phoneField.clear();
        phoneField.sendKeys(nuevoNumero);
        WebElement confirmButton = driver.findElement(By.id("confirm-phone"));
        confirmButton.click();
        esperar(1);
    }

    @Then("verifica que el número de teléfono se haya actualizado correctamente")
    public void verifica_actualizacion_de_telefono() {
        WebElement successMessage = driver.findElement(By.className("success-message"));
        assertEquals("Teléfono actualizado exitosamente", successMessage.getText());
        esperar(1);
    }

    @Then("esperar {int} segundo")
    public void esperar_segundo(Integer segundos) {
        esperar(segundos);
    }
}
