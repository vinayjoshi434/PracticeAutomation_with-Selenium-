package service;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LocatorHelper {


    public static WebElement findElementbyXpath(WebDriver driver , String xpathString){
        return driver.findElement(By.xpath(xpathString));
    }

    public static List<WebElement> findElementList(WebDriver driver , String xpathString){
        return driver.findElements(By.xpath(xpathString));
    }





}
