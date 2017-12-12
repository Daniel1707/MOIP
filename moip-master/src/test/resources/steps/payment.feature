Feature:  Payment
This examples show hot to create and manipulate Payment

Scenario: Create Payment
    Given i want to create a payment
    When i fill the field order_id and all the required fields
    Then the payment will be sent

Scenario: Show Payment
    Given i want to see a payment
    When i fill the field payment_id
    Then the payment will be show