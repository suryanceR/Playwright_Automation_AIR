Feature: E-Commerce Product Flow

Scenario: Login And Add Product

Given User prepares login payload
When User sends login request
And User adds a product
Then Product should be created successfully