package tests;

import app.Application;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


public class TestBase {


  public Application app;


  @BeforeMethod
  public void start(){
    app = new Application();
  }

  @AfterMethod
  public void stop(){
    app.quit();
  }




}
