package stepDef;

import Pages.CartPage;
import Pages.CheckoutPage;
import Utility.Assertion;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class CompleteCheckout {

    CheckoutPage checkoutPage = new CheckoutPage();
    CartPage cartPage = new CartPage();

    @And("user completes checkout")
    public void user_completes_checkout() {
        cartPage.clickCheckoutButton();
        checkoutPage.getFirstNameField();
        checkoutPage.getLastNameField();
        checkoutPage.getPostalCodeField();
        checkoutPage.getContinueButton();
        checkoutPage.getFinishButton();
    }

    @Then("confirmation message should be displayed")
    public void confirmation_message_should_be_displayed() {
        String expectedMessage = "Thank you for your order!";
        String actualMessage = checkoutPage.getConfirmationMessage().getText();

        Assertion.assertTrue(actualMessage.equals(expectedMessage),
                "Confirmation message mismatch: expected=" + expectedMessage + " actual=" + actualMessage);
    }
}
