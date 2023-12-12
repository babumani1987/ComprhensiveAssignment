Feature: Implement mini project using Gherikin language

  @herokuapp
    Scenario: Herokuapp automation
    Given Open the browser
  Given launch the url below
  |http://the-internet.herokuapp.com/|
  Then verify the page title
  When click on AB testing link
  Then verify the below text on the page
  |A/B Test Variation 1|
  When navigate back to the home page
  And click on the dropdown link
  And select option1 value from the drop down
  Then verify option1 value is selected
  When navigate back to the home page
  When click on frames
  Then verify the below hyperlinks are presented in the framespage
  |Nested Frames|iFrame|
