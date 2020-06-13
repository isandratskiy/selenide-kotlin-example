package io.github.isandratskiy

import io.github.isandratskiy.core.open
import io.github.isandratskiy.extension.BaseSetup
import io.github.isandratskiy.pages.LoginPage
import org.amshove.kluent.shouldContain
import org.junit.jupiter.api.*

@BaseSetup
@DisplayName("Login Form Authentication tests")
class LoginTest {

    @Test
    fun `can login with correct credentials`() {
        open(LoginPage::class, "/login")
                .getLoginForm()
                .loginWith("tomsmith", "SuperSecretPassword!")
                .getFlashMessage()
                .getText()
                .shouldContain("You logged into a secure area!")
    }

    @Test
    fun `can't login with fake credentials`() {
        open(LoginPage::class, "/login")
                .getLoginForm()
                .loginWith("johndoe", "InvalidPassword!")
                .at(LoginPage::class)
                .getFlashMessage()
                .getText()
                .shouldContain("Your username is invalid!")
    }
}