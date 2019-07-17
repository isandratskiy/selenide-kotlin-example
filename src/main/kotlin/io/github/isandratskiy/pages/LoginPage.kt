package io.github.isandratskiy.pages

import com.codeborne.selenide.Selenide.*
import io.github.isandratskiy.components.FlashMessageFragment
import io.qameta.allure.Step
import org.openqa.selenium.By.*
import kotlin.reflect.KClass
import kotlin.reflect.full.createInstance

class LoginPage : AbstractBasePage() {

    private val USERNAME_FIELD = cssSelector("#username")
    private val PASSWORD_FIELD = cssSelector("#password")
    private val LOGIN_BUTTON = cssSelector("button.radius")

    @Step("Open 'Login' page")
    fun open(): LoginPage {
        open("https://the-internet.herokuapp.com/login")
        return LoginPage()
    }

    @Step("Log in as user '{username}' with password '{password}'")
    fun login(username: String, password: String): LoginPage {
        element(USERNAME_FIELD).value = username
        element(PASSWORD_FIELD).value = password
        return LoginPage()
    }

    @Step("Click 'Login' button")
    fun <K : Any> clickLoginButton(pageObjectClass: KClass<K>): K? {
        element(LOGIN_BUTTON).click()
        return pageObjectClass.createInstance()
    }

    fun getErrorMessage(): String? {
        return FlashMessageFragment().getMessage().text
    }
}