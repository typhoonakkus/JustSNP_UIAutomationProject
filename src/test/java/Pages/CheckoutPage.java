package Pages;

import Base.DriverManager;
import Utility.Assertion;
import Utility.Find;
import Utility.Find.Locator;
import Utility.Util;
import Utility.Util.TimeOut;
import org.openqa.selenium.WebElement;

public class CheckoutPage extends DriverManager {
    //Locator
    private final String firstNameField = "first-name";
    private final String lastNameField = "last-name";
    private final String postalCodeField = "postal-code";
    private final String continueBtn = "continue";
    private final String finishBtn = "finish";
    private final String confirmationMessage = "complete-header";

    // Actions
    public void getFirstNameField() {
        WebElement firstName = Find.Element(Locator.ID, firstNameField, TimeOut.MIDDLE);
        Util.sendKeysFunction(firstName,"Tay",TimeOut.MIDDLE);
    }
    public void getLastNameField() {
        WebElement lastName = Find.Element(Locator.ID, lastNameField, TimeOut.MIDDLE);
        Util.sendKeysFunction(lastName,"Akks",TimeOut.MIDDLE);
    }
    public void getPostalCodeField() {
        WebElement postalCode = Find.Element(Locator.ID, postalCodeField, TimeOut.MIDDLE);
        Util.sendKeysFunction(postalCode,"12345",TimeOut.MIDDLE);
    }

    public void getContinueButton() {
        WebElement checkoutBtn = Find.Element(Locator.ID, continueBtn, TimeOut.MIDDLE);
        Util.clickFunction(checkoutBtn, TimeOut.LOW);
    }

    public void getFinishButton() {
        WebElement checkoutBtn = Find.Element(Locator.ID, finishBtn, TimeOut.MIDDLE);
        Util.clickFunction(checkoutBtn, TimeOut.LOW);    }

    public WebElement getConfirmationMessage() {
        return Find.Element(Locator.CLASS_NAME, confirmationMessage, TimeOut.MIDDLE);
    }
}
