Feature: Sign In Tests

Background: HomePage
  Given Home Page: Customer opens home page
  And Home Page: Customer clicks on StayOnTheUsSite
  And Home Page: Customer clicks on Cookies Banner

  Scenario: Test Open Home Page and goes on Sign In Page
    And Home Page: Customer clicks sign in button
    Then Sign in Page: Customer is redirected to sign in page
    And Sign in Page: Customer fill in the username: 'bogdan.alexandru@pearson.com'
    And Sign in Page: Customer fill in the password: Admin123
    When Sign in Page: Customer clicks sign in button from sign in page
    Then Customer is redirected to home page

   # Scenario: Perform search after a word
      Given Home Page: Customer insert on search bar: math
 #     And Home Page: Customer clicks on enter
      Then Search Page: Customer is redirected to Search page

