package io.github.isandratskiy.pages

import io.github.isandratskiy.fragments.FlashMessageFragment

class SecurePage(function: SecurePage.() -> Unit = {}) : AbstractPage() {

    init {
        this.function()
    }

    fun getFlashMessage() : String = FlashMessageFragment().getText()
}