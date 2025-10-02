package stepDef;

import Base.DriverManager;
import Pages.CartPage;
import Pages.ProductListPage;
import Utility.Assertion;
import Utility.EnvReader;
import Utility.Util;
import Utility.Util.TimeOut;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebElement;

import java.util.List;


public class AddToCart extends DriverManager{

    ProductListPage productListPage = new ProductListPage();
    CartPage cartPage = new CartPage();

    @And("user adds first product to cart")
    public void user_adds_first_product_to_cart() {
        List<WebElement> firstCartBtn = productListPage.getAddToCartButtons();
        Util.clickFunction(firstCartBtn.get(0), TimeOut.LOW);
    }

    @And("user navigates to cart")
    public void user_navigates_to_cart() {
        productListPage.navigateToCart();
    }

    @Then("UI product title and price match API data")
    public void ui_product_title_and_price_match_api_data() {
        String apiProductTitle = EnvReader.getValue("apiProductTitle");
        System.out.println(apiProductTitle);
        String apiProductPrice = EnvReader.getValue("apiProductPrice");
        System.out.println(apiProductPrice);
        String uiProductTitle = cartPage.getCartItemName().getText();
        String uiProductPrice = cartPage.getCartItemPrice().getText();

        Assertion.assertTrue(uiProductTitle.equals(apiProductTitle),
                "Product title mismatch: UI=" + uiProductTitle + " API=" + apiProductTitle);

        Assertion.assertTrue(uiProductPrice.contains(apiProductPrice),
                "Product price mismatch: UI=" + uiProductPrice + " API=" + apiProductPrice);
    }
}
