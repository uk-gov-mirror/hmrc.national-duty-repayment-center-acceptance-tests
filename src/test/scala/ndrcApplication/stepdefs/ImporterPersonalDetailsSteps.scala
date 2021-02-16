/*
 * Copyright 2021 HM Revenue & Customs
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package ndrcApplication.stepdefs

import cucumber.api.scala.{EN, ScalaDsl}
import ndrcApplication.pages.{commonPage, importerPersonalDetailsPage}

class ImporterPersonalDetailsSteps extends importerPersonalDetailsPage with ScalaDsl with EN {

  Then("""^I am on "([^"]*)" page$""") { pageTitle: String =>
    assert(commonPage.isPageTitleDisplayed(pageTitle))
  }

  And("^I enter first \"([^\"]*)\" and last \"([^\"]*)\"$"){ (fName: String, lName: String) =>
    importerPersonalDetailsPage.enterFName(fName)
    importerPersonalDetailsPage.enterLName(lName)

  }

  When("""^I click on the "([^"]*)" button$""") {
    commonPage.clickOnContinueBtn()
  }

  Then("""^I am on "([^"]*)" page$""") { pageTitle: String =>
    assert(commonPage.isPageTitleDisplayed(pageTitle))
  }

  And("^I enter importers \"([^\"]*)\"$") { (postCode: String) =>
    importerPersonalDetailsPage.enterPostCode(postCode)
  }

  When("""^I click on the "([^"]*)" button$""") {
    commonPage.clickOnContinueBtn()
  }

  Then("""^I am on "([^"]*)" page$""") { pageTitle: String =>
    assert(commonPage.isPageTitleDisplayed(pageTitle))
  }

  When("""^I click on the "([^"]*)" button$""") {
    commonPage.clickOnContinueBtn()
  }

  Then("""^I am on "([^"]*)" page$""") { pageTitle: String =>
    assert(commonPage.isPageTitleDisplayed(pageTitle))
  }

  And("^I enter \"([^\"]*)\" importers$") { (phoneNo: String) =>
    importerPersonalDetailsPage.enterPhoneNo(phoneNo)
  }

  When("""^I click on the "([^"]*)" button$""") {
    commonPage.clickOnContinueBtn()
  }

  Then("""^I am on "([^"]*)" page$""") { pageTitle: String =>
    assert(commonPage.isPageTitleDisplayed(pageTitle))
  }

  And("^I choose \"([^\"]*)\" option and enter \"([^\"]*)\"$") { (YorNEmail: String, email: String) =>

    YorNEmail match {
      case "Yes" => optionSelected("#value")
      case "No" => optionSelected("#value-2")
    }

    importerPersonalDetailsPage.enterEmail(email)
  }

  When("""^I click on the "([^"]*)" button$""") {
    commonPage.clickOnContinueBtn()
  }

}