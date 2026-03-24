package service;


import factory.DriverConfig;
import factory.WebelementConfig;

public class FactoryLoader {

    public void loadconfiguration(){
        DriverConfig.loadDriver();
        WebelementConfig.loadWebElement();







    }



}
