package fulfillment.actions;

import fulfillment.utilities.utils;
import fulfillment.constants.Constants;
import fulfillment.ui.BatchVersionsPage;
import fulfillment.ui.DataSelectionPage;
import fulfillment.ui.LiteralValuePage;
import fulfillment.ui.PrinterSelectionPage;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import net.serenitybdd.screenplay.actions.type.Type;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static fulfillment.model.Color.BLUE;
import static fulfillment.model.Color.RESET;
import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

public class Add implements Interaction {

    private final String rightOperand;
    private final String leftOperand;

    public Add(String pullSignal, String leftOperand) {

        this.rightOperand = pullSignal;
        this.leftOperand = leftOperand;

    }

    public static Performable leftAndRightOperand(String pullSignal, String leftOperand) {
        return Instrumented.instanceOf(Add.class)
                .withProperties(pullSignal, leftOperand);
    }

    @Override
    @Step("{0} Adds left operand #leftOperand")
    public <T extends Actor> void performAs(T actor) {

        List<WebElement> operators = getDriver().findElements(By.xpath(Constants.OPERATORS_TABLE_XPATH));
        final String NUM_ROWS = String.valueOf(operators.size() - 1);

        actor.attemptsTo(
                SelectFromOptions.byVisibleText(leftOperand).from((DataSelectionPage.DROPDOWN_LEFT_OPERAND).of(NUM_ROWS)),
                SelectFromOptions.byVisibleText(Constants.COMPARISON).from((DataSelectionPage.DROPDOWN_COMPARISON).of(NUM_ROWS)),
                SelectFromOptions.byVisibleText(Constants.RIGHT_OPERAND).from((DataSelectionPage.DROPDOWN_RIGHT_OPERAND).of(NUM_ROWS))
        );

        System.out.println(BLUE + Constants.INDENTATION + "Left Operand:  " + RESET + leftOperand);
        utils.wait(1001);
        actor.attemptsTo(
                Type.theValue(rightOperand).into(LiteralValuePage.INPUT_LITERAL_VALUE)
        );
        actor.attemptsTo(Click.on(LiteralValuePage.ICON_GREEN_CHECK_LITERAL_VALUE));

        System.out.println(BLUE + Constants.INDENTATION + "Right Operand: " + RESET + rightOperand);
        actor.attemptsTo(Click.on(BatchVersionsPage.ICON_GREEN_CHECK));
        actor.attemptsTo(Click.on(PrinterSelectionPage.ICON_GREEN_CHECK_PRINTER_SELECTION));
    }
}
