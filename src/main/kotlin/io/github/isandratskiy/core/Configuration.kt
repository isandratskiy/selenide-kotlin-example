package io.github.isandratskiy.core

import com.codeborne.selenide.Configuration
import com.codeborne.selenide.logevents.SelenideLogger
import io.qameta.allure.selenide.AllureSelenide

class Configuration {
    companion object {
        fun buildConfiguration() {
            setSelenideConfiguration()
        }

        private fun setSelenideConfiguration() {
            SelenideLogger.addListener("allure", AllureSelenide().screenshots(true).savePageSource(false))
            Configuration.baseUrl = "https://the-internet.herokuapp.com"
            Configuration.browserSize = "1920x1080"
            Configuration.fastSetValue = true
            Configuration.timeout = 10000
        }
    }
}