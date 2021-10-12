package fulfillment.tasks;

import fulfillment.actions.Post;
import fulfillment.model.Shipment;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.thucydides.core.annotations.Step;

public class Ship implements Task {

    private final Shipment shipment;

    public Ship(Shipment shipment) {
        this.shipment = shipment;
    }

    public static Performable orderWithTrackingNumber(Shipment shipment) {
        return Instrumented.instanceOf(Ship.class)
                .withProperties(shipment);
    }

    @Override
    @Step("{0} Ships Order with Tracking Number through API Calls")
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(Post.ProStarShipmentsSHIPPED(shipment));
    }
}
