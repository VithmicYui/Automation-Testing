@AssignmentFinal
Feature: Create Automation Scrip to verify eCart app

  Background: Set up eCart app
    Given Open eCart App

  @eCart_TC_01
  Scenario: Verify Home screen
    Then the welcome screen should display

  @eCart_TC_02
  Scenario: Verify Category screen
    And Navigate to "Get Started" screen
    Then The Default Delivery Location screen display
    And Select "All" location
    And Click to Category menu item
    Then The Category screen display 6 categories

  @eCart_TC_03
  Scenario: Verify number of product of Fresh Vegetables
    And Navigate to "Get Started" screen
    Then The Default Delivery Location screen display
    And Select "All" location
    And Scroll to Fresh Vegetables
    And Click to View All Fresh Vegetables
    Then the Fresh Vegetables category should be displayed with 3 products
    And the Fresh Vegetables screen should be displayed with 10 products

  @eCart_TC_04
  Scenario: Verify Product Detail screen
    And Navigate to "Get Started" screen
    Then The Default Delivery Location screen display
    And Select "All" location
    And Scroll to Coffee
    And Click to View All Coffee
    And Click to "High Octane Instant Coffee..."
    Then the product detail screen should be displayed

  @eCart_TC_05
  Scenario: Verify Card screen
    And Navigate to "Get Started" screen
    Then The Default Delivery Location screen display
    And Select "All" location
    And Click to Category menu item
    And Click to Fast Food
    And Click "Add to Cart" with Quantity = 2 of "Kurkure Namkeen - Masala Munch" product
    And Click to Cart icon on top screen
    And Select 370405 location
    Then the Cart should be displayed

  @eCart_TC_06
  Scenario: Verify Payment screen
    And Navigate to "Get Started" screen
    Then The Default Delivery Location screen display
    And Select "All" location
    And Click to Category menu item
    And Click to Beverages
    And Click "Add to Cart" with Quantity = 2 of "Sunfeast Dark Fantasy Choco Fills, 600g" product of Beverages
    And Click to Cart icon on top screen
    And Select 370001 location of Payment
    And Click to CONTINUE button
    And Click to Login button
    And Click to CONTINUE button
    And Click to CONTINUE button
    Then the Payment screen should be displayed

  @eCart_TC_07
  Scenario: Verify Profile screen
    And Navigate to "Get Started" screen
    Then The Default Delivery Location screen display
    And Select "All" location
    And Click to Profile on footer menu
    And Click to Welcome Guest
    And Click to Login button
#    And Select "All" location
    And Click again to Profile on footer menu
    Then the Profile screen should be displayed with the user's information and options to manage the profile

