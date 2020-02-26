package io.github.isandratskiy.fragments

import com.codeborne.selenide.Selenide.*
import com.codeborne.selenide.SelenideElement
import io.github.isandratskiy.pages.SecurePage
import io.qameta.allure.Step

class LoginFormFragment(
    private val container : SelenideElement = element("form#login")
) : AbstractFragment(container) {

    @Step("Log in as user '{username}' with password '{password}'")
    fun loginWith(username: String, password: String): SecurePage {
        container.`$`("#username").value = username
        container.`$`("#password").value = password
        container.`$`("button.radius").click()
        return SecurePage()
    }
}