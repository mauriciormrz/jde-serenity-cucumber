package fulfillment.tasks;

import fulfillment.actions.Add;
import fulfillment.actions.Navigate;
import fulfillment.actions.Obtain;
import fulfillment.actions.Select;
import fulfillment.questions.Status;
import fulfillment.constants.Constants;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.thucydides.core.annotations.Step;

public class Consolidate implements Task {

    private final String order;
    private final String branch;
    private final String batchApp;

    public Consolidate(String order, String branch, String batchApp) {

        this.order = order;
        this.branch = branch;
        this.batchApp = batchApp;
    }

    public static Performable theOrder(String order, String branch, String batchApp) {
        return Instrumented.instanceOf(Consolidate.class)
                .withProperties(order, branch, batchApp);
    }


    @Override
    @Step("{0} consolidates through JDE UI - #batchApp")
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(Navigate.toBatchApp(Constants.BV));
        actor.attemptsTo(Select.theMemphisScheduler(batchApp, "YL0001S", "Shipment Consolidation"));

        actor.attemptsTo(Add.leftAndRightOperand(order, Constants.CONSOLIDATE_LEFT_OPERAND));

        actor.attemptsTo(Obtain.theOrderInformation(order, branch));
        actor.should(GivenWhenThen.seeThat("Next Status: " + "540", Status.value()));
    }
}