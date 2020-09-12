package io.github.isandratskiy.extension

import com.codeborne.selenide.WebDriverRunner.getWebDriver
import io.github.isandratskiy.core.Configuration
import io.github.isandratskiy.driver.WebDriverFactory
import org.junit.jupiter.api.extension.AfterEachCallback
import org.junit.jupiter.api.extension.BeforeEachCallback
import org.junit.jupiter.api.extension.ExtensionContext

class SetupExtension : BeforeEachCallback, AfterEachCallback {

    override fun beforeEach(context: ExtensionContext?) {
        Configuration.buildConfiguration()
        WebDriverFactory.createInstance()
    }

    override fun afterEach(context: ExtensionContext?) {
        getWebDriver().quit()
    }
}