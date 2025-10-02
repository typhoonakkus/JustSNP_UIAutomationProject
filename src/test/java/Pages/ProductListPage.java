package Pages;

import Base.DriverManager;
import Utility.Find;
import Utility.Find.Locator;
import Utility.Util;
import Utility.Util.TimeOut;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ProductListPage extends DriverManager {

    // Locators
    private final String firstProductAddBtn = "add-to-cart-sauce-labs-backpack";
    private final String cartButton = "shopping_cart_container";
    private final String inventoryItems = "inventory_item";
    private final String addToCartButtons = "//button[contains(@id,'add-to-cart')]";

    // Actions

    public List<WebElement> getAddToCartButtons() {
        return Find.Elements(Locator.XPATH, addToCartButtons, TimeOut.MIDDLE);
    }

    public List<WebElement> productList() {
        return Find.Elements(Locator.CLASS_NAME, inventoryItems, TimeOut.MIDDLE);
    }

    public void navigateToCart() {
        WebElement cartBtn = Find.Element(Locator.ID, cartButton, TimeOut.MIDDLE);
        Util.clickFunction(cartBtn, TimeOut.LOW);
    }
}
