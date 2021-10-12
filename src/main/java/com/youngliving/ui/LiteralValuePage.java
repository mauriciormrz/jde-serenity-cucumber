package com.youngliving.ui;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;


public class LiteralValuePage extends PageObject {

    public static final Target INPUT_LITERAL_VALUE = Target.the("Literal Value Input Field")
            .located(By.cssSelector("#LITtf"));

    public static final Target ICON_GREEN_CHECK_LITERAL_VALUE = Target.the("Green Check Mark Select Literal Value ")
            .located(By.cssSelector("#hc_Select"));
}
