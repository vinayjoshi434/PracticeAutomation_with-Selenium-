package service;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;

public class WebElementOperations {



    public static void clickOnElement(WebElement element){
        element.click();
    }

    public static void setdata(WebElement element, String data){
        element.sendKeys(data);

    }









}
