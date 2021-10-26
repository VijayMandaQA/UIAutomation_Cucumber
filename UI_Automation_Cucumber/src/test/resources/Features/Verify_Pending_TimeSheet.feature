@Timesheet
Feature: This feature is to get pending timesheet
Scenario Outline: This is to test to verify the pending timesheet
Given the user is on the Home Page
When the user clicks on the time option from the menu
And the user enters the name as "John Smith"
And clicks on the view button
Then the user should see the message as "<message>"

Examples:
|message|
|No Timesheets Found|