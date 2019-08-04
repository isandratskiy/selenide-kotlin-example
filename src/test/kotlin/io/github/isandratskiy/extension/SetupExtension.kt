package io.github.isandratskiy.extension

import com.codeborne.selenide.WebDriverRunner.*
import com.codeborne.selenide.logevents.SelenideLogger.*
import io.github.isandratskiy.driver.DriverFactory.Companion.createDriverInstance
import org.junit.jupiter.api.extension.*
import io.qameta.allure.selenide.AllureSelenide as Allure

class SetupExtension : BeforeEachCallback, AfterEachCallback {

    override fun beforeEach(context: ExtensionContext?) {
        addListener("allure", Allure().screenshots(true).savePageSource(false))
        createDriverInstance()
    }

    override fun afterEach(context: ExtensionContext?) {
        getWebDriver().quit()
    }
}