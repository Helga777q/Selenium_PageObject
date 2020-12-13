package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class ProductPage extends Page {

  public ProductPage(WebDriver wd) {
    super(wd);
    PageFactory.initElements(wd, this);
  }


  @FindBy(css="button[name='add_cart_product']")
  public WebElement addButton;

  @FindBy(css=".quantity")
  public WebElement itemsCartQuantity;




  public boolean isSizeSelectionPresent(){
    return wd.findElements(By.cssSelector("select[name='options[Size]']")).size()>0;
  }

  public void selectSize(int index){
    new Select(wd.findElement(By.cssSelector("select[name='options[Size]']"))).selectByIndex(index);
  }

  public void addProduct() {
    addButton.click();
  }

  public int itemsQuantity(){
   return Integer.parseInt(itemsCartQuantity.getAttribute("textContent"));

  }
  
  public void waitForItemsQuantity(int items){
    wait.until(ExpectedConditions.textToBe(By.cssSelector("#cart .quantity"), String.valueOf(items)));
  }




}
