package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Page {

  protected WebDriver wd;
  protected WebDriverWait wait;

  public Page(WebDriver wd) {
    this.wd = wd;
    wait = new WebDriverWait(wd, 10);
  }
}
