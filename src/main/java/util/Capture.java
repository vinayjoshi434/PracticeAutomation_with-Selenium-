package util;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;

public class Capture {

   public static void savescreenshot(WebDriver driver, String filename){
       TakesScreenshot screenshot=(TakesScreenshot)driver;
       File source=screenshot.getScreenshotAs(OutputType.FILE);

       String folderName= LocalDate.now().toString();
       String folderPath= "screenshots/"+folderName+"/";

       File folder=new File(folderPath);
       if(!folder.exists()){
           folder.mkdir();
       }

       File destination=new File(folderPath+filename+".jpg");
       try{
           FileUtils.copyFile(source, destination);

       }catch(IOException e){
           System.out.println("Exception occur in file creation" );
           e.printStackTrace();
       }




   }









}
