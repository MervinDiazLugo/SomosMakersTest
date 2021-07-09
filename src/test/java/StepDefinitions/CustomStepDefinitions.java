package StepDefinitions;

import Functions.CustomFunctions;
import Functions.SeleniumFunctions;
import cucumber.api.Scenario;
import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class CustomStepDefinitions {
    WebDriver driver;
    SeleniumFunctions functions = new SeleniumFunctions();
    CustomFunctions customFunctions = new CustomFunctions();
    /******** Log Attribute ********/
    Logger log = Logger.getLogger(CustomStepDefinitions.class);



    public CustomStepDefinitions() {
        driver = Hooks.driver;
    }

    /******** Scenario Attributes ********/
    Scenario scenario = null;
    public void scenario (Scenario scenario) {
        this.scenario = scenario;
    }


    @When("Calculate totals")
    public void calculateTotals() {
        customFunctions.calculateTotals();
    }


    @And("I fill the form")
    public void iFillTheForm() throws Exception {
        functions.iSetElementWithText("NAME", "Mervin");
        functions.iSetElementWithText("LASTNAME", "Diaz");
        functions.iSetElementWithText("EMAIL", "mervindiazlugo@gmail.com");
        functions.iSetElementWithKeyValue("PHONE_NUMBER", "Tel_Servicio_Cliente.text");
        functions.iSetElementWithText("MESSAGE", "TEST AUTOMATION 01");
    }


}
