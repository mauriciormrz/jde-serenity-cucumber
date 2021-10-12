package fulfillment.actions;

import fulfillment.model.AuthenticationKey;
import fulfillment.constants.Constants;
import fulfillment.model.Color;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;
import net.thucydides.core.annotations.Step;

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

        AuthenticationKey authenticationKey = AuthenticationKey.Builder.anAuthenticationKey()
                .withMethod(Constants.PUT_METHOD)
                .withPath("/erp/shipmentreceived/" + batchId + "/100200080")
                .build();

        SerenityRest
                .given()
                .header(Constants.AUTHENTICATION_KEY, Constants.PUBLIC_KEY_PRO_STAR + ":" + authenticationKey.getHash())
                .header(Constants.TIMESTAMP_KEY, authenticationKey.getEpoch())
                .header(Constants.CONTENT_TYPE_KEY, Constants.CONTENT_TYPE_VALUE)
                .header(Constants.ACCEPT_KEY, Constants.ACCEPT_VALUE)
                .contentType(Constants.CONTENT_TYPE)
                //.and().pathParam("batchId", batchId)
                .when().put(authenticationKey.getPath());
        //.then().statusCode(200);

        int statusCode = lastResponse().statusCode();
        System.out.println(Color.BLUE + Constants.INDENTATION + "PUT ProStarReceiptShipments " + Color.RESET + "Status Code: " + statusCode);

    }
}
