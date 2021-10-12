package com.youngliving.ui;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class ItemAvailability extends PageObject {

    public static final Target INPUT_ITEM_NUMBER = Target.the("Item Number Input Field")
            .located(By.cssSelector("#C0_17"));

    public static final Target TXT_BRANCH_PLANT = Target.the("Branch/Plant ")
            .located(By.cssSelector("#C0_7"));
}
