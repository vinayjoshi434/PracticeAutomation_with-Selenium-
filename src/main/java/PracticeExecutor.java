import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class PracticeExecutor {


    public static void main( String args[]) {
        WebDriver driver=new ChromeDriver();
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        Actions actions=new Actions(driver);

            driver.manage().window().maximize();
            driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
            WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[normalize-space()='OrangeHRM, Inc']")));
            actions.scrollToElement(element).build().perform();
            element.click();

            Set<String> windowid=driver.getWindowHandles();
            List<String> windowIdList=new ArrayList<>(windowid);
            driver.switchTo().window(windowIdList.get(1));
            String title=driver.getTitle();
        System.out.println(title);












    }


}
