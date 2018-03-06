package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * Created by user on 06.03.2018.
 */
public class Accept extends Base {

    public Accept(WebDriver driver) {
        super(driver);
    }

    public String getTitle() {
        return "fullAssetCard";
    }

    @FindBy(how = How.XPATH,
            using = "//self::node()[text()='Приём']")
    public WebElement accept;

    @FindBy(how = How.XPATH,
            using = "//input[@name=\"startDate\"]")
    public WebElement start;

    @FindBy(how = How.XPATH,
            using = "//input[@name=\"endDate\"]")
    public WebElement end;

    @FindBy(how = How.XPATH,
            using = "(//self::node()[text()='Сохранить'])[2]")
    public WebElement save;


    public void checkElementPage(String el) {

        checkElement(accept, el);
    }

    public void enterStartDate(String el) {
        inputValue(start, el);
    }

    public void enterEndDate(String el) {
        inputValue(end, el);

    }

    public void pushButton(String el) {
        pushButton(save, el);
    }

    // public void startDate(String el) {
    //      inputValue(nameActive, el);
    //  }


}
