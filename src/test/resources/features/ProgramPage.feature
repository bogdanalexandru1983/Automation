Feature: product test
  Background: Customer open the page and close the location pop up and banner
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

    Given Home Page: Customer insert on search bar: Positive and Negative Syndrome Scale
    Then Program Page: Customer is redirected to the product page for Positive and Negative Syndrome Scale
    And Program Page: Customer click on 'All products' card type
    Then Program Page: Customer click on Add to cart button for product 'A103000066634'
    And small cart page is opened
    And Customer click on view cart

  #  And Cart Page: Customer click delete product 'A103000066634' from cart
    And Cart Page: Check save cart button is enabled
    And Cart Page: Update quantity for product 'A103000066631' with value '5'


    #A103000066634

