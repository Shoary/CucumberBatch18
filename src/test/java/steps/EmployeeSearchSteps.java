package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.CommonMethods;



public class EmployeeSearchSteps extends CommonMethods {

    //public WebDriver driver;

    @When("user clicks on PIM option")
    public void user_clicks_on_pim_option() {
        //  driver.findElement(By.id("menu_pim_viewPimModule")).click();
        // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //  WebElement pimOption =  driver.findElement(By.id("menu_pim_viewPimModule"));
        click(dashboardPage.pimOption);
    }

    @When("user clicks on employee list option")
    public void user_clicks_on_employee_list_option() {
        //  driver.findElement(By.id("menu_pim_viewEmployeeList")).click();
        // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //   WebElement empListOption = driver.findElement(By.id("menu_pim_viewEmployeeList"));
        click(dashboardPage.empListOption);
    }

    @When("user enters valid employee id")
    public void user_enters_valid_employee_id() {
        //   WebElement empIdLoc = driver.findElement(By.id("empsearch_id"));
        sendText("95757A", employeeSearchPage.empIdLoc);
        //   driver.findElement(By.id("empsearch_id")).sendKeys("95757A");
        //  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @When("user clicks on search button")
    public void user_clicks_on_search_button() {
        // WebElement searchOption = driver.findElement(By.id("searchBtn"));
        click(employeeSearchPage.searchOption);
        // driver.findElement(By.id("searchBtn")).click();
    }

    @Then("user should be able to see employee details")
    public void user_should_be_able_to_see_employee_details() {
        System.out.println("Employee can be seen clearly");
        //  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @When("user enters valid employee name")
    public void user_enters_valid_employee_name() {
        //    driver.findElement(By.id("empsearch_employee_name_empName")).sendKeys("abel");
        //WebElement empNameLoc = driver.findElement(By.id("empsearch_employee_name_empName"));
        sendText("abel", employeeSearchPage.empNameLoc);
    }



    }