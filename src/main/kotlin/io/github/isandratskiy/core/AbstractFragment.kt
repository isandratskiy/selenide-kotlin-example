package io.github.isandratskiy.core

import com.codeborne.selenide.SelenideElement

open class AbstractFragment (
    private val rootFragment : SelenideElement
) {
    protected fun getRootFragment(): SelenideElement = rootFragment

    protected fun getFragmentText(): String = rootFragment.text
}