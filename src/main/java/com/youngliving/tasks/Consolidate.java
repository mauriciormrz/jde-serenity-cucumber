package com.youngliving.tasks;

import com.youngliving.actions.Add;
import com.youngliving.actions.Navigate;
import com.youngliving.actions.Obtain;
import com.youngliving.actions.Select;
import com.youngliving.questions.Status;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.thucydides.core.annotations.Step;

import static com.youngliving.constants.Constants.BV;
import static com.youngliving.constants.Constants.CONSOLIDATE_LEFT_OPERAND;

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

        actor.attemptsTo(Navigate.toBatchApp(BV));
        actor.attemptsTo(Select.theMemphisScheduler(batchApp, "YL0001S", "Shipment Consolidation"));

        actor.attemptsTo(Add.leftAndRightOperand(order, CONSOLIDATE_LEFT_OPERAND));

        actor.attemptsTo(Obtain.theOrderInformation(order, branch));
        actor.should(GivenWhenThen.seeThat("Next Status: " + "540", Status.value()));
    }
}