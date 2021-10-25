package fulfillment.actions;

import fulfillment.constants.Constants;
import fulfillment.model.AuthenticationKey;
import fulfillment.model.Color;
import fulfillment.model.Shipment;
import fulfillment.utilities.utils;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;
import net.thucydides.core.annotations.Step;

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

        AuthenticationKey authenticationKey = AuthenticationKey.Builder.anAuthenticationKey()
                .withMethod(Constants.POST_METHOD)
                .withPath("/erp/shipmentshipped")
                .build();

        SerenityRest
                .given()
                .header(Constants.AUTHENTICATION_KEY, Constants.PUBLIC_KEY_PRO_STAR + ":" + authenticationKey.getHash())
                .header(Constants.TIMESTAMP_KEY, authenticationKey.getEpoch())
                .header(Constants.CONTENT_TYPE_KEY, Constants.CONTENT_TYPE_VALUE)
                .header(Constants.ACCEPT_KEY, Constants.ACCEPT_VALUE)
                .contentType(Constants.CONTENT_TYPE)
                .body(shipment)
                .when().post(authenticationKey.getPath());


        int statusCode = lastResponse().statusCode();
        System.out.println(Color.BLUE + Constants.INDENTATION + "POST ProStarShipmentsSHIPPED Status Code: " + Color.RESET + statusCode);
        utils.format(lastResponse().body().asPrettyString());

        if (statusCode != 200) {
            System.exit(1);
        }
    }
}
