Feature: Order
This examples show how to create and manipulate order

Scenario: Create Order
    Given i want an order
    When i fill all required fields and associate a client to order
    Then an order will be created