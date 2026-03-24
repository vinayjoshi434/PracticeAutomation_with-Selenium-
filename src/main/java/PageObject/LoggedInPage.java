package PageObject;

import factory.DriverConfig;
import factory.WebelementConfig;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import service.LocatorHelper;
import service.WebElementOperations;

public class LoggedInPage extends LoginPage {
    WebDriver driver;

    public LoggedInPage(){
        driver= DriverConfig.driver;
    }

    public String getHeaderText(){
        WebElement header=LocatorHelper.findElementbyXpath(driver,WebelementConfig.xpaths.get("LoggedInHeaderText"));
        return header.getText();
    }

    public PracticePage logout(){
        System.out.println("driver value :"+driver);
        executeLogin();
        WebElement logoutbtn=LocatorHelper.findElementbyXpath(driver, WebelementConfig.xpaths.get("LogoutBtn"));
        WebElementOperations.clickOnElement(logoutbtn);
        return new PracticePage();
    }



}
