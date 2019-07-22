package io.github.isandratskiy.extensions

import com.codeborne.selenide.Configuration
import com.codeborne.selenide.Selenide.*
import com.codeborne.selenide.WebDriverRunner.*
import com.codeborne.selenide.logevents.SelenideLogger
import io.qameta.allure.selenide.AllureSelenide
import org.junit.jupiter.api.extension.*
import java.util.concurrent.TimeUnit

class SetupExtension : BeforeEachCallback, AfterEachCallback {

    override fun beforeEach(context: ExtensionContext?) {
        SelenideLogger.addListener(
            "allure", AllureSelenide().screenshots(true).savePageSource(true)
        )
        Configuration.startMaximized = true
        Configuration.fastSetValue = true
        Configuration.browserCapabilities.acceptInsecureCerts()
        Configuration.browserCapabilities.setCapability("noProxy", true)
        Configuration.browserCapabilities.setCapability("enableVNC", true)
        Configuration.browserCapabilities.setCapability("enableVideo", false)
        Configuration.timeout = TimeUnit.SECONDS.toMillis(15)
        Configuration.browser = "chrome"
        Configuration.remote = "http://0.0.0.0:4444/wd/hub"
        open("https://the-internet.herokuapp.com")
    }

    override fun afterEach(context: ExtensionContext?) {
        getWebDriver().quit()
    }
}