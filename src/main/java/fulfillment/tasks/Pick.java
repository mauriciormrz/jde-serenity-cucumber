package fulfillment.tasks;

import fulfillment.actions.Navigate;
import fulfillment.actions.Obtain;
import fulfillment.actions.Select;
import fulfillment.questions.Status;
import fulfillment.utilities.utils;
import fulfillment.constants.Constants;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;

import static fulfillment.ui.BatchVersionsPage.ICON_GREEN_CHECK;
import static fulfillment.ui.PrinterSelectionPage.ICON_GREEN_CHECK_PRINTER_SELECTION;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;


public class Pick implements Task {

    private final String order;
    private final String branch;
    private final String batchApp;


    public Pick(String order, String branch, String batchApp) {
        this.order = order;
        this.branch = branch;
        this.batchApp = batchApp;
    }

    public static Performable slip(String order, String branch, String batchApp) {
        return Instrumented.instanceOf(Pick.class)
                .withProperties(order, branch, batchApp);
    }

    @Override
    @Step("{0} Pick Slip through JDE UI - #batchApp0")
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(Navigate.toBatchApp(Constants.BV));
        actor.attemptsTo(Select.theMemphisScheduler(batchApp, "YLG0001S", "Print Pick Slip for "));

        actor.attemptsTo(
                WaitUntil.the(ICON_GREEN_CHECK, isClickable()).forNoMoreThan(15).seconds(),
                Click.on(ICON_GREEN_CHECK)
        );
        actor.attemptsTo(
                WaitUntil.the(ICON_GREEN_CHECK_PRINTER_SELECTION, isClickable()).forNoMoreThan(15).seconds(),
                Click.on(ICON_GREEN_CHECK_PRINTER_SELECTION)
        );

        utils.wait(7001);
        actor.attemptsTo(Obtain.theOrderInformation(order, branch));

        actor.should(GivenWhenThen.seeThat("Next Status: " + "560", Status.value()));
    }
}
