package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import stepDefinition.InitialsSteps;

import java.util.List;

import static org.junit.Assert.assertTrue;

/**
 * Created by user on 04.03.2018.
 */
public class Base {

    WebDriver driver = InitialsSteps.getDriver();
    String name;

    public String getTitle() {
        return name;
    }

    public Base(WebDriver driver) {
        PageFactory.initElements(driver, this);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 30), this);
    }

    public <TPage extends Base> TPage GetInstance(Class<TPage> pageClass) {
        try {
            return PageFactory.initElements(driver, pageClass);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public boolean isElementsPresent(List<WebElement> elementName, int timeout) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeout);
            Thread.sleep(1000);
            wait.until(ExpectedConditions.visibilityOfAllElements(elementName));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void checkElementTitle(WebElement element, String el) {
        assertTrue(element.getAttribute("title").equals(el));
    }

    public void checkElement(WebElement element, String el) {
        isElementPresent(element, 30);
        assertTrue(element.getText().equalsIgnoreCase(el));
    }
    public void checkElement1(WebElement element, String el) {
        isElementPresent(element, 30);
        assertTrue(element.getText().contains(el));
    }


    public void enterDataLoginForm(List<WebElement> elements, String el, String value) {
        for (WebElement item : elements) {
            if (item.getAttribute("placeholder").equals(el)) {
                item.sendKeys(value);
            }
        }
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

    public void pushButton(WebElement element, String el) {
        isElementPresent(element, 20);
        if (element.getText().equalsIgnoreCase(el)) {
            element.click();
        }
    }

    public void chooseEl(List<WebElement> elements, String el) {
        isElementsPresent(elements, 40);
        for (WebElement item : elements) {
            if (item.getText().equals(el)) {
                item.click();
                break;
            }
        }
    }

    public void clickOnItems(List<WebElement> elements, String el) {
        isElementsPresent(elements, 40);
        for (WebElement item : elements) {
            if (item.getText().contains(el)) {
                isElementPresent(item, 40);
                item.click();
                break;
            }
        }
    }
    public void clickOnItemslabel(List<WebElement> elements, String el) {
        isElementsPresent(elements, 40);
        for (WebElement item : elements) {
            if (item.getAttribute("label").contains(el)){
                isElementPresent(item, 40);
                item.click();
                break;
            }
        }
    }


    public void pushEl(WebElement element) {
        isElementPresent(element, 30);
        element.click();
    }

    public void clickItemsStartWith(List<WebElement> elements, String el) {

        for (WebElement item : elements) {
            if (item.getText().startsWith(el)) {
                isElementPresent(item, 40);
                item.click();
                break;
            }
        }
    }

    public void inputValue(WebElement element, String value) {
        isElementPresent(element, 40);
        element.click();
        element.clear();
        element.sendKeys(value);
        element.sendKeys(Keys.TAB);


    }

    public void pushButton(WebElement element) {
        isElementPresent(element, 20);
        element.click();
    }

    public void checkPresenseOfElements(List<WebElement> elements, String el) {
        isElementsPresent(elements, 20);
        for (WebElement item : elements) {
            if (item.getText().startsWith(el)) {
                if (elements.size() >= 1) ;
            }
        }
    }
}


