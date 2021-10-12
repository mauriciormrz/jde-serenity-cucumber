package fulfillment.tasks;

import fulfillment.actions.Obtain;
import fulfillment.constants.Constants;
import fulfillment.questions.Header;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;

import static fulfillment.ui.CustomerServiceInquiryPage.ROW_NUMBERS;
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
        actor.should(GivenWhenThen.seeThat(Constants.ROW_NUMBERS_TEXT, Header.amount(), not("1 - 1")));
    }
}
