Feature: Fill New Address Form

  Scenario Outline: Fill the adderss form with valid data
    Given I am logged into the application
    When I navigate to the new address form
    And I fill the form with the following data

      |  alias  |  address  |  city  |  postalCode  |  country  |  phone  |
      | <alias> | <address> | <city> | <postalCode> | <country> | <phone> |

    Examples:
      | alias | address    | city    | postalCode  | country  | phone     |
      | Kusi  | Zwyciestwa | Gliwice | 44-100      | Poland   | 604604604 |