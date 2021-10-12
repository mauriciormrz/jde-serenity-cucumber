package com.youngliving.ui;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;


public class HomePage extends PageObject {

    public static final Target TXT_USER_NAME = Target.the("User name Text Field")
            .located(By.cssSelector("#usernameDiv"));

    public static final Target ICON_NAVIGATOR = Target.the("Navigator Icon")
            .located(By.cssSelector("#drop_mainmenu"));

    public static final Target TXT_FAST_PATH = Target.the("Fast Path Text Field")
            .located(By.cssSelector("#TE_FAST_PATH_BOX"));

    public static final Target BTN_FAST_PATH = Target.the("Fast Path Button")
            .located(By.cssSelector("#fastPathButton"));

    public static final Target ROWS_ORDER_INFO_TABLE_XPATH = Target.the("Columns of every row of the order table")
            .locatedBy("//*[@id='jdeGridData0_1']//tr[@realrow='{0}']//td//div");

    public static final Target BTN_REFRESH = Target.the("Recent Reports Refresh")
            .located(By.cssSelector("#listRecRptsPositionHelper"));


}



