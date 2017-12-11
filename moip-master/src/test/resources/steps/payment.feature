Feature:  Client
This examples show hot to create and manipulate client

Scenario: Create Client
    Given i want to create a payment
    When i fill the field order_id and all the required fields
    Then the payment will be sent