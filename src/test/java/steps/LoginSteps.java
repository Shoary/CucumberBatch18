package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.xml.DOMConfigurator;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;
import utils.CommonMethods;
import utils.ConfigReader;
import utils.Log;

public class LoginSteps extends CommonMethods {
    //we don't need this driver, since it is coming from common methods class
    // public WebDriver driver;

    @Given("user is navigated to HRMS application")
    public void user_is_navigated_to_hrms_application(){
        openBrowserAndLaunchApplication();
        // driver = new ChromeDriver();
        //driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @When("user enters admin username and password")
    public void user_enters_admin_username_and_password() {
        //   LoginPage login = new LoginPage();
        // driver.findElement(By.id("txtUsername")).sendKeys("admin");
        //   WebElement usernameField = driver.findElement(By.id("txtUsername"));
        //  WebElement passwordField = driver.findElement(By.id("txtPassword"));
        //dom configurator - it is a class which allows us to add log4j.xml in our code
        DOMConfigurator.configure("log4j.xml");
        Log.startTestCase("My login test case");
        Log.info("My test case is executing");
        Log.info("I am testing log4j functionality");
        sendText(ConfigReader.read("userName"),login.usernameField);
        sendText(ConfigReader.read("password"),login.passwordField);
        Log.endTestCase("Finish");
        //login.enterUserName();
        //login.enterPassword();
        //driver.findElement(By.id("txtPassword")).sendKeys("Hum@nhrm123");
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @When("user clicks on login button")
    public void user_clicks_on_login_button() {
        // LoginPage login = new LoginPage();
        //  WebElement loginButton =  driver.findElement(By.id("btnLogin"));
        click(login.loginButton);
        //driver.findElement(By.id("btnLogin")).click();
    }

    @Then("user is successfully logged in")
    public void user_is_successfully_logged_in() {
        //  WebElement welcomeMessage = driver.findElement(By.id("welcome"));
        //  System.out.println(10/0);
        Assert.assertTrue(dashboardPage.welcomeMessageOption.isDisplayed());
        System.out.println("My test is passed");
    }

    @When("user enters {string} and {string} and verify the {string}")
    public void user_enters_and_and_verify_the
            (String usernameValue, String passwordValue, String errorMessage) {
        //  WebElement usernameField = driver.findElement(By.id("txtUsername"));
        //WebElement passwordField = driver.findElement(By.id("txtPassword"));
        //WebElement loginButton =  driver.findElement(By.id("btnLogin"));
        //  LoginPage login = new LoginPage();
        sendText(usernameValue, login.usernameField);
        sendText(passwordValue, login.passwordField);
        click(login.loginButton);
        //to get the error message, we need this web element
        //  WebElement errorLoc = driver.findElement(By.id("spanMessage"));
        String errorMessageValue = login.errorMessageLoc.getText();
        // System.out.println(errorMessageValue);
        Assert.assertEquals(errorMessage,errorMessageValue);
    }

}