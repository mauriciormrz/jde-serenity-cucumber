package fulfillment.actions;

import fulfillment.model.Lot;
import fulfillment.questions.Available;
import fulfillment.utilities.utils;
import fulfillment.constants.Constants;
import fulfillment.model.Color;
import fulfillment.ui.CustomerServiceInquiryPage;
import fulfillment.ui.ItemAvailability;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;

import java.util.List;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

public class FigureOut implements Interaction {

    private final String branch;
    private final List<Lot> lots;

    public FigureOut(String branch, List<Lot> lots) {
        this.branch = branch;
        this.lots = lots;
    }

    public static Performable theAvailableAmountOfItems(String branch, List<Lot> lots) {
        return Instrumented.instanceOf(FigureOut.class)
                .withProperties(branch, lots);
    }

    @Override
    @Step("{0} gets the amount available of the items")
    public <T extends Actor> void performAs(T actor) {

        getDriver().switchTo().frame(Constants.MENU_APP_IFRAME);

        for (Lot e : lots) {
            actor.attemptsTo(
                    WaitUntil.the(ItemAvailability.INPUT_ITEM_NUMBER, isClickable()).forNoMoreThan(15).seconds(),
                    Click.on(ItemAvailability.INPUT_ITEM_NUMBER),
                    Enter.theValue(e.getPartNumber()).into(ItemAvailability.INPUT_ITEM_NUMBER)
            );

            actor.attemptsTo(
                    WaitUntil.the(ItemAvailability.TXT_BRANCH_PLANT, isClickable()).forNoMoreThan(15).seconds(),
                    Click.on(ItemAvailability.TXT_BRANCH_PLANT),
                    Enter.theValue(branch).into(ItemAvailability.TXT_BRANCH_PLANT)
            );

            actor.attemptsTo(Click.on(CustomerServiceInquiryPage.ICON_FIND));
            utils.wait(2001);
            actor.attemptsTo(WaitUntil.the("#GridLabel0_319\\.RowNumber", isVisible()).forNoMoreThan(15).seconds());
            actor.should(GivenWhenThen.seeThat("Lot Serial", Available.value(e)));
            System.out.println(Color.BLUE + Constants.INDENTATION + "LOT: " + Color.RESET + e);
        }
    }
}
