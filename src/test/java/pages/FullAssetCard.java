package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.Arrays.stream;

/**
 * Created by user on 06.03.2018.
 */
public class FullAssetCard extends Base {

    public FullAssetCard(WebDriver driver) {
        super(driver);
    }

    public String getTitle() {
        return "fullAssetCard";
    }

    @FindBy(how = How.XPATH,
            using = "//self::node()[text()='Создание актива (второй этап)']")
    public WebElement createActivLogo;

    @FindBy(how = How.XPATH,
            using = "//input[@name=\"accountNum\"]")
    public WebElement fieldsNum;

    @FindBy(how = How.XPATH,
            using = "//input[@name=\"balanceInitial\"]")
    public WebElement fieldBalSum;

    @FindBy(how = How.XPATH,
            using = "//input[@name=\"name\"]")
    public WebElement nameActive;

    @FindBy(how = How.XPATH,
            using = "//self::node()[text()='Приём']")
    public WebElement receiving;

    @FindBy(how = How.XPATH,
            using = "//input[@name=\"balanceInitialCur\"]")
    public WebElement fieldRub;

    @FindBy(how = How.XPATH,
            using = "//ul[@class=\"nav nav-tabs full\"]/li/a")
    private List<WebElement> navElements;

    public void checkElementPage(String el) {
        checkElement(createActivLogo, el);
    }

    public void inputFieldsNum(String el) {
        inputValue(fieldsNum, el);
    }

    public void enterBalSum(String el) {
        inputValue(fieldBalSum, el);
    }

    public void enterNameActive(String el) {

        inputValue(nameActive, el);
    }

    public void pushButton(String el) {
        pushButton(receiving, el);
    }

    public List<String> getnavElements() {
        return navElements
                .stream().limit(13)
                .map(WebElement::getText)
               .collect(Collectors.toList());
    }
}
