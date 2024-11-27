@All @Signup

  Feature: LSignup Scenarios Feature

    Scenario Outline: Check Signup page browser title
      When Navigate to login page
      And click Don't have an account Sign Up button
      Then verify browser URL is "<browserUrl>" on signup page

      Examples:
        | browserUrl                                          |
        | https://talentrank-corporate.vercel.app/tr/signup   |

