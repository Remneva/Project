package stepDefinition;

import cucumber.api.DataTable;
import cucumber.api.java.ru.*;
import gherkin.lexer.He;
import gherkin.lexer.Tr;
import pages.*;

import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static stepDefinition.InitialsSteps.driver;
import static stepDefinition.InitialsSteps.page;
//import static stepDefinition.InitialsSteps.loginForm;
//import static stepDefinition.InitialsSteps.modalWindowChooseOrganization;


/**
 * Created by user on 03.03.2018.
 */
public class StepImplementation {

    /*   @Дано("^открывается модальное окно \"([^\"]*)\"$")
       public void openWindow(String window) throws Throwable {

           page.GetInstance(ModalWindowChooseOrganization.class).checkElementPage(window);
       }
   */
    @Дано("^открывается модальное окно \"([^\"]*)\"$")
    public void openPageForm(String window) throws Throwable {
        if (driver.getCurrentUrl().contains(page.GetInstance(ModalWindowChooseOrganization.class).getTitle())) {
            page.GetInstance(ModalWindowChooseOrganization.class).checkElementPage(window);
        } else if (driver.getCurrentUrl().contains(page.GetInstance(ModalWindowSearchTable.class).getTitle())) {
            page.GetInstance(ModalWindowSearchTable.class).checkElementPage(window);
        }
    }

    @Дано("^открывается страница с (формой|финансовой организацией) \"([^\"]*)\"$")
    public void openPages(String actions, String el) throws Throwable {
        if (driver.getCurrentUrl().contains(page.GetInstance(Header.class).getTitle())) {
            page.GetInstance(Header.class).checkElementPage(el);
        } else if
                (driver.getCurrentUrl().contains(page.GetInstance(LoginForm.class).getTitle())) {
            page.GetInstance(LoginForm.class).checkElementPage(el);
        } else if (driver.getCurrentUrl().contains(page.GetInstance(BriefAssetCard.class).getTitle())) {
            page.GetInstance(BriefAssetCard.class).checkElementPage(el);
        }
    }

    /*
    @Дано("^открывается страница с финансовой организацией \"([^\"]*)\"$")
    public void openPage1(String window) throws Throwable {
        modalWindowChooseOrganization.checkElementPage(window);
    }
    */


    @Когда("^пользователь заполняет поле \"([^\"]*)\" значением \"([^\"]*)\"$")
    public void userFillsField(String el, String value) throws Throwable {
        if (driver.getCurrentUrl().contains(page.GetInstance(LoginForm.class).getTitle())) {
            page.GetInstance(LoginForm.class).enterDataLoginPage(el, value);

        }
    }

    @Когда("^пользователь вводит в поле \"(Номер счета|Начальная балансовая стоимость|Наименование актива)\" значение \"([^\"]*)\"$")
    public void userAnyFills(String el, String value) throws Throwable {
        if (driver.getCurrentUrl().contains(page.GetInstance(FullAssetCard.class).getTitle())) {
            //   page.GetInstance(FullAssetCard.class).inputFieldsNum(value);
        }
        if (el.contains("Номер счета")) {
            page.GetInstance(FullAssetCard.class).inputFieldsNum(value);
            Thread.sleep(3000);
        } else if (el.contains("Начальная балансовая стоимость")) {
            Thread.sleep(3000);
            page.GetInstance(FullAssetCard.class).enterBalSum(value);
        } else if (el.contains("Наименование актива")) {
            Thread.sleep(3000);
            page.GetInstance(FullAssetCard.class).enterNameActive(value);
        }
    }

    @Когда("^пользователь вносит в поле \"(Дата начала действия актива|Дата окончания действия актива)\" значение \"([^\"]*)\"$")
    public void userSomthingFills(String el, String value) throws Throwable {
        if (driver.getCurrentUrl().contains(page.GetInstance(Accept.class).getTitle())) {
            //   page.GetInstance(FullAssetCard.class).inputFieldsNum(value);
        }
        if (el.contains("Дата начала действия актива")) {
            page.GetInstance(Accept.class).enterStartDate(value);
        } else if (el.contains("Дата окончания действия актива")) {
            page.GetInstance(Accept.class).enterEndDate(value);
        }
    }

