package com.youngliving.tasks;

import com.youngliving.actions.Obtain;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;

import static com.youngliving.constants.Constants.ROW_NUMBERS_TEXT;
import static com.youngliving.questions.Header.amount;
import static com.youngliving.ui.CustomerServiceInquiryPage.ROW_NUMBERS;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isCurrentlyVisible;
import static org.hamcrest.Matchers.not;

public class Verify implements Task {

    private final String order;
    private final String branch;

    public Verify(String order, String branch) {

        this.order = order;
        this.branch = branch;
    }

    public static Performable theOrderCreated(String order, String branch) {
        return Instrumented.instanceOf(Verify.class)
                .withProperties(order, branch);
    }

    @Override
    @Step("{0} Obtains the order '#order' information")
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(Obtain.theOrderInformation(order, branch));
        actor.attemptsTo(WaitUntil.the(ROW_NUMBERS, isCurrentlyVisible()).forNoMoreThan(15).seconds());
        actor.should(GivenWhenThen.seeThat(ROW_NUMBERS_TEXT, amount(), not("1 - 1")));
    }
}
