package io.github.isandratskiy.pages

import com.codeborne.selenide.WebDriverRunner.*
import io.qameta.allure.Step
import kotlin.reflect.KClass
import kotlin.reflect.full.createInstance

abstract class AbstractPage {

    companion object {
        const val DEFAULT_URL : String = "https://the-internet.herokuapp.com"
    }

    @Step("Check page URL")
    fun checkPageURL(): String? = url().replace(DEFAULT_URL, "")

    @Step("User at {pageObjectClass}")
    fun <K : AbstractPage> at(pageObjectClass: KClass<K>): K = pageObjectClass.createInstance()
}