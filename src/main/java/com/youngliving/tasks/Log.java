package com.youngliving.tasks;

import com.youngliving.ui.LoginPage;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actions.type.Type;
import net.thucydides.core.annotations.Step;

import static com.youngliving.ui.LoginPage.*;

public class Log implements Task {

    private final String env;
    private final String user;
    private final String password;

    private final LoginPage loginPage = new LoginPage();


    public Log(String env, String user, String password) {
        this.env = env;
        this.user = user;
        this.password = password;
    }

    public static Performable intoJDE(String env, String user, String password) {
        return Instrumented.instanceOf(Log.class)
                .withProperties(env, user, password);
    }

    @Override
    @Step("{0} navigates to the JDE website")
    public <T extends Actor> void performAs(T actor) {

        switch (env) {
            case "clone":
                loginPage.setDefaultBaseUrl("https://jdeqa.yleo.us/");
                break;
            case "ext5":
                loginPage.setDefaultBaseUrl("https://jdedv.yleo.us/");
                break;
        }

        actor.attemptsTo(Open.browserOn(loginPage));
        System.out.println(user);
        System.out.println(password);

        actor.attemptsTo(
                Type.theValue(user).into(TXT_USER_ID),
                Type.theValue(password).into(TXT_PASSWORD),
                Click.on(BTN_SIGN_IN)
        );
    }
}