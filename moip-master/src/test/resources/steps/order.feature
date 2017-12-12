Feature: Order
This examples show how to create and manipulate order

Scenario: Create Order
    Given i want to create an order
    When i fill all required fields and associate a client to order
    Then an order will be created
    
Scenario: Show Order
    Given i want to show an order
    When i fill the order_id
    Then the order will be show