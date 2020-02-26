package io.github.isandratskiy.fragments

import com.codeborne.selenide.SelenideElement

abstract class AbstractFragment (
    private val container : SelenideElement
) {
    fun getText(): String = container.text
}