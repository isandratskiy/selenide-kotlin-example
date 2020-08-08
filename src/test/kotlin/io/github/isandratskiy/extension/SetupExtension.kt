package io.github.isandratskiy.extension

import com.codeborne.selenide.Selenide
import com.codeborne.selenide.WebDriverRunner.getWebDriver
import io.github.isandratskiy.core.setSelenideConfiguration
import io.github.isandratskiy.driver.WebDriverFactory.Companion.createWebDriverInstance
import org.junit.jupiter.api.extension.AfterEachCallback
import org.junit.jupiter.api.extension.BeforeAllCallback
import org.junit.jupiter.api.extension.BeforeEachCallback
import org.junit.jupiter.api.extension.ExtensionContext

class SetupExtension : BeforeEachCallback, AfterEachCallback, BeforeAllCallback {

    override fun beforeEach(context: ExtensionContext?) {
        createWebDriverInstance()
        Selenide.open("/")
    }

    override fun afterEach(context: ExtensionContext?) {
        getWebDriver().quit()
    }

    override fun beforeAll(context: ExtensionContext?) {
        setSelenideConfiguration()
    }
}