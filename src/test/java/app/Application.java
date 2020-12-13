package app;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.CartPage;
import pages.MainPage;
import pages.ProductPage;

import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

import static org.testng.Assert.assertEquals;

public class Application {


  private WebDriver wd;
  private WebDriverWait wait;

  private MainPage mainPage;
  private ProductPage productPage;
  private CartPage cartPage;

  public Application(){
    wd = new FirefoxDriver();
    wd.manage().timeouts().implicitlyWait(2 , TimeUnit.SECONDS);
    wait = new WebDriverWait(wd, 10);
    mainPage = new MainPage(wd);
    cartPage=new CartPage(wd);
    productPage = new ProductPage(wd);
  }

  public void quit(){
    wd.quit();
  }


  public void navigateBack() {
    wd.navigate().back();
  }

  public void openMainPage(){
    mainPage.openMainPage();
  }

  public void openProductPage(int id) {
    mainPage.products.get(id).click();
  }

  public void addToCart() {
    int quantity = productPage.itemsQuantity();
    int quantityNew = quantity + 1;
    if (productPage.isSizeSelectionPresent()) {
      productPage.selectSize(1);
      productPage.addProduct();
    } else {
      productPage.addProduct();
    }
    productPage.waitForItemsQuantity(quantityNew);
    //wait.until(ExpectedConditions.textToBe(By.cssSelector("#cart .quantity"), String.valueOf(quantityNew)));
    quantity = productPage.itemsQuantity();
    assertEquals(quantityNew, quantity); // check that cart has new value of items
  }

  public int getCartQuantityMainPage(){
    return mainPage.getItemsQuantityMainPage();
  }

  //public void checkout() {
    //mainPage.checkoutLink.click();
 // }


  public void clearCart() {
    mainPage.checkoutLink.click();
    int items = cartPage.cartItems.size();
    //clear cart not including the last item in the cart
    for (int i =1; i<items; i++){
      int tableRows = cartPage.orderTableRows.size();
      cartPage.item.click();
      cartPage.removeButton.click();
      int afterRows = tableRows-1;
      //check that the row in Order table minus 1
      cartPage.waitForCartItems(afterRows);
      tableRows = cartPage.orderTableRows.size();
      assertEquals(tableRows, afterRows);
    }
    //clear the last item (or the only one)
    cartPage.removeButton.click();
    cartPage.waitForTableDisappears();
    cartPage.waitTextMatches();
  }





}
