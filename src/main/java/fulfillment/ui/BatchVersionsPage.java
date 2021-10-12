package fulfillment.ui;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;


public class BatchVersionsPage extends PageObject {

    public static final Target TXT_BATCH_APPLICATION = Target.the("Batch Application Field")
            .located(By.cssSelector("#C0_11"));

    public static final Target ICON_GREEN_CHECK = Target.the("Green Check Mark Batch Versions")
            .located(By.cssSelector("#hc_Select"));

    public static final Target CHECKBOX_MEMPHIS = Target.the("Memphis Checkbox")
            .locatedBy("//*[contains(text(),'{0}')]/../../td/div/input[@type='checkbox']");

    public static final Target CHECKBOX_DATA_SELECTION = Target.the("Data Selection Checkbox")
            .located(By.cssSelector("#C0_23"));

    public static final Target ICON_SUBMIT = Target.the("Submit")
            .located(By.cssSelector("#hc0"));
}

