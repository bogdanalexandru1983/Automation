Feature: Sign In Tests
  Scenario: Test Open Home Page and goes on Sign In Page
    Given Home Page: Customer opens home page
#    And Home Page: Customer clicks on StayOnTheUsSite
    And close modal
    And Home Page: Customer clicks on Cookies Banner
    When Home Page: Customer clicks sign in button
    Then Sign in Page: Customer is redirected to sign in page