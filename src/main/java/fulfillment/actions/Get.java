package fulfillment.actions;

import fulfillment.model.AuthenticationKey;
import fulfillment.constants.Constants;
import fulfillment.model.Color;
import fulfillment.utilities.utils;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;
import net.thucydides.core.annotations.Step;

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

        AuthenticationKey authenticationKey = AuthenticationKey.Builder.anAuthenticationKey()
                .withMethod(Constants.GET_METHOD)
                .withPath("/100")
                .build();

        SerenityRest.given()
                .header(Constants.AUTHENTICATION_KEY, Constants.PUBLIC_KEY_PRO_STAR + ":" + authenticationKey.getHash())
                .header(Constants.TIMESTAMP_KEY, authenticationKey.getEpoch())
                .header(Constants.ACCEPT_KEY, Constants.ACCEPT_VALUE)
                .header(Constants.ACCEPT_KEY, Constants.ACCEPT_VALUE)
                .contentType(Constants.CONTENT_TYPE)
                .when().get(authenticationKey.getPath());

        int statusCode = lastResponse().statusCode();
        System.out.println(Color.BLUE + Constants.INDENTATION + "GET ProStarWH85Shipments    " + Color.RESET + "Status Code: " + statusCode);

        //if (statusCode != 200) {
        utils.format(lastResponse().body().asPrettyString());
        //}
    }
}
