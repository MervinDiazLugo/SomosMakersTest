package Functions;

import StepDefinitions.Hooks;
import cucumber.api.DataTable;
import cucumber.api.Scenario;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class CustomFunctions {
    static WebDriver driver;
    static DataTable data;
    public static Properties prop = new Properties();
    public static InputStream in = CustomFunctions.class.getResourceAsStream("../test.properties");
    public static Map<String, String> ScenaryData = new HashMap<>();
    public static Map<String, String> HandleMyWindows = new HashMap<>();

    public CustomFunctions(){
        driver = Hooks.driver;

    }

    public static String Environment = "";

    public String ElementText = "";

    public static final int EXPLICIT_TIMEOUT = 5;
    public static boolean isDisplayed = Boolean.parseBoolean(null);

    /******** Scenario Attributes ********/
    Scenario scenario = null;
    public void scenario (Scenario scenario) {
        this.scenario = scenario;
    }

    public String readProperties(String property) throws IOException {
        prop.load(in);
        return prop.getProperty(property);
    }

    /******** Log Attribute ********/
    private static Logger log = Logger.getLogger(CustomFunctions.class);

    /******** Page Path ********/
    public static String FileName = "";
    public static String PagesFilePath = "src/test/resources/Pages/";

    public static String GetFieldBy = "";
    public static String ValueToFind = "";

    public void calculateTotals(){
        data = SeleniumFunctions.data;
        AtomicInteger k = new AtomicInteger();
        if (data != null){
            data.raw().forEach(value ->{
                List<String> rDate = Collections.singletonList(value.get(0));
                List<String> rPortfolio = Collections.singletonList(value.get(1));
                List<String> rNominal = Collections.singletonList(value.get(2));
                List<String> rPrice = Collections.singletonList(value.get(3));
                List<String> rTotal = Collections.singletonList(value.get(4));
                String date = rDate.get(0);
                String portfolio = rPortfolio.get(0);
                String nominal = rNominal.get(0);
                String price = rPrice.get(0);
                String total = rTotal.get(0);
                k.set(k.get() + 1);
                Double result = null;
                final double subtotal = Double.parseDouble(nominal) * Double.parseDouble(price);
                if (portfolio == "OBL-RIESGO"){
                    result = subtotal +2000;
                    Assert.assertTrue("El resultado no coincide, se esperaba" + total + " pero el resultado es: " + result.toString(), result == Double.parseDouble(total));
                }else{
                    result = subtotal;
                    Assert.assertEquals("El resultado no coincide, se esperaba" + total + " pero el resultado es: " + result.toString(), result, Double.parseDouble(total), 0.0);
                }

            });
        }

    }

}