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
import ndrcApplication.pages.{amendCaseRefNoPage, commonPage, customsDutyPage}

class CommonSteps extends ScalaDsl with EN {

  Then("""^I am on "([^"]*)" page$""") { pageTitle: String =>
    assert(commonPage.isPageTitleDisplayed(pageTitle))
  }

  When("""^I click on the "([^"]*)" button$"""){ (continue: String) =>
    commonPage.clickOnContinueBtn()
  }

  Then("^An error message is displayed- Error: \"([^\"]*)\"$"){ (errorMsg: String) =>
    amendCaseRefNoPage.errMsg
  }

  Then("^I clear the reference no field$"){ () =>
    amendCaseRefNoPage.clearRefNo
  }

  And("^Hint text is displayed \"([^\"]*)\"$"){ (hintText: String) =>
    customsDutyPage.hintText
  }

  Then("^I Accept cookies and hide message$") { () =>
    commonPage.acceptCookies()
    commonPage.hideCookiesMsg()
  }

}
