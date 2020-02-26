package io.github.isandratskiy.pages

import io.github.isandratskiy.fragments.FlashMessageFragment
import io.github.isandratskiy.fragments.LoginFormFragment

class LoginPage : AbstractPage() {

    fun getLoginForm(): LoginFormFragment = LoginFormFragment()

    fun getFlashMessage() : FlashMessageFragment = FlashMessageFragment()
}