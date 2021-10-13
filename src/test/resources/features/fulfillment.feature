Feature: Fulfillment Process
  As a YL business,
  I want to process orders using 3PL method and API calls,
  So that I can fulfillment the orders.

  Background:
    Given the environment clone is selected

  Scenario Outline: JDE Fulfillment
    Given I logged into the JDE platform with user v-mauramirez@youngliving.com and password password
    And I verified the creation of the order <order> in the branch 1002
    And I consolidated the order through JDE UI - R5642ASL
    When I pick slip through JDE UI - R55423PL
    And I get shipment information through API calls
    And Creating shipment receipt through API calls
    Then shipping order with tracking number through API calls
    And LOT clean up through JDE UI - R5647132
    And ship confirmation through JDE UI - R5547500
    And obtain order information

    Examples:
      | order     |
      | 161487338 |



  #1. Order Creation Verification:
  #2. Order Consolidate through JDE UI - R5642ASL:
  #3. Pick Slip through JDE UI - R55423PL:
  #4. Get Shipment Information through API Calls:
  #5. Creating Shipment Receipt through API Calls:
  #6. Shipping Order with Tracking Number through API Calls:
  #7. LOT Clean Up through JDE UI:
  #8. SHIP Confirmation through JDE UI - R5547500
