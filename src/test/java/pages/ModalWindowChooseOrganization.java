package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

/**
 * Created by user on 04.03.2018.
 */
public class ModalWindowChooseOrganization extends Base {

    public String getTitle() {
        return "launchPage";
    }

    public ModalWindowChooseOrganization(WebDriver driver) {
        super(driver);
    }

    @FindBy(how = How.XPATH,
            using = "//td[@aria-describedby='organizationgrid_shortName']")
    public List<WebElement> orgName;

    @FindBy(how = How.XPATH,
            using = "//h4[@id='organizationModalLabel']")
    public WebElement windowOrgName;

    @FindBy(how = How.XPATH,
            using = "//self::node()[text()='Выбрать']")
    public WebElement findButton;

    public void pushButtonPage(String el) {
        pushButton(findButton, el);
    }

    public void checkElementPage(String el) {
        checkElement(windowOrgName, el);
    }

    public void chooseOrg(String el) {
        chooseEl(orgName, el);
    }
}
