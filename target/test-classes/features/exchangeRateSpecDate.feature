Feature: make sure that the API’s are fit for purpose in the use of the Specific Date exchange rate for financial reasons

Scenario: Check the success of the latest Exchange API
Given Rates API for Specific date Foreign Exchange rates
When The API is available2
Then An automated test suite should run which will assert the success status of the response2

Scenario: Check the success of the latest Exchange API
Given Rates API for Specific date Foreign Exchange rates
When The API is available2
Then An automated test suite should run which will assert the response2

Scenario: Check the success of the latest Exchange API
Given Rates API for Specific date Foreign Exchange rates
When A future date is provided in the url "2020-12-14"
Then An automated test suite should run which will validate that the response matches for the current date "2020-12-14"
