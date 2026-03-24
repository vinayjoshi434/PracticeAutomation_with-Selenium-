package PageObject;

import factory.BrowserConfigFactory;
import factory.DriverConfig;
import factory.WebelementConfig;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import service.FactoryLoader;
import service.LocatorHelper;
import service.WebElementOperations;
import util.Capture;

public class LoginPage extends WebElementOperations {

      WebDriver driver;


      public LoginPage(){
            this.driver= DriverConfig.driver;

      }


      public void executeLogin(){
            driver.get(BrowserConfigFactory.browserConfig.get("loginURL"));
            WebElement username=LocatorHelper.findElementbyXpath(driver, WebelementConfig.xpaths.get("LOGIN_USERNAME"));
            WebElement password=LocatorHelper.findElementbyXpath(driver, WebelementConfig.xpaths.get("LOGIN_PASSWORD"));
            WebElement button= LocatorHelper.findElementbyXpath(driver, WebelementConfig.xpaths.get("LOGIN_BTN"));
            setdata(username,"student" );
            setdata(password, "Password123");
            Actions actions=new Actions(driver);
           actions.moveToElement(button).perform();
            clickOnElement(button);
            Capture.savescreenshot(driver, "executeLogin");


      }

      public void testIncorrectUsername(){
            driver.get(BrowserConfigFactory.browserConfig.get("siteURL"));
            WebElement username=LocatorHelper.findElementbyXpath(driver, WebelementConfig.xpaths.get("LOGIN_USERNAME"));
            WebElement password=LocatorHelper.findElementbyXpath(driver, WebelementConfig.xpaths.get("LOGIN_PASSWORD"));
            WebElement button= LocatorHelper.findElementbyXpath(driver, WebelementConfig.xpaths.get("LOGIN_BTN"));
            WebElement error_div= LocatorHelper.findElementbyXpath(driver, WebelementConfig.xpaths.get("ERROR_DIV"));
            setdata(username,"student2323" );
            setdata(password, "Password123");
            Actions actions=new Actions(driver);
            actions.moveToElement(button).perform();
            clickOnElement(button);
            if(error_div.getText().equals("Your username is invalid!")){
                  System.out.println("Test Pass : ");
            }
            else{
                  System.out.println("test failed :");
            }

      }



}
