package fulfillment.tasks;

import fulfillment.actions.Get;
import fulfillment.actions.Put;
import fulfillment.model.LineItem;
import fulfillment.model.ShipmentInformation;
import fulfillment.model.ShipmentToShip;
import fulfillment.questions.Status;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.thucydides.core.annotations.Step;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static fulfillment.constants.Constants.INDENTATION;
import static fulfillment.model.Color.BLUE;
import static fulfillment.model.Color.RESET;
import static fulfillment.utilities.utils.format;
import static net.serenitybdd.rest.SerenityRest.lastResponse;


public class Find implements Task {

    private final String pullSignal;

    private static List<LineItem> lineItems;
    private static String msgDateTime;
    private static String shipMethod;

    public Find(String pullSignal) {

        this.pullSignal = pullSignal;
    }

    public static Performable shipmentInformation(String pullSignal) {
        return Instrumented.instanceOf(Find.class)
                .withProperties(pullSignal);
    }

    public static List<LineItem> getLineItems() {

        return lineItems;
    }


    public static String getMsgDateTime() {

        return msgDateTime;
    }


    public static String getShipMethod() {

        return shipMethod;
    }


    @Override
    @Step("{0} gets shipment information through API Calls")
    public <T extends Actor> void performAs(T actor) {

        int i = 0;

        do {
            actor.attemptsTo(Get.ProStarWH85Shipment(pullSignal));
            int findPullSignal = lastResponse().jsonPath().getInt("ShipmentsToShip.findAll {it.ShipmentId  ==" + pullSignal + "}.size()");

            if (findPullSignal > 0) {
                getShipmentInformation(pullSignal);
                break;
            } else {
                String batchId = lastResponse().jsonPath().getString("ShipmentsToShip[0].BatchId");
                if (batchId == null || batchId.length() == 0) {

                    format(lastResponse().body().asPrettyString());
                    //System.exit(1);
                    actor.should(GivenWhenThen.seeThat("", Status.valueFalse()));
                } else {
                    System.out.println(INDENTATION + BLUE + "BatchId: " + RESET + batchId);
                    actor.attemptsTo(Put.ProStarReceiptShipments(batchId));
                }
            }
            i++;
        } while (i < 2);
    }


    private static void getShipmentInformation(String pullSignal) {

        ShipmentInformation shipmentInformation = lastResponse().as(ShipmentInformation.class);
        List<ShipmentToShip> shipmentsToShip = Arrays.asList(shipmentInformation.getShipmentsToShip());

        List<ShipmentToShip> shipmentsToShipFilter = shipmentsToShip.stream()
                .filter(e -> e.getShipmentId().equals(pullSignal))
                .collect(Collectors.toList());

        lineItems = Arrays.asList(shipmentsToShipFilter.get(0).getLineItems());
        msgDateTime = shipmentsToShipFilter.get(0).getContractDate();
        shipMethod = shipmentsToShipFilter.get(0).getShipMethod();
    }
}
