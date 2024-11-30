@All @Signup

  Feature: Signup Scenarios Feature

    Scenario Outline: Check Signup page URL
      When Navigate to login page
      And click Don't have an account Sign Up button
      Then verify browser URL is "<browserUrl>" on signup page

      Examples:
        | browserUrl                                          |
        | https://talentrank-corporate.vercel.app/tr/signup   |

    Scenario Outline: Check empty Name warning
      When Navigate to signup page
      And fill password field with "<password>" on signup page
      And fill email field with "<email>" on signup page
      And click sign up button
      Then verify empty name warning appears on signup page

      Examples:
        | email              | password     |
        | email1@ghjk.com    | password_01  |

    Scenario Outline: Check empty email warning
      When Navigate to signup page
      And fill password field with "<password>" on signup page
      And fill name field with "<name>" on signup page
      And click sign up button
      Then verify empty email warning appears on signup page

      Examples:
        |  name              | password     |
        |  name_01           | password_02  |

    Scenario Outline: Check empty password warning
      When Navigate to signup page
      And fill name field with "<name>" on signup page
      And fill email field with "<email>" on signup page
      And click sign up button
      Then verify empty password warning appears on signup page

      Examples:
        |  email              | name         |
        | email2@ghjk.com     | name_02      |

    Scenario Outline: Check 6 digits password warning
      When Navigate to signup page
      And fill name field with "<name>" on signup page
      And fill email field with "<email>" on signup page
      And fill password field with "<password>" on signup page
      And click sign up button
      Then verify 6 digits password warning appears on signup page

      Examples:
        |  name              | password     |   email            |
        |  name_03           | p            | email3@ghjk.com    |
        |  name_04           | pas          | email4@ghjk.com    |
        |  name_05           | passw        | email5@ghjk.com    |

   Scenario Outline: Check invalid email format warning
     When Navigate to signup page
     And fill name field with "<name>" on signup page
     And fill email field with "<email>" on signup page
     And fill password field with "<password>" on signup page
     And click sign up button
     Then verify invalid email format warning appears on signup page

     Examples:
       |  name              | password         |   email           |
       |  name_03           | password_03      | emai@.ai          |
       |  name_04           | password_04      | email4@ghjk.      |
       |  name_05           | password_05      | email5@ghjkcom    |
       |  name_05           | password_05      | email5ghjk.com    |

   Scenario Outline: Check company domain exist warning
     When Navigate to signup page
     And fill name field with "<name>" on signup page
     And fill email field with "<email>" on signup page
     And fill password field with "<password>" on signup page
     And click sign up button
     Then verify company domain exist warning appears

     Examples:
       |  email                 | password         |   name           |
       |  fixed@fixed.com       | password_03      | name_06          |

   Scenario Outline: Check empty warning on second window of the signup page
     When Navigate to signup page
     And fill name field with "<name>" on signup page
     And fill email field with "<email>" on signup page
     And fill password field with "<password>" on signup page
     And click sign up button
     And clear the text of company name field
     And click All Good button
     Then verify empty company name warning appears on signup page
     And verify empty workspace name warning appears on signup page
     And verify empty company size warning appears on signup page
     And verify empty location warning appears on signup page

     Examples:
       |  email                  | password         |   name           |
       |  fixed@fm00.com         | password_04      | name_07          |

   Scenario Outline: Check company domain reflects as company name
     When Navigate to signup page
     And fill name field with "<name>" on signup page
     And fill email field with "<email>" on signup page
     And fill password field with "<password>" on signup page
     And click sign up button
     Then verify company name is extracted from "<email>" email

     Examples:
       |  email                  | password         |   name           |
       |  fixed@fn00.com         | password_04      | name_07          |