    /*
    @Когда("^пользователь заполняет поле \"Начальная балансовая стоимость\" значением \"([^\"]*)\"$")
    public void enterBalance(String el) throws Throwable {
        page.GetInstance(FullAssetCard.class).enterBalSum(el);
    }

    @Когда("^пользователь заполняет поле \"Наименование актива\" значением \"([^\"]*)\"$")
    public void NameActive(String el) throws Throwable {
        page.GetInstance(FullAssetCard.class).enterNameActive(el);
    }

    @Когда("^пользователь заполняет поле \"Дата начала действия актива\" значением \"([^\"]*)\"$")
    public void activeStart(String el) throws Throwable {
        page.GetInstance(Accept.class).startDate(el);
    }
*/


    @И("^пользователь нажимает кнопку \"([^\"]*)\"$")
    public void clickOn(String el) throws Throwable {
        if (driver.getCurrentUrl().contains(page.GetInstance(LoginForm.class).getTitle())) {
            page.GetInstance(LoginForm.class).pushButtonPage(el);
        } else if (driver.getCurrentUrl().contains(page.GetInstance(ModalWindowChooseOrganization.class).getTitle())) {
            page.GetInstance(ModalWindowChooseOrganization.class).pushButtonPage(el);
        } else if (driver.getCurrentUrl().contains(page.GetInstance(Header.class).getTitle())) {
            page.GetInstance(Header.class).pushPreExitPage(el);
        } else if (driver.getCurrentUrl().contains(page.GetInstance(ModalWindowSearchTable.class).getTitle())) {
            page.GetInstance(ModalWindowSearchTable.class).pushButtonSearch();
        } else if (driver.getCurrentUrl().contains(page.GetInstance(BriefAssetCard.class).getTitle())) {
            page.GetInstance(BriefAssetCard.class).pushButton(el);
        } else if (driver.getCurrentUrl().contains(page.GetInstance(FullAssetCard.class).getTitle())) {
            page.GetInstance(FullAssetCard.class).pushButton(el);
        } else if (driver.getCurrentUrl().contains(page.GetInstance(Accept.class).getTitle())) {
            page.GetInstance(Accept.class).pushButton(el);
        }
    }

    @И("^пользователь кликает на кнопку \"([^\"]*)\"$")
    public void clickOnSave(String el) throws Throwable {
        if (driver.getCurrentUrl().contains(page.GetInstance(Accept.class).getTitle())) {
            page.GetInstance(Accept.class).pushButton(el);
        }
    }

    @И("^пользователь нажимает на кнопку \"([^\"]*)\"$")
    public void clickOnButton(String el) throws Throwable {
        page.GetInstance(ActiveList.class).pushCreateButton(el);
    }

    @Тогда("^открывается страница с (логотипом|сообщением) \"([^\"]*)\"$")
    public void openPageCheckLogo(String act, String value) throws Throwable {
        if (driver.getCurrentUrl().contains(page.GetInstance(Header.class).getTitle())) {
            page.GetInstance(Header.class).checkLogoName(value);
        } else if (driver.getCurrentUrl().contains(page.GetInstance(LoginForm.class).getTitle())) {
            page.GetInstance(LoginForm.class).checkElementMessagePage(value);
        }
    }

    @Когда("^пользователь заполняет поля \"([^\"]*)\" и \"([^\"]*)\" значением$")
    public void userFillsPlace(String username, String pass, DataTable data) throws Throwable {
        List<String> list = data.asList(String.class);
        page.GetInstance(LoginForm.class).enterDataLoginPage(username, list.get(0));
        page.GetInstance(LoginForm.class).enterDataLoginPage(pass, list.get(1));
    }

    @И("^пользователь выбирает финансовую организацию \"([^\"]*)\" типа КО$")
    public void clickOnElement(String el) throws Throwable {
        page.GetInstance(ModalWindowChooseOrganization.class).chooseOrg(el);
    }


    @И("^пользователь нажимает кнопку \"([^\"]*)\" в контекстном меню$")
    public void clickOnExit(String el) throws Throwable {
        page.GetInstance(Header.class).pushExitPage(el);
    }

