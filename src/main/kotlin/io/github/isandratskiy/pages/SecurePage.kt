package io.github.isandratskiy.pages

import io.github.isandratskiy.fragments.FlashMessageFragment

class SecurePage : AbstractPage() {

    fun getFlashMessage() : FlashMessageFragment = FlashMessageFragment()
}