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
import ndrcApplication.pages.{commonPage, otherCustDutyPage }

class OtherCustDutySteps extends otherCustDutyPage with ScalaDsl with EN {

  Then("""^I am on "([^"]*)" page$""") { pageTitle: String =>
    assert(commonPage.isPageTitleDisplayed(pageTitle))
  }

  And("""^I enter other custom Duty paid- OtherCustDutyPaid: "([^"]*)"$"""){  (otherCustDutyPaid: String) =>
    otherCustDutyPage.enterOtherCustDutyPaid(otherCustDutyPaid)
  }

  When("""^I click on the "([^"]*)" button$""") {
    commonPage.clickOnContinueBtn()
  }

  Then("""^I am on "([^"]*)" page$""") { pageTitle: String =>
    assert(commonPage.isPageTitleDisplayed(pageTitle))
  }

  And("""^I enter other custom Duty been paid to HMRC- OtherCustDutyBeenPaid: "([^"]*)"$""") { (otherCustDutyBeenPaid: String) =>
    otherCustDutyPage.enterOtherCustDutyBeenPaid(otherCustDutyBeenPaid)
  }

  When("""^I click on the "([^"]*)" button$""") {
    commonPage.clickOnContinueBtn()
  }

}