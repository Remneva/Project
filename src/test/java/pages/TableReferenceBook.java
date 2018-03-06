package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

/**
 * Created by user on 05.03.2018.
 */
public class TableReferenceBook extends Base {

    public TableReferenceBook(WebDriver driver) {
        super(driver);
    }

    public String getTitle() {
        return "dictionaryList";
    }

    @FindBy(how = How.XPATH,
            using = "//ol[@class=\"breadcrumb\"]/li")
    private WebElement tabletitle;

    @FindBy(how = How.XPATH,
            using = "//td[@role='gridcell']/a[text()='План счетов  по КО']")
    private WebElement reference;

    @FindBy(how = How.XPATH,
    using = "//td[@aria-describedby='accountplancogrid_parentBalanceAccountNum']")
    private List<WebElement> account1;

    public void checkElementPage(String el) {
        checkElement(tabletitle, el);
    }

    public void chooseOption(String el) {
        pushButton(reference, el);
    }

    public void checkAccount(String el) {
        checkPresenseOfElements(account1, el);
    }

}
