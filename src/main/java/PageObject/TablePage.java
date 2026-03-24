package PageObject;

import factory.DriverConfig;
import factory.WebelementConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.SourceType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import service.LocatorHelper;
import service.WebElementOperations;

import java.util.List;

public class TablePage extends WebElementOperations {

    WebDriver driver;
 WebDriverWait wait;

    public TablePage(){

        driver= DriverConfig.driver;
        wait=DriverConfig.wait;
        driver.get("https://practicetestautomation.com/practice-test-table/");
    }


    public void filtertableByLanguage(){
        Actions actions=new Actions(driver);
        List<WebElement> rows;
        WebElement radiobtn= LocatorHelper.findElementbyXpath(driver,WebelementConfig.xpaths.get("JAVA_LANGUAGE_RADIO"));
        actions.moveToElement(radiobtn).build().perform();
        WebElementOperations.clickOnElement(radiobtn);
        rows= LocatorHelper.findElementList(driver, WebelementConfig.xpaths.get("TABLE_ROW"));
        boolean isTestPass=true;
        for(WebElement element : rows){
            actions.moveToElement(element).build().perform();
           if(!element.getText().equalsIgnoreCase("Java")){
               isTestPass = false;
           }
        }
        if (isTestPass){
            System.out.println("Test Case Passed !");
        }
    }

    public void filterByLevel(){

        Actions actions=new Actions(driver);
        List<WebElement> rows;

        WebElement BegineerRadio=LocatorHelper.findElementbyXpath(driver, WebelementConfig.xpaths.get("BEGINNER_RADIO"));
        WebElement IntermediateRadio=LocatorHelper.findElementbyXpath(driver, WebelementConfig.xpaths.get("INTERMEDIATE_RADIO"));
        WebElement AdvancedRadio=LocatorHelper.findElementbyXpath(driver, WebelementConfig.xpaths.get("ADVANCED_RADIO"));

        actions.moveToElement(IntermediateRadio).build().perform();
        WebElementOperations.clickOnElement(IntermediateRadio);
        WebElementOperations.clickOnElement(AdvancedRadio);

        rows=LocatorHelper.findElementList(driver, WebelementConfig.xpaths.get("TABLE_LEVEL_COLUMN"));


        boolean isTestPass=true;
        for(WebElement element: rows) {
            actions.moveToElement(element).build().perform();
            if (!element.getText().equals("Beginner")) {
                isTestPass = false;
            }
        }
        if(isTestPass) {
            System.out.println("Test Case Pass !");
        }
    }


    public void filterByDropdown(){
        System.out.println("filter dropdown hit");
        Actions actions=new Actions(driver);
        List<WebElement> rows;

           WebElement dropdownInput=LocatorHelper.findElementbyXpath(driver,WebelementConfig.xpaths.get("DROPDOWN_SELECT"));
           WebElement selectOption=LocatorHelper.findElementbyXpath(driver,WebelementConfig.xpaths.get("DROPDOWN_OPTION_10000"));
           actions.scrollToElement(dropdownInput).build().perform();
           WebElementOperations.clickOnElement(dropdownInput);
           WebElementOperations.clickOnElement(selectOption);

           rows=LocatorHelper.findElementList(driver, WebelementConfig.xpaths.get("TABLE_ENROLLMENTS_COLUMN"));

           boolean isTestPass=true;
           for(WebElement element: rows){
               actions.scrollToElement(element).build().perform();
               if(!(Integer.parseInt(element.getText())>5000)){
                   isTestPass=false;

               }

           }
           if(isTestPass){
               System.out.println("Test cases Pass !");
           }





    }

