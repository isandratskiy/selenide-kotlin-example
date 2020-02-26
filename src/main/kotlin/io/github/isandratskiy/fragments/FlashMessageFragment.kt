package io.github.isandratskiy.fragments

import com.codeborne.selenide.Condition.*
import com.codeborne.selenide.Selenide.*
import com.codeborne.selenide.SelenideElement
import io.qameta.allure.Step

class FlashMessageFragment (
    private val container : SelenideElement = element("#flash-messages").shouldBe(visible)
) : AbstractFragment(container) {

    @Step("Error message is displayed")
    fun getMessage(): SelenideElement = container
}