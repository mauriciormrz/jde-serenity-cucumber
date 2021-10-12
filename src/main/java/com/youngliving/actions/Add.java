package com.youngliving.actions;

import com.youngliving.utilities.utils;
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

import static com.youngliving.constants.Constants.*;
import static com.youngliving.model.Color.BLUE;
import static com.youngliving.model.Color.RESET;
import static com.youngliving.ui.BatchVersionsPage.ICON_GREEN_CHECK;
import static com.youngliving.ui.DataSelectionPage.*;
import static com.youngliving.ui.LiteralValuePage.ICON_GREEN_CHECK_LITERAL_VALUE;
import static com.youngliving.ui.LiteralValuePage.INPUT_LITERAL_VALUE;
import static com.youngliving.ui.PrinterSelectionPage.ICON_GREEN_CHECK_PRINTER_SELECTION;
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

        List<WebElement> operators = getDriver().findElements(By.xpath(OPERATORS_TABLE_XPATH));
        final String NUM_ROWS = String.valueOf(operators.size() - 1);

        actor.attemptsTo(
                SelectFromOptions.byVisibleText(leftOperand).from((DROPDOWN_LEFT_OPERAND).of(NUM_ROWS)),
                SelectFromOptions.byVisibleText(COMPARISON).from((DROPDOWN_COMPARISON).of(NUM_ROWS)),
                SelectFromOptions.byVisibleText(RIGHT_OPERAND).from((DROPDOWN_RIGHT_OPERAND).of(NUM_ROWS))
        );

        System.out.println(BLUE + INDENTATION + "Left Operand:  " + RESET + leftOperand);
        utils.wait(1001);
        actor.attemptsTo(
                Type.theValue(rightOperand).into(INPUT_LITERAL_VALUE)
        );
        actor.attemptsTo(Click.on(ICON_GREEN_CHECK_LITERAL_VALUE));

        System.out.println(BLUE + INDENTATION + "Right Operand: " + RESET + rightOperand);
        actor.attemptsTo(Click.on(ICON_GREEN_CHECK));
        actor.attemptsTo(Click.on(ICON_GREEN_CHECK_PRINTER_SELECTION));
    }
}
