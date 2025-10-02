package Pages;

import Base.DriverManager;
import Utility.Assertion;
import Utility.Find;
import Utility.Util;
import Utility.Find.Locator;
import Utility.Util.TimeOut;
import org.openqa.selenium.WebElement;

public class CartPage extends DriverManager {

    // Locators
    private final String checkoutButton = "checkout";
    private final String cartItemName = "inventory_item_name";
    private final String cartItemPrice = "inventory_item_price";

    // Actions
    public void clickCheckoutButton() {
        WebElement checkoutBtn = Find.Element(Locator.ID, checkoutButton, TimeOut.MIDDLE);
        Assertion.ElementExist(checkoutBtn);
        Util.clickFunction(checkoutBtn, TimeOut.LOW);
    }

    public WebElement getCartItemName() {
        return Find.Element(Locator.CLASS_NAME, cartItemName, TimeOut.MIDDLE);
    }

    public WebElement getCartItemPrice() {
        return Find.Element(Locator.CLASS_NAME, cartItemPrice, TimeOut.MIDDLE);
    }
}