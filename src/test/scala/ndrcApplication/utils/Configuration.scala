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

package ndrcApplication.utils

import java.time.LocalDate
import scala.util.Try

case class Configuration(baseUrl: String, authLogin:String, ndrcApplicationLandingUrl:String, timeout: Int)

object Configuration {

val local_date: LocalDate = Try(LocalDate.parse(System.getProperty("local-date", ""))).getOrElse(LocalDate.now)

  val environment: Environment.Name = {
    val environmentProperty = System.getProperty("environment", "local").toLowerCase
    environmentProperty match {
      case "local" => Environment.local
      case "dev" => Environment.dev
      case "qa" => Environment.qa
      case "staging" => Environment.staging
      case _ => throw new IllegalArgumentException(s"Environment '$environmentProperty' not known")
    }
  }

  lazy val settings: Configuration = create()
  def create(): Configuration = {
    environment match {
      case Environment.dev =>
        new Configuration(
          baseUrl = "www.development.tax.service.gov.uk",
          authLogin = "https://www.development.tax.service.gov.uk/auth-login-stub/gg-sign-in",
          ndrcApplicationLandingUrl="/national-duty-repayment-center/what-do-you-want-to-do",
          timeout = 10
        )
      case Environment.local =>
        new Configuration(
          baseUrl = "http://localhost:9949/",
          authLogin = "http://localhost:9949/auth-login-stub/gg-sign-in",
          ndrcApplicationLandingUrl="http://localhost:8450/national-duty-repayment-center/what-do-you-want-to-do",
          timeout = 10
        )
      case Environment.qa =>
        new Configuration(
          baseUrl = "https://www.qa.tax.service.gov.uk",
          authLogin = "https://www.qa.tax.service.gov.uk/auth-login-stub/gg-sign-in",
          ndrcApplicationLandingUrl="/national-duty-repayment-center/what-do-you-want-to-do",
          timeout = 10
        )
      case Environment.staging =>
        new Configuration(
          baseUrl = "https://www.staging.tax.service.gov.uk",
          authLogin = "https://www.staging.tax.service.gov.uk/auth-login-stub/gg-sign-in",
          ndrcApplicationLandingUrl="/national-duty-repayment-center/what-do-you-want-to-do",
          timeout = 10
        )
      case _ => throw new IllegalArgumentException(s"Environment '$environment' not known")
    }
  }
  object Environment extends Enumeration {
    type Name = Value
    val local, dev, qa, staging = Value
  }
}

