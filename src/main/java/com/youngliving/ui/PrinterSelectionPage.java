package com.youngliving.ui;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;


public class PrinterSelectionPage extends PageObject {


    public static final Target ICON_GREEN_CHECK_PRINTER_SELECTION = Target.the("Green Check Mark Printer Selection")
            .located(By.cssSelector("#hc_OK"));

}

