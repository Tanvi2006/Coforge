Feature: make sure that the API’s are fit for purpose in the use of the Latest exchange rate for financial reasons

Scenario: Check the success of the latest Exchange API
Given Rates API for Latest Foreign Exchange rates
When The API is available
Then An automated test suite should run which will assert the success status of the response

Scenario: Check the success of the latest Exchange API
Given Rates API for Latest Foreign Exchange rates
When The API is available
Then An automated test suite should run which will assert the response

Scenario: Check the success of the latest Exchange API
Given Rates API for Latest Foreign Exchange rates
When An incorrect or incomplete url is provided "https://api.ratesapi.io/api/"
Then Test case should assert the correct response supplied by the call

