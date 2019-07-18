package io.github.isandratskiy.pages

import com.codeborne.selenide.Condition.*
import com.codeborne.selenide.Selenide.*
import com.codeborne.selenide.SelenideElement
import io.github.isandratskiy.fragments.FlashMessageFragment
import io.github.isandratskiy.fragments.LoginFormFragment

class LoginPage(
    private val loginForm: SelenideElement = element("form#login").shouldBe(visible)
) : AbstractPage() {

    fun getLoginForm(): LoginFormFragment = LoginFormFragment(loginForm)

    fun getFlashMessage() : FlashMessageFragment = FlashMessageFragment()
}