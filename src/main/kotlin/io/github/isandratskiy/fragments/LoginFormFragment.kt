package io.github.isandratskiy.fragments

import com.codeborne.selenide.Selenide.element
import com.codeborne.selenide.SelenideElement
import io.github.isandratskiy.pages.SecurePage
import io.qameta.allure.Step

class LoginFormFragment(
    private val container : SelenideElement = element("form#login")
) : AbstractFragment(container) {

    @Step("Log in as user '{username}' with password '{password}'")
    fun login(username: String, password: String): SecurePage {
        container.find("#username").value = username
        container.find("#password").value = password
        container.find("button.radius").click()
        return SecurePage()
    }
}