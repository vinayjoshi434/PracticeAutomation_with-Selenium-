package factory;



import com.google.gson.Gson;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;


public class WebelementConfig {

    public static HashMap<String , String> xpaths;

    public static void loadWebElement(){
        Gson gson=new Gson();
        try{
           xpaths= gson.fromJson(new FileReader("setup/webelement.json"), HashMap.class);
        }catch(FileNotFoundException e){
            e.printStackTrace();

        }

    }




}
