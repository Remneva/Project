package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

/**
 * Created by user on 06.03.2018.
 */
public class ActiveList extends Base {

    public ActiveList(WebDriver driver) {
        super(driver);
    }

    public String getTitle() {
        return "assetsList";
    }

    @FindBy(how = How.XPATH,
            using = "//self::node()[text()='Создать']")
    public WebElement crButton;

    @FindBy(how = How.XPATH,
            using = "(//self::node()[text()='Список активов'])[2]")
    public WebElement activeList;

    public void pushCreateButton(String el) {
        pushButton(crButton, el);
    }

    public void checkElementPage(String el) {
        checkElement(activeList, el);
    }
}

