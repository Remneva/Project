package stepDefinition;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.ru.Дано;
import cucumber.api.java.ru.Тогда;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.Base;


public class InitialsSteps {
    static WebDriver driver;
    // public static LoginForm loginForm;
    //  public static ModalWindowChooseOrganization modalWindowChooseOrganization;
    public static Base page;

    public static WebDriver getDriver() {
        if (driver == null) {
            System.setProperty("webdriver.chrome.driver", "C:\\Space\\Project\\chromedriver.exe");
            ChromeOptions options = new ChromeOptions();
            options.addArguments("-incognito");
            options.addArguments("start-maximized");
            options.addArguments("dom.webnotifocations.enable");
            driver = new ChromeDriver(options);
            // loginForm = new LoginForm(driver);
            // modalWindowChooseOrganization = new ModalWindowChooseOrganization(driver);
            page = new Base(driver);
        }
        return driver;
    }

    @Before
    public void openBrowser() throws Throwable {
        driver = getDriver();
        driver.get("http://172.26.25.86:8081/sua/");
    }

  //  @After
    public void closeBrowser() throws Throwable {
        driver.quit();
        driver = null;
    }
}
