package com.youngliving.actions;

import com.youngliving.model.AuthenticationKey;
import com.youngliving.model.Shipment;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;
import net.thucydides.core.annotations.Step;

import static com.youngliving.constants.Constants.*;
import static com.youngliving.model.AuthenticationKey.Builder.anAuthenticationKey;
import static com.youngliving.model.Color.*;
import static com.youngliving.utilities.utils.format;
import static net.serenitybdd.rest.SerenityRest.lastResponse;

public class Post implements Interaction {

    private final Shipment shipment;

    public Post(Shipment shipment) {

        this.shipment = shipment;
    }

    public static Performable ProStarShipmentsSHIPPED(Shipment shipment) {
        return Instrumented.instanceOf(Post.class)
                .withProperties(shipment);
    }

    @Override
    @Step("{0} Calls method POST and Body")
    public <T extends Actor> void performAs(T actor) {

        postProStarShipmentsSHIPPED();
    }

    private void postProStarShipmentsSHIPPED() {

        AuthenticationKey authenticationKey = anAuthenticationKey()
                .withMethod(POST_METHOD)
                .withPath("/erp/shipmentshipped")
                .build();

        SerenityRest
                .given()
                .header(AUTHENTICATION_KEY, PUBLIC_KEY_PRO_STAR + ":" + authenticationKey.getHash())
                .header(TIMESTAMP_KEY, authenticationKey.getEpoch())
                .header(CONTENT_TYPE_KEY, CONTENT_TYPE_VALUE)
                .header(ACCEPT_KEY, ACCEPT_VALUE)
                .contentType(CONTENT_TYPE)
                .body(shipment)
                .when().post(authenticationKey.getPath());
        //.then().statusCode(200)
        //.and().body("success", is(true));

        int statusCode = lastResponse().statusCode();
        System.out.println(BLUE + INDENTATION + "POST ProStarShipmentsSHIPPED Status Code: " + RESET + statusCode);
        format(lastResponse().body().asPrettyString());

        if (statusCode != 200) {
            System.exit(1);
        }
    }
}
