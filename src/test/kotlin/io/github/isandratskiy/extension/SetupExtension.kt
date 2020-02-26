package io.github.isandratskiy.extension

import com.codeborne.selenide.WebDriverRunner.*
import io.github.isandratskiy.core.buildConfiguration
import io.github.isandratskiy.driver.WebDriverFactory.Companion.createWebDriverInstance
import org.junit.jupiter.api.extension.*

class SetupExtension : BeforeEachCallback, AfterEachCallback {

    override fun beforeEach(context: ExtensionContext?) {
        buildConfiguration()
        createWebDriverInstance()
    }

    override fun afterEach(context: ExtensionContext?) {
        getWebDriver().quit()
    }
}