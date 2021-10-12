package com.youngliving.actions;

import com.youngliving.model.AuthenticationKey;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;
import net.thucydides.core.annotations.Step;

import static com.youngliving.constants.Constants.*;
import static com.youngliving.model.AuthenticationKey.Builder.anAuthenticationKey;
import static com.youngliving.model.Color.BLUE;
import static com.youngliving.model.Color.RESET;
import static com.youngliving.utilities.utils.format;
import static net.serenitybdd.rest.SerenityRest.lastResponse;

public class Get implements Interaction {

    private final String pullSignal;


    public Get(String pullSignal) {

        this.pullSignal = pullSignal;
    }

    public static Performable ProStarWH85Shipment(String pullSignal) {
        return Instrumented.instanceOf(Get.class)
                .withProperties(pullSignal);
    }


    @Override
    @Step("{0} Calls method GET and PSIG #pullSignal")
    public <T extends Actor> void performAs(T actor) {

        getProStarWH85Shipments();
    }

    private void getProStarWH85Shipments() {

        AuthenticationKey authenticationKey = anAuthenticationKey()
                .withMethod(GET_METHOD)
                .withPath("/100")
                .build();

        SerenityRest.given()
                .header(AUTHENTICATION_KEY, PUBLIC_KEY_PRO_STAR + ":" + authenticationKey.getHash())
                .header(TIMESTAMP_KEY, authenticationKey.getEpoch())
                .header(ACCEPT_KEY, ACCEPT_VALUE)
                .header(ACCEPT_KEY, ACCEPT_VALUE)
                .contentType(CONTENT_TYPE)
                .when().get(authenticationKey.getPath());

        int statusCode = lastResponse().statusCode();
        System.out.println(BLUE + INDENTATION + "GET ProStarWH85Shipments    " + RESET + "Status Code: " + statusCode);

        //if (statusCode != 200) {
        format(lastResponse().body().asPrettyString());
        //}
    }
}
