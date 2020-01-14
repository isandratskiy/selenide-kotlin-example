package io.github.isandratskiy.fragments

import com.codeborne.selenide.SelenideElement

open class AbstractFragment (
    private val rootFragment : SelenideElement
) {
    open fun getText(): String = rootFragment.text
}