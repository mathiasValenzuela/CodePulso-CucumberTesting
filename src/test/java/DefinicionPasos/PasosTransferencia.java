package DefinicionPasos;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;


import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PasosTransferencia {
	static WebDriver driver;
    static WebDriverWait wait; // Declarar WebDriverWait como variable global
	static String pathDriver="./src/test/resources/chrome/chromedriver.exe";
	static String tipoDriver="webdriver.chrome.driver";
	
	
	@Before
	public void setUp() throws Exception {
		System.setProperty(tipoDriver, pathDriver);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
	@After
	public void tearDown() throws Exception {
		if (driver != null)
			driver.quit();
	}
	
	@Given("al navegar hasta la url {string}")
	public void al_navegar_hasta_la_url(String url) throws InterruptedException {
		driver.get(url);
	}
	
	@When("hacer click en el campo de usuario {string}")
	public void hacer_click_en_el_campo_de_usuario(String input) throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(input)));
		driver.findElement(By.xpath(input)).click();
	}

	@When("coloca en el campo usuario {string} el usuario {string}")
	public void coloca_en_el_campo_usuario_el_texto(String campoUsuario, String usuario) throws InterruptedException {
	    WebElement campo = driver.findElement(By.xpath(campoUsuario));
	    campo.sendKeys(usuario);
	}
	
	@When("hacer click en el campo de contraseña {string}")
	public void hacer_click_en_el_campo_de_pass(String input) throws InterruptedException {
		driver.findElement(By.xpath(input)).click();
	}
	
	@When("coloca en el campo contraseña {string} la contraseña {string}")
	public void coloca_en_el_campo_pass_la_pass(String campoPassword, String password) throws InterruptedException {
	    WebElement campo = driver.findElement(By.xpath(campoPassword));
	    campo.sendKeys(password);
	}
	
	@Then("apretar boton de inicio sesion {string}")
	public void apreta_el_boton(String boton) throws InterruptedException {
		driver.findElement(By.xpath(boton)).click();
	}
	
	@Then("esperar el inicio de sesion {string}")
	public void espera_la_sesion(String menu) throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(menu)));
	}
	
	
}
