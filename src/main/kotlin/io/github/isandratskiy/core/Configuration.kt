package io.github.isandratskiy.core

import com.codeborne.selenide.Configuration
import com.codeborne.selenide.logevents.SelenideLogger
import io.qameta.allure.selenide.AllureSelenide

fun setSelenideConfiguration() {
    val allureSelenide = AllureSelenide()
            .screenshots(true)
            .savePageSource(false)

    SelenideLogger.addListener("allure", allureSelenide)
    Configuration.baseUrl = "https://the-internet.herokuapp.com"
    Configuration.browserSize = "1920x1080"
    Configuration.fastSetValue = true
    Configuration.timeout = 10000
    Configuration.savePageSource = false
    Configuration.screenshots = false
}