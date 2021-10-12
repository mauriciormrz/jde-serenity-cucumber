package fulfillment.actions;

import fulfillment.utilities.utils;
import fulfillment.constants.Constants;
import fulfillment.ui.BatchVersionsPage;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;

import static fulfillment.model.Color.BLUE;
import static fulfillment.model.Color.RESET;
import static fulfillment.ui.CustomerServiceInquiryPage.ICON_FIND;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

public class Select implements Interaction {

    private final String batchApp;
    private final String batchVersion;
    private final String versionTitle;

    public Select(String batchApp, String batch_version, String version_title) {

        this.batchApp = batchApp;
        this.batchVersion = batch_version;
        this.versionTitle = version_title;
    }

    public static Performable theMemphisScheduler(String batchApp, String batchVersion, String versionTitle) {
        return Instrumented.instanceOf(Select.class)
                .withProperties(batchApp, batchVersion, versionTitle);
    }

    @Override
    @Step("{0} selects '#batchVersion' - #versionTitle Memphis - Scheduler")
    public <T extends Actor> void performAs(T actor) {

        getDriver().switchTo().frame(Constants.MENU_APP_IFRAME);

        utils.wait(1001);
        actor.attemptsTo(
                WaitUntil.the(BatchVersionsPage.TXT_BATCH_APPLICATION, isClickable()).forNoMoreThan(15).seconds(),
                Click.on(BatchVersionsPage.TXT_BATCH_APPLICATION),
                Enter.theValue(batchApp).into(BatchVersionsPage.TXT_BATCH_APPLICATION)
        );

        System.out.println(BLUE + Constants.INDENTATION + "VersionTitle:  " + RESET + versionTitle);
        actor.attemptsTo(
                WaitUntil.the(ICON_FIND, isClickable()).forNoMoreThan(15).seconds(),
                Click.on(ICON_FIND),
                Click.on(BatchVersionsPage.CHECKBOX_MEMPHIS.of(batchVersion)),
                Click.on(BatchVersionsPage.ICON_GREEN_CHECK)
        );


        System.out.println(BLUE + Constants.INDENTATION + "BatchApp:      " + RESET + batchApp);
        actor.attemptsTo(
                WaitUntil.the(BatchVersionsPage.CHECKBOX_DATA_SELECTION, isClickable()).forNoMoreThan(15).seconds(),
                Click.on(BatchVersionsPage.CHECKBOX_DATA_SELECTION),
                Click.on(BatchVersionsPage.ICON_SUBMIT)
        );
        System.out.println(BLUE + Constants.INDENTATION + "BatchVersion:  " + RESET + batchVersion);
        utils.wait(1001);
    }
}
