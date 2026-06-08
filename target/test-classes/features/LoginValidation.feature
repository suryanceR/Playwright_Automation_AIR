Feature: Login Validation

Scenario Outline: Login Validation - <testDataFile>

Given User loads "<testDataFile>"
When User sends login request using loaded payload
Then Login status code should be <statusCode>

Examples:
| testDataFile      | statusCode |
| positive          | 200 |
| invalidPassword   | 400 |
| invalidEmail      | 400 |
| invalidBoth       | 400 |
| emptyEmail        | 400 |