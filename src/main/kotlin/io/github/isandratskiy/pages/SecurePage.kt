package io.github.isandratskiy.pages

import io.github.isandratskiy.fragments.FlashMessageFragment
import org.openqa.selenium.By.*

class SecurePage : AbstractPage() {

    private val logoutButton = cssSelector("button.secondary")

    fun getFlashMessage() : FlashMessageFragment = FlashMessageFragment()
}