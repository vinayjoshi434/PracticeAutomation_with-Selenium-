package factory;

import com.google.gson.Gson;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;

public class BrowserConfigFactory {

public static HashMap<String , String> browserConfig;

    public static void browserConfig(){

        Gson gson=new Gson();
        try{
          browserConfig=  gson.fromJson(new FileReader("setup/browser.json"), HashMap.class);


        }catch(FileNotFoundException e){
            e.printStackTrace();

        }

    }







}
