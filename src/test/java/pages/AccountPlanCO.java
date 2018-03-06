package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * Created by user on 05.03.2018.
 */
public class AccountPlanCO extends Base {

    public AccountPlanCO(WebDriver driver) {
        super(driver);
    }

    public String getTitle() {
        return "accountPlanCO";
    }

    @FindBy(how = How.XPATH,
            using = "//ol[@class='breadcrumb']/li[2]")
    private WebElement tabletitle;

    @FindBy(how = How.XPATH,
            using = "(//div[@class='ui-pg-div']/span)[1]")
    private WebElement buttonLupa;

    public void checkElementPage(String el) {
        checkElement(tabletitle, el);
    }

    public void pushButtonPage() {
        pushEl(buttonLupa);
    }


}
