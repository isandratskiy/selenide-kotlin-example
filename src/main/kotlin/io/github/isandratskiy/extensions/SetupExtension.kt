package io.github.isandratskiy.extensions

import com.codeborne.selenide.Selenide.*
import com.codeborne.selenide.WebDriverRunner.*
import com.codeborne.selenide.logevents.SelenideLogger.*
import io.github.isandratskiy.driver.DriverFactory.Companion.createDriverInstance
import io.qameta.allure.selenide.AllureSelenide
import org.junit.jupiter.api.extension.*

class SetupExtension : BeforeEachCallback, AfterEachCallback {

    override fun beforeEach(context: ExtensionContext?) {
        addListener("allure", AllureSelenide().screenshots(true).savePageSource(false))
        createDriverInstance()
        open("https://the-internet.herokuapp.com")
    }

    override fun afterEach(context: ExtensionContext?) {
        getWebDriver().quit()
    }
}