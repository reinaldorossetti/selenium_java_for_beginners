#language: en

@example
Feature: Learning to use selenium with java 
As a QA
I want to learn how to use selenium 
To be able to automate applications 


Scenario: Validate texts 1 in concrete.com.br website
Given I am on the page
When I fill in the text field with "Concrete"
Then I checked if the text "Concrete" was successfully validated

Scenario: Validate texts 2 in concrete.com.br website
Given I am on the page
When I fill in the text field with "CONCRETE"
Then I checked if the text "CONCRETE" was successfully validated
