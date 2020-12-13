package tests;

import org.testng.Assert;
import org.testng.annotations.Test;




public class CartProductsTests extends TestBase {

  @Test
  public void CartCheckoutTest() {
    app.openMainPage();
    int products = 3;
    for (int i = 1; i <= products; i++) {
      app.openProductPage(0);
      app.addToCart();
      app.navigateBack();
    }
    app.clearCart();
    app.navigateBack();
    Assert.assertEquals(app.getCartQuantityMainPage(), 0);
  }


}
