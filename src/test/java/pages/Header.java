package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

/**
 * Created by user on 05.03.2018.
 */
public class Header extends Base {

    public Header(WebDriver driver) {
        super(driver);
    }

    public String getTitle() {
        return "assetsList";
    }

    @FindBy(how = How.XPATH,
            using = "//img[@class='logo']")
    private WebElement labelLogo;

    @FindBy(how = How.XPATH,
            using = "//self::node()[text()='10']")
    public WebElement orgName;

    @FindBy(how = How.XPATH,
            using = "//self::node()[text()='Права  Все']")
    public WebElement preExit;

    @FindBy(how = How.XPATH,
            using = "//self::node()[text()='Выход']")
    public WebElement Exit;

    @FindBy(how = How.XPATH,
            using = "//li[contains(@class, 'dropdown')]/a")
    public List<WebElement> navButton;

    @FindBy(how = How.XPATH,
            using = "//a[contains(@sua-access, '.list')]")
    public List<WebElement> directory;

    @FindBy(how = How.XPATH,
            using = "(//li[contains(@class, 'dropdown')]/a)[1]")
    public List<WebElement> collectionData;

    @FindBy(how = How.XPATH,
            using = "//self::node()[text()='Список активов']")
    public List<WebElement> activeList;


    public void checkLogoName(String el) {
        checkElementTitle(labelLogo, el);
    }

    public void checkElementPage(String el) {
        checkElement(orgName, el);
    }

    public void pushPreExitPage(String el) {
        pushButton(preExit, el);
    }

    public void pushExitPage(String el) {
        pushButton(Exit, el);
    }

    public void pushNavButtonPage(String el) {
        clickOnItems(navButton, el);
    }

    public void chooseOptions(String el) {
        clickOnItems(directory, el);
    }

    public void chooseActiveList(String el) {
        clickOnItems(activeList, el);
    }

    public void pushCollectionData(String el) {
        clickOnItems(collectionData, el);
    }

}


