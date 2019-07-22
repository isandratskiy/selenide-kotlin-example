package io.github.isandratskiy.fragments

import com.codeborne.selenide.Condition.*
import com.codeborne.selenide.Selenide.*
import com.codeborne.selenide.SelenideElement
import io.github.isandratskiy.pages.SecurePage
import io.qameta.allure.Step
import org.openqa.selenium.By
import org.openqa.selenium.By.*

class LoginFormFragment(
    private val fragment : SelenideElement = element("form#login")
) : AbstractFragment(fragment) {

    private val userName : By = cssSelector("#username")
    private val userPassword : By = cssSelector("#password")
    private val loginButton : By = cssSelector("button.radius")

    @Step("Log in as user '{username}' with password '{password}'")
    fun loginWith(username: String, password: String): SecurePage {
        fragment.`$`(userName).shouldBe(visible).value = username
        fragment.`$`(userPassword).shouldBe(visible).value = password
        fragment.`$`(loginButton).click()
        return SecurePage()
    }
}