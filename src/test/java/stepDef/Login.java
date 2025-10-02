package stepDef;

import Pages.LoginPage;
import Pages.ProductListPage;
import Utility.Assertion;
import io.cucumber.java.en.*;
import java.util.List;
import org.openqa.selenium.WebElement;

public class Login {

    LoginPage loginPage = new LoginPage();
    ProductListPage productListPage = new ProductListPage();

    @Given("validate login page and click login")
    public void validate_login_page_and_click_login() {
        loginPage.validateLoginPage();
    }

    @When("write username {string}")
    public void write_username(String user) {
        loginPage.enterUsername(user);
    }

    @And("write password {string}")
    public void write_password(String password) {
        loginPage.enterPassword(password);
    }

    @And("clicks on login btn")
    public void clicks_on_login_btn() {
        loginPage.clickLoginButton();
    }

    @Then("user is navigate to the product page")
    public void user_is_navigate_to_the_product_page() {
        List<WebElement> products = productListPage.productList();
        Assertion.assertTrue(products.size() > 0, "Product page error !!!");
    }
}
