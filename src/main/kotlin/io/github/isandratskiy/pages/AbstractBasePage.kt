package io.github.isandratskiy.pages

import com.codeborne.selenide.WebDriverRunner.*
import io.qameta.allure.Step

abstract class AbstractBasePage {

    companion object {
        const val DEFAULT_URL : String = "https://the-internet.herokuapp.com"
    }

    @Step("Check page URL")
    fun checkPage(): String? = url().replace(DEFAULT_URL, "")
}