    @Тогда("^пользователь нажимает кнопку с выпадающим списком \"([^\"]*)\"$")
    public void userChooseItemInDropDownNavigation(String el) throws Throwable {

        if (driver.getCurrentUrl().contains(page.GetInstance(Header.class).getTitle())) {
            page.GetInstance(Header.class).pushNavButtonPage(el);
        }

    }

    @Тогда("^пользователь выбирает пункт \"([^\"]*)\"$")
    public void clickOnElementDropDown(String el) throws Throwable {
        if (driver.getCurrentUrl().contains(page.GetInstance(Header.class).getTitle())) {
            page.GetInstance(Header.class).chooseOptions(el);
        } else if (driver.getCurrentUrl().contains(page.GetInstance(BriefAssetCard.class).getTitle())) {

            page.GetInstance(BriefAssetCard.class).chooseOptionType(el);
        }
    }


    @Тогда("^открывается экранная форма \"([^\"]*)\"$")
    public void openForm(String el) throws Throwable {
        if (driver.getCurrentUrl().contains(page.GetInstance(TableReferenceBook.class).getTitle())) {
            page.GetInstance(TableReferenceBook.class).checkElementPage(el);
        } else if (driver.getCurrentUrl().contains(page.GetInstance(AccountPlanCO.class).getTitle())) {
            page.GetInstance(AccountPlanCO.class).checkElementPage(el);
        } else if (driver.getCurrentUrl().contains(page.GetInstance(FullAssetCard.class).getTitle())) {
            page.GetInstance(FullAssetCard.class).checkElementPage(el);
        } else if (driver.getCurrentUrl().contains(page.GetInstance(ActiveList.class).getTitle())) {
            page.GetInstance(ActiveList.class).checkElementPage(el);
        }
    }

    @Тогда("^открывается форма \"([^\"]*)\"$")
    public void openAnyForm(String el) throws Throwable {
        if (driver.getCurrentUrl().contains(page.GetInstance(Accept.class).getTitle())) {
            page.GetInstance(Accept.class).checkElementPage(el);
        }
    }

    @Тогда("^пользователь нажимает ссылку \"([^\"]*)\" в таблице \"Краткое наименование\"$")
    public void chooseReference(String el) throws Throwable {
        page.GetInstance(TableReferenceBook.class).chooseOption(el);
    }

    @Тогда("^пользователь нажимает кнопку \"Поиск\" в верхней панели таблицы$")
    public void userPushLupa() throws Throwable {
        page.GetInstance(AccountPlanCO.class).pushButtonPage();
    }

    @Тогда("^пользователь выбирает пункт \"([^\"]*)\" в выпадающем списке \"ID Плана Счетов\"$")
    public void chooseOption1(String el) throws Throwable {
        page.GetInstance(ModalWindowSearchTable.class).chooseOption1(el);
    }

    @Тогда("^пользователь выбирает пункт \"([^\"]*)\" в выпадающем списке \"Содержит\"$")
    public void chooseOption2(String el) throws Throwable {
        page.GetInstance(ModalWindowSearchTable.class).chooseOption2(el);
    }

    @Тогда("^пользователь заполняет поле значением \"([^\"]*)\"$")
    public void userFills(String el) throws Throwable {
        page.GetInstance(ModalWindowSearchTable.class).InputValue(el);
    }

    @Тогда("^отображается \"Номер счёта 2-го порядка\" содержащий \"([^\"]*)\"$")
    public void checkPresens(String el) throws Throwable {
        page.GetInstance(TableReferenceBook.class).checkAccount(el);
    }

    @Тогда("^элементы навигации прсутствуют на странице$")
    public void checkElements(DataTable table) throws Throwable {
        List<String> navigationItems = table.asList(String.class);
        assertEquals(navigationItems, page.GetInstance(FullAssetCard.class).getnavElements());

    }
}
/*
    @Тогда("^отображается \"Наименование\" содержащий \"пыщ"$")
    public void checkPresensActive(String el) throws Throwable {
        page.GetInstance(TableReferenceBook.class).checkAccount(el);
    }
}
*/

