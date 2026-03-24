import PageObject.HomePage;
import PageObject.LoggedInPage;
import PageObject.LoginPage;
import PageObject.TablePage;
import factory.DriverConfig;
import org.openqa.selenium.remote.ExecuteMethod;
import service.FactoryLoader;

public class Exeucutor {


    public static void main(String [] args) {
          try{
              FactoryLoader loader=new FactoryLoader();
              loader.loadconfiguration();
 //           new HomePage().goToPracticepage().goToLoginPage().executeLogin();
//              new LoginPage().executeLogin();
//              var tablePAge=new HomePage().goToPracticepage().goToTablepage();
//              tablePAge.filtertableByLanguage();
//              tablePAge.filterByLevel();

//              new TablePage().filterByDropdown();
//              new TablePage().combinedFilter();
//              new TablePage().NoResultStateTest();
              new TablePage().resetBtnVisibility();

          }finally{
              try {
                  Thread.sleep(4000);
              }catch(InterruptedException e){
                  System.out.println(e.getMessage());
              }

              DriverConfig.driver.quit();
          }
    }
}
