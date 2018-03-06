package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

/**
 * Created by user on 06.03.2018.
 */
public class BriefAssetCard extends Base {

    public BriefAssetCard(WebDriver driver) {
        super(driver);
    }

    public String getTitle() {
        return "briefAssetCard";
    }

    @FindBy(how = How.XPATH,
            using = "//ol[@class=\"breadcrumb\"]/li[2]")
    public WebElement createActivLogo;

    @FindBy(how = How.XPATH,
            using = "//select[@name='assetFunctionalType']/option")
    private List<WebElement> dropDownType;

    @FindBy(how = How.XPATH,
            using = "//button[@ng-click=\"next();\"]")
    public WebElement furButton;


    public void checkElementPage(String el) {
        checkElement1(createActivLogo, el);
    }

    public void chooseOptionType(String el) {
        clickOnItems(dropDownType, el);
    }

    public void pushButton(String el) {
        pushButton(furButton, el);
    }
}
