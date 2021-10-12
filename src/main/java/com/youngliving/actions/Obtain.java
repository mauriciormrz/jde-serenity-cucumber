package com.youngliving.actions;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.type.Type;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;

import static com.youngliving.constants.Constants.MENU_APP_IFRAME;
import static com.youngliving.constants.Constants.P4210;
import static com.youngliving.ui.CustomerServiceInquiryPage.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;


public class Obtain implements Interaction {

    private final String order;
    private final String branch;

    public Obtain(String order, String branch) {

        this.order = order;
        this.branch = branch;
    }

    public static Performable theOrderInformation(String order, String branch) {
        return Instrumented.instanceOf(Obtain.class)
                .withProperties(order, branch);
    }

    @Override
    @Step("Find the order '#order' information and verify that it exists")
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(Navigate.toBatchApp(P4210));
        getDriver().switchTo().frame(MENU_APP_IFRAME);

        actor.attemptsTo(
                WaitUntil.the(TXT_BRANCH_PLANT, isClickable()).forNoMoreThan(15).seconds(),
                Click.on(TXT_BRANCH_PLANT),
                Enter.theValue(branch).into(TXT_BRANCH_PLANT)
        );

        actor.attemptsTo(
                Click.on(TXT_CUSTOMER_PO),
                Type.theValue(order).into(TXT_CUSTOMER_PO)
        );

        actor.attemptsTo(Click.on(ICON_FIND));
    }
}
