package com.youngliving.ui;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;


public class CustomerServiceInquiryPage extends PageObject {

    public static final Target TXT_CUSTOMER_PO = Target.the("Legacy Order Id in Customer PO field")
            .located(By.cssSelector("#C0_19"));

    public static final Target TXT_BRANCH_PLANT = Target.the("Branch/Plant ")
            .located(By.cssSelector("#C0_7"));

    public static final Target ICON_FIND = Target.the("Magnifying glass to search for order")
            .located(By.cssSelector("#hc_Find"));

    public static final Target ROW_NUMBERS = Target.the("Row numbers")
            .located(By.xpath("//td[@id='GridLabel0_1.RowNumber']"));

}
