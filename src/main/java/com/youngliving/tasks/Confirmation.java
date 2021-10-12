package com.youngliving.tasks;

import com.youngliving.actions.Add;
import com.youngliving.actions.Navigate;
import com.youngliving.actions.Select;
import com.youngliving.utilities.utils;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.thucydides.core.annotations.Step;

import static com.youngliving.constants.Constants.BV;
import static com.youngliving.constants.Constants.SHIP_CONFIRMATION_LEFT_OPERAND;

public class Confirmation implements Task {

    private final String pullSignal;
    private final String batchApp;

    public Confirmation(String pullSignal, String batchApp) {

        this.pullSignal = pullSignal;
        this.batchApp = batchApp;
    }

    public static Performable shipment(String pullSignal, String batchApp) {
        return Instrumented.instanceOf(Confirmation.class)
                .withProperties(pullSignal, batchApp);
    }

    @Override
    @Step("{0} Confirms SHIP through JDE UI - #batchApp")
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(Navigate.toBatchApp(BV));
        actor.attemptsTo(Select.theMemphisScheduler(batchApp, "YL0001S", "Shipment Confirmation"));

        utils.wait(1001);
        actor.attemptsTo(Add.leftAndRightOperand(pullSignal, SHIP_CONFIRMATION_LEFT_OPERAND));
    }
}
