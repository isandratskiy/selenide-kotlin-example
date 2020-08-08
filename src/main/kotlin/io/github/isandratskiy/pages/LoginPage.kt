package io.github.isandratskiy.pages

import io.github.isandratskiy.fragments.FlashMessageFragment
import io.github.isandratskiy.fragments.LoginFormFragment

class LoginPage(function: LoginPage.() -> Unit = {}) : AbstractPage() {

    init {
        this.function()
    }

    fun loginAs(username: String, password: String) {
        LoginFormFragment().login(username, password)
    }

    fun getFlashMessage(): String = FlashMessageFragment().getText()
}