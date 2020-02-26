package io.github.isandratskiy.core

import com.codeborne.selenide.Configuration.*
import com.codeborne.selenide.logevents.SelenideLogger.*
import io.qameta.allure.selenide.AllureSelenide

fun buildConfiguration() {
    setSelenideConfiguration()
}

private fun setSelenideConfiguration() {
    addListener("allure", AllureSelenide().screenshots(true).savePageSource(false))
    baseUrl = "https://the-internet.herokuapp.com"
    browserSize = "1920x1080"
    fastSetValue = true
    timeout = 10000
}