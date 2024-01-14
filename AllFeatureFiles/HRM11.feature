Feature: Test Orange HRM

  Scenario: Test Login Page Functionality
    Given User is on Login Page
    When User Enters Valid Credentials
      | Admin | admin123 |
    And User click on login button

  #Scenario: Test Home Page Functionality
  #When User is on Home Page validate home page title
  #	| OrangeHRM |
  Scenario: Test PIM Page Functionality
    When user click on PIM page link
    And user click on add employee ,and enter firatname , lastname and click on save button and user copy empid and click on employee list button and enter empid in empid text box and click on search and user click on bin symbol button and delete the employee
      | Anish | Patil |
      | Abhir | Patil |
      | Arjun | Patil |

  Scenario: User Logout
    When user click on Account dropdown and click on logout
