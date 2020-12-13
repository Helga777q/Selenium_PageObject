package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.regex.Pattern;

public class CartPage extends Page {


  public CartPage(WebDriver wd) {
    super(wd);
    PageFactory.initElements(wd, this);
  }


  @FindBy(css = "button[name='remove_cart_item']")
  public WebElement removeButton;

  @FindBy(css = ".dataTable.rounded-corners")
  public WebElement orderTable;

  @FindBy(css = ".dataTable.rounded-corners tr")
  public List<WebElement> orderTableRows;

  @FindBy(css = ".items li")
  public List<WebElement> cartItems;

  @FindBy(css = "li.shortcut")
  public WebElement item;


  public void waitForTableDisappears() {
    wait.until(ExpectedConditions.stalenessOf(wd.findElement(By.cssSelector(".dataTable.rounded-corners"))));
  }

  public void waitTextMatches() {
    wait.until(ExpectedConditions.textMatches(By.cssSelector("div#checkout-cart-wrapper"), Pattern.compile("^There are no items in your cart.")));
  }

  public void waitForCartItems(int count) {
    wait.until(ExpectedConditions.numberOfElementsToBe(By.cssSelector(".dataTable.rounded-corners tr"), count));
  }

}
