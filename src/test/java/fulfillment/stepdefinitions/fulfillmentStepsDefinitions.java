package fulfillment.stepdefinitions;


import fulfillment.actions.Obtain;
import fulfillment.constants.Constants;
import fulfillment.model.Color;
import fulfillment.model.Lot;
import fulfillment.questions.Status;
import fulfillment.tasks.*;
import fulfillment.utilities.utils;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;

import static fulfillment.model.Color.RESET;


public class fulfillmentStepsDefinitions {

    @Managed
    WebDriver hisBrowser;

    private Actor actor;
    private String env;
    private String order;
    private String branch;
    private String pullSignal;
    private long startTime;

    private List<Lot> lots = new ArrayList<>();


    @Before
    public void prepareStage() {

        actor = Actor.named("Greg");
        actor.can(BrowseTheWeb.with(hisBrowser));
        System.out.println(Color.YELLOW_BRIGHT + "Prepare Stage Fulfillment" + RESET);
    }

    @Given("^the environment (clone|ext5) is selected$")
    public void the_environment_is_selected(String env) {

        this.env = env;
        String base_url = ("https://api{{env}}.youngliving.com" + Constants.URL).replace("{{env}}", env);
        RestAssured.baseURI = base_url;
    }

    @Given("^I logged into the JDE platform with user (.*) and password (.*)$")
    public void i_logged_into_the_JDE_platform_with_user_and_password(String user, String password) {

        actor.wasAbleTo(Log.intoJDE(env, user, password));
        startTime = System.nanoTime();
        System.out.println(Color.YELLOW_BRIGHT + "0. Log into the JDE platform in " + env.toUpperCase() + RESET);
    }

    @And("^I verified the creation of the order (.*) in the branch (.*)$")
    public void i_verified_the_creation_of_the_order_in_the_branch(String order, String branch) {

        this.order = order;
        this.branch = branch;
        actor.attemptsTo(Verify.theOrderCreated(order, branch));
        System.out.println(Color.YELLOW_BRIGHT + "1. Order creation verification." + RESET);
    }

    @When("^I consolidated the order through JDE UI - (.*)$")
    public void i_consolidated_the_orders_through_the_user_interface_of_JDE(String batchApp) {

        System.out.println(Color.YELLOW_BRIGHT + "2. Order consolidate through JDE UI - R5642ASL" + RESET);
        actor.attemptsTo(Consolidate.theOrder(order, branch, batchApp));
    }

    @When("^I pick slip through JDE UI - (.*)$")
    public void i_pick_slip_through_JDE_UI(String batchApp) {

        System.out.println(Color.YELLOW_BRIGHT + "3. Pick slip through JDE UI - R55423PL" + RESET);
        actor.attemptsTo(Pick.slip(order, branch, batchApp));
        pullSignal = Status.getPullSignal();

        lots = Status.getLots();

        actor.attemptsTo(Complete.theLotSerials(branch, lots));
        System.out.println((Color.BLUE + Constants.INDENTATION + "Pull Signal:    " + RESET + pullSignal));
    }

    @And("^I get shipment information through API calls$")
    public void i_get_shipment_information_through_API_calls() {

        System.out.println(Color.YELLOW_BRIGHT + "4. I get shipment information through API calls" + RESET);
        actor.attemptsTo(Find.shipmentInformation(pullSignal));
    }


    @And("^Creating shipment receipt through API calls$")
    public void creating_shipment_receipt_through_API_calls() {

        System.out.println(Color.YELLOW_BRIGHT + "5. Creating shipment receipt through API calls" + RESET);
        actor.attemptsTo(Create.shipmentReceipt(pullSignal, Find.getLineItems(), Find.getMsgDateTime(), Find.getShipMethod(), lots));
    }


    @Then("^shipping order with tracking number through API calls$")
    public void shipping_order_with_tracking_number_through_API_calls() {

        System.out.println(Color.YELLOW_BRIGHT + "6. Shipping Order with Tracking Number through API calls" + RESET);
        actor.attemptsTo(Ship.orderWithTrackingNumber(Create.getShipment()));
    }

    @Then("^LOT clean up through JDE UI - (.*)$")
    public void lot_clean_up_through_JDE_UI(String batchApp) {

        System.out.println(Color.YELLOW_BRIGHT + "7. LOT clean up through JDE UI - R5647132" + RESET);
        actor.attemptsTo(Clean.lotThrough(pullSignal, batchApp));
    }


    @And("^ship confirmation through JDE UI - (.*)$")
    public void ship_confirmation_through_JDE_UI(String batchApp) {

        System.out.println(Color.YELLOW_BRIGHT + "8. SHIP confirmation through JDE UI - R5547500" + RESET);
        actor.attemptsTo(Confirmation.shipment(pullSignal.substring(0, 9), batchApp));

    }

    @And("^obtain order information$")
    public void obtain_order_information() {

        System.out.println(Color.YELLOW_BRIGHT + "9. Obtain order information" + RESET);
        utils.wait(9001);
        actor.attemptsTo(Obtain.theOrderInformation(order, branch));
        actor.should(GivenWhenThen.seeThat("Next Status: " + "620", Status.value()));
    }


    @After
    public void endStage() {

        long endTime = System.nanoTime() - startTime;
        double seconds = (double) Long.parseLong(String.valueOf(endTime)) / 1000000000.0;
        System.out.println(Color.YELLOW_BRIGHT + "End Stage: " + seconds + RESET);
        System.out.println("End Stage: " + seconds);
    }
}
