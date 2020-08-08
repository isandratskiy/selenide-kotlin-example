package io.github.isandratskiy.pages

import com.codeborne.selenide.Selenide
import com.codeborne.selenide.WebDriverRunner.url
import io.qameta.allure.Step
import kotlin.reflect.KClass
import kotlin.reflect.full.createInstance

abstract class AbstractPage {
    companion object {
        const val DEFAULT_URL = "https://the-internet.herokuapp.com"
    }

    @Step("Check page URL")
    fun getCurrentURL() = url().replace(DEFAULT_URL, "")

    @Step("User at page - {pageObjectClass}")
    fun <K : AbstractPage> at(pageObjectClass: KClass<K>): K = pageObjectClass.createInstance()

    @Step("Open {url} page")
    fun open(url: String) {
        Selenide.open(url)
    }
}