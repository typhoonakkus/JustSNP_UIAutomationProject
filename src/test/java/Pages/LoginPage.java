package Pages;

import Base.DriverManager;
import Utility.Assertion;
import Utility.Find;
import Utility.Util;
import Utility.Find.Locator;
import Utility.Util.TimeOut;
import org.openqa.selenium.WebElement;

public class LoginPage extends DriverManager {

    // Locators
    private final String usernameField = "user-name";
    private final String passwordField = "password";
    private final String loginButton = "login-button";

    // Actions
    public void validateLoginPage() {
        WebElement loginBtn = Find.Element(Locator.ID, loginButton, TimeOut.MIDDLE);
        Assertion.ElementExist(loginBtn);
    }

    public void enterUsername(String user) {
        WebElement usrname = Find.Element(Locator.ID, usernameField, TimeOut.MIDDLE);
        Util.sendKeysFunction(usrname, user, TimeOut.HIGH);
    }

    public void enterPassword(String password) {
        WebElement pword = Find.Element(Locator.ID, passwordField, TimeOut.MIDDLE);
        Util.sendKeysFunction(pword, password, TimeOut.LOW);
    }

    public void clickLoginButton() {
        WebElement loginBtn = Find.Element(Locator.ID, loginButton, TimeOut.MIDDLE);
        Util.clickFunction(loginBtn, TimeOut.LOW);
    }
}
