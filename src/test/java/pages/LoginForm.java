package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.How;

import java.util.List;

public class LoginForm extends Base {

    public String getTitle() {
        return "login";
    }

    public LoginForm(WebDriver driver) {
        super(driver);
    }

    @FindBy(how = How.XPATH,
            using = "//h3[text()='Вход в систему']")
    public WebElement fromTitle;

    @FindBy(how = How.XPATH,
            using = "//input[@class='form-control']")
    public List<WebElement> fieldsLoginForm;

    @FindBy(how = How.XPATH,
            using = "//form[@class='form-signin']/button")
    public WebElement enterButton;

    @FindBy(how = How.XPATH,
            using = "//form/div")
    public WebElement invalidMessage;

    public void checkElementPage(String el) {
        checkElement(fromTitle, el);
    }

    public void enterDataLoginPage(String el, String value) {
        enterDataLoginForm(fieldsLoginForm, el, value);
    }

    public void enterDataLoginForm(List<WebElement> elements, String el, String value) {
        for (WebElement item: elements) {
            if (item.getAttribute("placeholder").equals(el)) {
                item.sendKeys(value);
            }
        }
    }

    public void pushButtonPage(String el) {
        pushButton(enterButton, el);
    }

    public void checkElementMessagePage(String el){
        checkElement(invalidMessage, el);
    }
}
