Feature: Upload supporting files
  @suite
  Scenario Outline: Upload supporting files scenarios
    Given I am on the start page for trader service and select Apply Now
    Then I Accept cookies and hide message
    When I click on the "Continue" button
    Then I am on "Are you the importer or their representative? - National Duty Repayment Centre - GOV.UK" page
    And I choose Importer claimant type
    When I click on the "Continue" button
    Then I am on "How many entries do you want to submit? - National Duty Repayment Centre - GOV.UK" page
    And I choose one entry
    When I click on the "Continue" button
    Then I am on "What was the entry acceptance date? - National Duty Repayment Centre - GOV.UK" page
    And I choose a date Range on or before Dec
    When I click on the "Continue" button
    Then I am on "Why are you applying for this repayment? - National Duty Repayment Centre - GOV.UK" page
    And I choose a repayment Type
    When I click on the "Continue" button
    Then I am on "Entry details - National Duty Repayment Centre - GOV.UK" page
    And I enter declaration details- EPU: "345" and Entry No: "123456t"
    And I enter entryDate- Day: "08", Month: "12" and Year: "2019"
    When I click on the "Continue" button
    Then I am on "What does your application relate to? - National Duty Repayment Centre - GOV.UK" page
    And I choose an application Reason
    When I click on the "Continue" button
    Then I am on "Tell us why the overpayment happened - National Duty Repayment Centre - GOV.UK" page
    And I enter goods details- Details: "Shoes Jeans Jackets"
    When I click on the "Continue" button
    Then I am on "What do you want to reclaim? - National Duty Repayment Centre - GOV.UK" page
    And I choose customsDuty importVAT anotherTypeofDuty options
    When I click on the "Continue" button
    Then I am on "Customs Duty overpayment - National Duty Repayment Centre - GOV.UK" page
    And I enter customs Duty paid- CustomDuty: "1000.00"
    And I enter customs Duty should have paid to HMRC- CustomsDutyBeenPaid: "750.00"
    When I click on the "Continue" button
    Then I am on "Import VAT overpayment - National Duty Repayment Centre - GOV.UK" page
    And I enter import vat paid- VatPaid: "1500.00"
    And I enter import vat been Paid to HMRC- VatBeenPaid: "500.00"
    When I click on the "Continue" button
    Then I am on "Overpayment of other duties - National Duty Repayment Centre - GOV.UK" page
    And I enter other custom Duty paid- OtherCustDutyPaid: "1250.00"
    And I enter other custom Duty been paid to HMRC- OtherCustDutyBeenPaid: "200.00"
    When I click on the "Continue" button
    Then I am on "Repayment amount summary - National Duty Repayment Centre - GOV.UK" page
    When I click on the "Continue" button
    Then I am on "Supporting documents - National Duty Repayment Centre - GOV.UK" page
    When I click on the "Continue" button
    Then I am on "Upload a file - National Duty Repayment Centre - GOV.UK" page
    When I click on Choose file button and add the "first" file
    When I click on the "Continue" button
    Then I am on "You have uploaded 1 file - National Duty Repayment Centre - GOV.UK" page
    Then I should see first uploaded doc "JPEGImage.jpg" on upload review page
    Then I select "<YorNuploadFile>" to uploading another file
    When I click on the "Continue" button
    #No selection made error message
    Then I am on "Upload another document - National Duty Repayment Centre - GOV.UK" page
    When I click on the "Continue" button
    Then I see an error message "Upload a file to support your application"
    #file error duplicate file upload
    Then I am on "Upload another document - National Duty Repayment Centre - GOV.UK" page
    When I click on Choose file button and add the "first" file
    When I click on the "Continue" button
    Then I see an error message "This file has already been uploaded"
    #upload mutliple files
    When I click on Choose file button and add the "second" file
    When I click on the "Continue" button
    Then I am on "You have uploaded 2 files - National Duty Repayment Centre - GOV.UK" page
    Then I should see first uploaded doc "JPEGImage.jpg" on upload review page
    Then I should see second uploaded doc "VA Plan v0.3.xlsx" on upload review page

    Examples:
      |YorNuploadFile  |
      |Yes             |

  @suite
  Scenario Outline: Upload supporting files scenarios - Amend case journey
    Given I am on the start page for trader service and select Amend Now
    Then I Accept cookies and hide message
    When I click on the "Continue" button
    Then I am on "What is the reference number? - National Duty Repayment Centre - GOV.UK" page
    And I enter valid Application "<referenceNo>"
    When I click on the "Continue" button
    Then I am on "What do you need to do? - National Duty Repayment Centre - GOV.UK" page
    And I choose send more supporting documents
    When I click on the "Continue" button
    Then I am on "Upload a file - National Duty Repayment Centre - GOV.UK" page
    When I click on Choose file button and add the "first" file
    When I click on the "Continue" button
    Then I am on "You have uploaded 1 file - National Duty Repayment Centre - GOV.UK" page
    Then I should see first uploaded doc "JPEGImage.jpg" on upload review page
    Then I select "<YorNuploadFile>" to uploading another file
    When I click on the "Continue" button
    #No selection made error message
    Then I am on "Upload another document - National Duty Repayment Centre - GOV.UK" page
    When I click on the "Continue" button
    Then I see an error message "Upload a file to support your application"
    #file error duplicate file upload
    Then I am on "Upload another document - National Duty Repayment Centre - GOV.UK" page
    When I click on Choose file button and add the "first" file
    When I click on the "Continue" button
    Then I see an error message "This file has already been uploaded"
    #upload mutliple files
    When I click on Choose file button and add the "second" file
    When I click on the "Continue" button
    Then I am on "You have uploaded 2 files - National Duty Repayment Centre - GOV.UK" page
    Then I should see first uploaded doc "JPEGImage.jpg" on upload review page
    Then I should see second uploaded doc "VA Plan v0.3.xlsx" on upload review page


    Examples:
      | referenceNo             | YorNuploadFile  |
      | NDRC2103151135EE6L6YKH3 | Yes             |
