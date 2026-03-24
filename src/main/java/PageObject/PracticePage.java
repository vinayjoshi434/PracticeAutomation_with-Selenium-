package PageObject;

import factory.DriverConfig;
import factory.WebelementConfig;
import org.openqa.selenium.WebDriver;
import service.LocatorHelper;
import service.WebElementOperations;

public class PracticePage extends WebElementOperations {
    WebDriver driver;


    public PracticePage(){
        this.driver= DriverConfig.driver;
    }

    public LoginPage goToLoginPage(){
        clickOnElement(LocatorHelper.findElementbyXpath(driver,WebelementConfig.xpaths.
                get("LOGIN_PAGE_LINK")));
        return new LoginPage();
    }

    public TablePage goToTablepage(){
        clickOnElement(LocatorHelper.findElementbyXpath(driver, WebelementConfig.xpaths
        .get("TABLE_PAGE_LINK")));
        return new TablePage();
    }







}
