package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class MainPage extends Page{

  public MainPage (WebDriver wd){
    super(wd);
    PageFactory.initElements(wd, this);
  }

  @FindBy(css = "#cart .link")
  public WebElement checkoutLink;


  @FindBy(css=".column.product.shadow")
  public List<WebElement> products;

  @FindBy(css=".quantity")
  public WebElement itemsCartQuantity;



  public void openMainPage(){
    wd.get("http://localhost/litecart/");
  }

  public int getItemsQuantityMainPage() {
    return Integer.parseInt(itemsCartQuantity.getAttribute("textContent"));
  }





}
