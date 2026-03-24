package PageObject;

import factory.BrowserConfigFactory;
import factory.DriverConfig;
import factory.WebelementConfig;
import org.openqa.selenium.WebDriver;
import service.LocatorHelper;
import service.WebElementOperations;

public class HomePage extends WebElementOperations{
     WebDriver driver;

     public HomePage(){
         driver= DriverConfig.driver;
     }

    public PracticePage goToPracticepage(){

        clickOnElement(LocatorHelper.findElementbyXpath(driver,WebelementConfig.xpaths.get("PRACTICE_PAGE_LINK")));
        return new PracticePage();


    }


}
