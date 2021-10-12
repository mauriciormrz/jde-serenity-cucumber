package fulfillment.tasks;


import fulfillment.model.*;
import fulfillment.utilities.utils;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.thucydides.core.annotations.Step;

import java.util.ArrayList;
import java.util.List;

import static fulfillment.constants.Constants.INDENTATION;
import static fulfillment.model.Color.BLUE;
import static fulfillment.model.Color.RESET;
import static fulfillment.model.Item.Builder.anItem;
import static fulfillment.model.ShipmentDetails.Builder.aShipmentDetails;

public class Create implements Task {

    private final String pullSignal;
    private final List<LineItem> lineItems;
    private final String msgDateTime;
    private final String shipMethod;
    private final List<Lot> lots;

    private static Shipment shipment;

    public Create(String pullSignal, List<LineItem> lineItems, String msgDateTime, String shipMethod, List<Lot> lots) {

        this.pullSignal = pullSignal;
        this.lineItems = lineItems;
        this.msgDateTime = msgDateTime;
        this.shipMethod = shipMethod;
        this.lots = lots;
    }

    public static Performable shipmentReceipt(String pullSignal, List<LineItem> lineItems, String msgDateTime, String shipMethod, List<Lot> lots) {
        return Instrumented.instanceOf(Create.class)
                .withProperties(pullSignal, lineItems, msgDateTime, shipMethod, lots);
    }

    public static Shipment getShipment() {

        return shipment;
    }

    @Override
    @Step("{0} Creates Shipment Receipt through API Calls")
    public <T extends Actor> void performAs(T actor) {

        List<Item> itemList = new ArrayList<>();

        for (LineItem e : lineItems) {
            String lotNumber = "";

            for (Lot l : lots) {
                if (l.getPartNumber().equals(e.getPartNumber())) {
                    lotNumber = l.getLotNumber();
                    break;
                }
            }

            Item newItem = anItem()
                    .withOrderId(e.getOrderId())
                    .withOrderLineNumber(e.getLineNumber())
                    .withPartNumber(e.getPartNumber())
                    .withTrackingNo("TN" + pullSignal)
                    .withQtyOrdered(e.getQuantity())
                    .withQtyShipped(e.getQuantity())
                    .withReasonCode("")
                    .withShipDateTime(msgDateTime)
                    .withLotNumber(lotNumber)
                    .build();
            itemList.add(newItem);
        }

        Item[] itemArray = new Item[itemList.size()];
        itemArray = itemList.toArray(itemArray);

        ShipmentDetails newShipmentDetails = aShipmentDetails()
                .withShipmentId(pullSignal)
                .withShipMethod(shipMethod)
                .withShipCarrier("")
                .withTotalWeight(2)
                .withFreightCharges(12)
                .withQtyPackages(1)
                .withWeightUoM("LB")
                .withCurrCode("USD")
                .withItemDetails(itemArray)
                .build();

        ShipmentDetails[] shipmentDetails = new ShipmentDetails[1];
        shipmentDetails[0] = newShipmentDetails;

        shipment = Shipment.Builder.aShipment()
                .withMsgDateTime(msgDateTime)
                .withSender("1002")
                .withReceiver("1001")
                .withShipmentDetails(shipmentDetails)
                .build();

        System.out.println(INDENTATION + BLUE + "Body Created" + RESET);
        utils.print(shipment);
    }
}
