package fulfillment.actions;

import fulfillment.constants.Constants;
import fulfillment.ui.CustomerServiceInquiryPage;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.type.Type;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;


public class Obtain implements Interaction {

    private final String order;
    private final String branch;

    public Obtain(String order, String branch) {

        this.order = order;
        this.branch = branch;
    }

    public static Performable theOrderInformation(String order, String branch) {
        return Instrumented.instanceOf(Obtain.class)
                .withProperties(order, branch);
    }

    @Override
    @Step("Find the order '#order' information and verify that it exists")
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(Navigate.toBatchApp(Constants.P4210));
        getDriver().switchTo().frame(Constants.MENU_APP_IFRAME);

        actor.attemptsTo(
                WaitUntil.the(CustomerServiceInquiryPage.TXT_BRANCH_PLANT, isClickable()).forNoMoreThan(15).seconds(),
                Click.on(CustomerServiceInquiryPage.TXT_BRANCH_PLANT),
                Enter.theValue(branch).into(CustomerServiceInquiryPage.TXT_BRANCH_PLANT)
        );

        actor.attemptsTo(
                Click.on(CustomerServiceInquiryPage.TXT_CUSTOMER_PO),
                Type.theValue(order).into(CustomerServiceInquiryPage.TXT_CUSTOMER_PO)
        );

        actor.attemptsTo(Click.on(CustomerServiceInquiryPage.ICON_FIND));
    }
}
