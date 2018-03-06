package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

/**
 * Created by user on 05.03.2018.
 */
public class ModalWindowSearchTable extends Base {

    public ModalWindowSearchTable(WebDriver driver) {
        super(driver);
    }

    public String getTitle() {
        return "accountPlanCo";
    }

    @FindBy(how = How.XPATH,
            using = "//div[contains(@id, 'searchhdfbox')]/span[@class='ui-jqdialog-title']")
    private WebElement searchModal;

    @FindBy(how = How.XPATH,
            using = "//td[@class='columns']/select/option")
    private List<WebElement> dropDown1;

    @FindBy(how = How.XPATH,
            using = "//td[@class='operators']/select/option")
    private List<WebElement> dropDown2;

    @FindBy(how = How.XPATH,
            using = "//td/input[@role='textbox'][@class='input-elm']")
    private WebElement fieldInput;

    @FindBy(how = How.XPATH,
            using = "//span[text()='Найти']")
    private WebElement buttonSearch;

    public void checkElementPage(String el) {
        checkElement(searchModal, el);
    }

    public void chooseOption1(String el) {
        clickItemsStartWith(dropDown1, el);
    }

    public void chooseOption2(String el) {
        clickItemsStartWith(dropDown2, el);
    }

    public void InputValue(String el) {
        inputValue(fieldInput, el);
    }

    public void pushButtonSearch() {
        pushButton(buttonSearch);
    }
}
