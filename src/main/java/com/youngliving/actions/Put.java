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
import static net.serenitybdd.rest.SerenityRest.lastResponse;

public class Put implements Interaction {

    private final String batchId;

    public Put(String batchId) {

        this.batchId = batchId;
    }

    public static Performable ProStarReceiptShipments(String batchId) {
        return Instrumented.instanceOf(Put.class)
                .withProperties(batchId);
    }

    @Override
    @Step("{0} Calls method PUT and BatchId #batchId")
    public <T extends Actor> void performAs(T t) {

        putProStarReceiptShipments(batchId);
    }

    private void putProStarReceiptShipments(String batchId) {

        AuthenticationKey authenticationKey = anAuthenticationKey()
                .withMethod(PUT_METHOD)
                .withPath("/erp/shipmentreceived/" + batchId + "/100200080")
                .build();

        SerenityRest
                .given()
                .header(AUTHENTICATION_KEY, PUBLIC_KEY_PRO_STAR + ":" + authenticationKey.getHash())
                .header(TIMESTAMP_KEY, authenticationKey.getEpoch())
                .header(CONTENT_TYPE_KEY, CONTENT_TYPE_VALUE)
                .header(ACCEPT_KEY, ACCEPT_VALUE)
                .contentType(CONTENT_TYPE)
                //.and().pathParam("batchId", batchId)
                .when().put(authenticationKey.getPath());
        //.then().statusCode(200);

        int statusCode = lastResponse().statusCode();
        System.out.println(BLUE + INDENTATION + "PUT ProStarReceiptShipments " + RESET + "Status Code: " + statusCode);

    }
}
