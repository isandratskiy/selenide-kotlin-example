package io.github.isandratskiy.pages

import io.github.isandratskiy.components.FlashMessageFragment
import org.openqa.selenium.By

class SecurePage : AbstractBasePage() {

    private val LOGOUT_BUTTON = By.cssSelector("button.secondary")

    fun getErrorMessage(): String? {
        return FlashMessageFragment().getMessage()
    }
}