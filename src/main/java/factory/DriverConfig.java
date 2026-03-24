package factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.HashMap;

public class DriverConfig {

    public static WebDriver driver;
    public static WebDriverWait wait;

    public static void loadDriver(){
        BrowserConfigFactory.browserConfig();
        HashMap<String , String> data=BrowserConfigFactory.browserConfig;
        if(data.get("browser").equals("CHROME")){
                driver=new ChromeDriver();
                driver.manage().window().maximize();
                wait =new WebDriverWait(driver, Duration.ofSeconds(10));

        } else if (data.get("browser").equals("EDGE")) {
                driver=new EdgeDriver();
                driver.manage().window().maximize();
                driver.get(BrowserConfigFactory.browserConfig.get("siteURL"));
                wait =new WebDriverWait(driver, Duration.ofSeconds(10));

        } else{
                driver=null;
        }
    }





}
