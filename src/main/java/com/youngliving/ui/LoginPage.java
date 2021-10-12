package com.youngliving.ui;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;


public class LoginPage extends PageObject {

    public static final Target TXT_USER_ID = Target.the("User ID Text Field")
            .located(By.cssSelector("#User"));

    public static final Target TXT_PASSWORD = Target.the("Password Text Field")
            .located(By.cssSelector("#Password"));

    public static final Target BTN_SIGN_IN = Target.the("Sign In Button")
            .located(By.cssSelector("input[type='submit'][value='Sign In']"));

}

