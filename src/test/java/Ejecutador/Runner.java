package Ejecutador;

import org.junit.runner.RunWith;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features={".src/test/resources/Feature/EscenarioTransferencia.feature"}, glue={".src/test/java/DefinicionPasos/"})

public class Runner {

}
