@All @Login

  Feature: Login Scenarios Feature

    Scenario Outline: Successful Login with email Scenario
      When Navigate to login page
      And fill email field with "<email>"
      And fill password field with "<password>"
      And click sign in button
      Then verify invalid credentials warning not appears

      Examples:
        | email             | password   |
        | fixed@fixed.com   | Mert1994*  |

      #alttaki test fail alıyor çünkü yeni pencereye geçiş yapamıyorum
   # Scenario Outline: Successful Login with Google Scenario
    #  When Navigate to login page
     # And fill "<email>" email and "<password>" password fields on Google Login

    #  Examples:
     #   | email                | password   |
     #   | mert@talentrank.ai   | Mert1994*  |

    Scenario Outline: Unsuccessful Login Invalid password Scenario
      When Navigate to login page
      And fill email field with "<email>"
      And fill password field with "<password>"
      And click sign in button
      Then verify invalid credentials warning appears

      Examples:
        | email             | password     |
        | fixed@fixed.com   | Mert1993*    |

   Scenario Outline: Check Login page browser title
     When Navigate to signup page
     And click Have an Account Sign In button
     Then verify browser URL is "<browserUrl>" on login page

     Examples:
       | browserUrl                                         |
       | https://talentrank-corporate.vercel.app/tr/login   |

    Scenario Outline: Unsuccessful Login Invalid email Scenario
      When Navigate to login page
      And fill email field with "<email>"
      And fill password field with "<password>"
      And click sign in button
      Then verify invalid credentials warning appears

      Examples:
        | email              | password     |
        | fixed1@fixed.com   | Mert1993*    |

    Scenario Outline: Check empty email warning
      When Navigate to login page
      And fill password field with "<password>"
      And click sign in button
      Then verify empty email warning appears

      Examples:
        | password     |
        | Mert1994*    |

    Scenario Outline: Check empty password warning
      When Navigate to login page
      And fill email field with "<email>"
      And click sign in button
      Then verify empty password warning appears

      Examples:
        | email              |
        | fixed@fixed.com    |

    Scenario: Check both empty password and email warning
      When Navigate to login page
      And click sign in button
      Then verify empty email warning appears
      Then verify empty password warning appears

    Scenario Outline: Check invalid email format warning
      When Navigate to login page
      And fill email field with "<email>"
      Then verify invalid email format warning appears
      When fill password field with "<password>"
      And click sign in button
      Then verify invalid email format warning appears

      Examples:
        | email             | password     |
        | fixed@.com        | Mert1993*    |
        | fixed@asd.        | Mert1993*    |
        | fixed@asdcom      | Mert1993*    |

    Scenario Outline: Check 6 digits password warning
      When Navigate to login page
      And fill email field with "<email>"
      When fill password field with "<password>"
      Then verify 6 digits password warning appears
      And click sign in button
      Then verify 6 digits password warning appears

      Examples:
        | email             | password     |
        | fixed@fixed.com   | Mer          |
        | fixed@fixed.com   | Mert         |
        | fixed@fixed.com   | Mert1        |