    public void combinedFilter(){

        WebElement languageRadio=LocatorHelper.findElementbyXpath(driver, WebelementConfig.xpaths.get("JAVA_LANGUAGE_RADIO"));
        WebElement IntermediateRadio=LocatorHelper.findElementbyXpath(driver, WebelementConfig.xpaths.get("INTERMEDIATE_RADIO"));
        WebElement AdvancedRadio=LocatorHelper.findElementbyXpath(driver, WebelementConfig.xpaths.get("ADVANCED_RADIO"));
        WebElement dropdownoption5000=LocatorHelper.findElementbyXpath(driver,WebelementConfig.xpaths.get("DROPDOWN_OPTION_5000"));
        WebElement dropdownInput=LocatorHelper.findElementbyXpath(driver, WebelementConfig.xpaths.get("DROPDOWN_SELECT"));
        List<WebElement> rows;
        Actions actions=new Actions(driver);
        actions.scrollToElement(languageRadio);
        clickOnElement(languageRadio);
        clickOnElement(IntermediateRadio);
        clickOnElement(AdvancedRadio);
        clickOnElement(dropdownInput);
        clickOnElement(dropdownoption5000);

        rows=LocatorHelper.findElementList(driver, WebelementConfig.xpaths.get("COMBINE_FILTER_ROWS"));

          for(WebElement row:rows){
                 String language=row.findElement(By.xpath("./td[3]")).getText().trim();
                 String level=row.findElement(By.xpath("./td[4]")).getText().trim();
                 String enrollments=row.findElement(By.xpath("./td[5]")).getText().trim();

                 boolean is_valid=language.equalsIgnoreCase("Java") && level.equalsIgnoreCase
                         ("Beginner") && Integer.parseInt(enrollments)>5000;

                 if(!is_valid){
                     System.out.println("Test failed : ");
                 }
                 System.out.println("test pass");

          }







    }


    public void NoResultStateTest() {
        Actions actions=new Actions(driver);

        WebElement java = LocatorHelper.findElementbyXpath(driver, WebelementConfig.xpaths.get("JAVA_LANGUAGE_RADIO"));
        WebElement dropdownInput = LocatorHelper.findElementbyXpath(driver, WebelementConfig.xpaths.get("DROPDOWN_SELECT"));
        WebElement selectOption = LocatorHelper.findElementbyXpath(driver, WebelementConfig.xpaths.get("DROPDOWN_OPTION_5000"));
        clickOnElement(java);
        List<WebElement> levelCheckBoxes = LocatorHelper.findElementList(driver, WebelementConfig.xpaths.get("LEVEL_CHECKBOXES"));

        for (WebElement element : levelCheckBoxes) {
            if (element.isSelected()) {
                clickOnElement(element);
            }
        }
        clickOnElement(dropdownInput);
        clickOnElement(selectOption);


        WebElement textDiv = LocatorHelper.findElementbyXpath(driver, WebelementConfig.xpaths.get("NO_DATA_DIV"));
        actions.scrollToElement(textDiv).build().perform();

        if (LocatorHelper.findElementbyXpath(driver, WebelementConfig.xpaths.get("NO_DATA_DIV")).getText().trim().equals("No matching courses.")) {

            System.out.println("Test Passed");
        } else {
            System.out.println("Test Failed");
       }


    }

    public void resetBtnVisibility(){

        WebElement javaRadio=LocatorHelper.findElementbyXpath(driver, WebelementConfig.xpaths.get("JAVA_LANGUAGE_RADIO"));
        WebElement anyRadio=LocatorHelper.findElementbyXpath(driver, WebelementConfig.xpaths.get("ANY_LANGUAGE_RADIO"));
        WebElement dropdownValue=LocatorHelper.findElementbyXpath(driver, WebelementConfig.xpaths.get("DROPDOWN_VALUE"));
        clickOnElement(javaRadio);

        WebElement ResetBtn=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(WebelementConfig.xpaths.get("RESET_BTN"))));

        if(ResetBtn.isDisplayed()){
            System.out.println("Reset btn diaplayed Correctly");
            System.out.println("Partial Test pass");
        }

        clickOnElement(ResetBtn);

        List<WebElement> levelCheckBoxes = LocatorHelper.findElementList(driver, WebelementConfig.xpaths.get("LEVEL_CHECKBOXES"));
         boolean isDefaultTrue=true;
         for(WebElement element:levelCheckBoxes){
             if(!element.isSelected()){
                 isDefaultTrue=false;
             }
         }
         if(!anyRadio.isSelected() && isDefaultTrue && !dropdownValue.getText().trim().equals("Any") ){
             System.out.println("Test Fail");
             System.out.println("Cannot regain the default value");
         }
         else{
             System.out.println("Whole Test pass !");
         }





    }


}
