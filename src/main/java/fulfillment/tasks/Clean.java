package fulfillment.tasks;

import fulfillment.actions.Add;
import fulfillment.actions.Navigate;
import fulfillment.actions.Select;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.thucydides.core.annotations.Step;

import static fulfillment.constants.Constants.BV;
import static fulfillment.constants.Constants.LOT_CLEAN_UP_LEFT_OPERAND;


public class Clean implements Task {

    private final String pullSignal;
    private final String batchApp;

    public Clean(String pullSignal, String batchApp) {

        this.pullSignal = pullSignal;
        this.batchApp = batchApp;
    }

    public static Performable lotThrough(String pullSignal, String batchApp) {
        return Instrumented.instanceOf(Clean.class)
                .withProperties(pullSignal, batchApp);
    }

    @Override
    @Step("{0} Cleans LOT through JDE UI - #batchApp")
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(Navigate.toBatchApp(BV));
        actor.attemptsTo(Select.theMemphisScheduler(batchApp, "YLG0004", "Auto LOT Update - Memphis - EDSP equal H"));

        actor.attemptsTo(Add.leftAndRightOperand(pullSignal, LOT_CLEAN_UP_LEFT_OPERAND));
    }
}
