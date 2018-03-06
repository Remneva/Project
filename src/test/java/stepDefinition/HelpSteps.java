package stepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;

public class HelpSteps {

    WebDriver driver = InitialsSteps.getDriver();

    public void enterData(String placeholder, String data) throws Throwable {
        WebElement element = driver.findElement
                (By.xpath(("//input[@placeholder='" + placeholder + "']")));
        element.clear();
        element.sendKeys(data);
    }

    public void pushButton(String button) {
        WebElement element = driver.findElement(By.xpath("//self::node()[text()='" + button + "']"));
        isElementPresent(element, 30);
        element.click();
    }

    public boolean isElementPresent(WebElement elementName, int timeout) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeout);
            Thread.sleep(1000);
            wait.until(ExpectedConditions.visibilityOf(elementName));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void checkElement(String element) {
        WebElement el = driver.findElement(By.xpath("//self::node()[text()='" + element + "']"));
        isElementPresent(el, 30);
        el.isDisplayed();
        assertEquals(el.getText(), element);

    }
    public void checkLogo(String logo) {
        WebElement el = driver.findElement(By.xpath("//img[@title='" + logo + "']"));
        isElementPresent(el, 30);
        el.isDisplayed();
    }
}