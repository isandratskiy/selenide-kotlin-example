package io.github.isandratskiy.fragments

import com.codeborne.selenide.Condition.*
import com.codeborne.selenide.Selenide.*
import com.codeborne.selenide.SelenideElement
import io.github.isandratskiy.core.AbstractFragment
import io.qameta.allure.Step

class FlashMessageFragment (
    private val fragment : SelenideElement = element("#flash-messages").shouldBe(visible)
) : AbstractFragment(fragment) {

    @Step("Error message is displayed")
    fun getMessage(): SelenideElement = fragment
}