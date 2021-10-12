package com.youngliving.tasks;

import com.youngliving.actions.FigureOut;
import com.youngliving.actions.Navigate;
import com.youngliving.model.Lot;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.thucydides.core.annotations.Step;

import java.util.List;

import static com.youngliving.constants.Constants.P41202;

public class Complete implements Task {

    private final String branch;
    private final List<Lot> lots;

    public Complete(String branch, List<Lot> lots) {

        this.branch = branch;
        this.lots = lots;
    }

    public static Performable theLotSerials(String branch, List<Lot> lots) {
        return Instrumented.instanceOf(Complete.class)
                .withProperties(branch, lots);
    }

    @Override
    @Step("{0} gets the lot serials")
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(Navigate.toBatchApp(P41202));
        actor.attemptsTo(FigureOut.theAvailableAmountOfItems(branch, lots));
    }
}
