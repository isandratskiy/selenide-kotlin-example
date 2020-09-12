package io.github.isandratskiy.pages

import io.github.isandratskiy.core.navigate
import io.github.isandratskiy.fragments.FlashMessageFragment
import io.github.isandratskiy.fragments.LoginFormFragment

class LoginPage : AbstractPage() {

    companion object {
        @JvmStatic
        fun open(): LoginPage = navigate(LoginPage::class, "/login")
    }

    fun getLoginForm(): LoginFormFragment = LoginFormFragment()

    fun getFlashMessage(): FlashMessageFragment = FlashMessageFragment()
}