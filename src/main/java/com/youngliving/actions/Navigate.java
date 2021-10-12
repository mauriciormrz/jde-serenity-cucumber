package com.youngliving.actions;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;

import static com.youngliving.ui.HomePage.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

public class Navigate implements Interaction {

    private final String batchApp;

    public Navigate(String batchApp) {

        this.batchApp = batchApp;
    }

    public static Performable toBatchApp(String batchApp) {
        return Instrumented.instanceOf(Navigate.class)
                .withProperties(batchApp);
    }

    @Override
    @Step("{0} Navigates to batch application '#batchApp'")
    public <T extends Actor> void performAs(T actor) {

        getDriver().switchTo().defaultContent();
        actor.attemptsTo(
                WaitUntil.the(ICON_NAVIGATOR, isClickable()).forNoMoreThan(15).seconds(),
                Click.on(ICON_NAVIGATOR),
                Enter.theValue(batchApp).into(TXT_FAST_PATH),
                Click.on(BTN_FAST_PATH)
        );
    }
}
