package io.github.isandratskiy

import io.github.isandratskiy.core.open
import io.github.isandratskiy.pages.LoginPage
import org.amshove.kluent.shouldContain
import org.junit.jupiter.api.*
import io.github.isandratskiy.extensions.SetupExtension
import io.github.isandratskiy.pages.ExampleTypes.*
import io.github.isandratskiy.pages.MainPage
import org.amshove.kluent.shouldEqual
import org.junit.jupiter.api.extension.ExtendWith
import org.junit.jupiter.api.parallel.Execution
import org.junit.jupiter.api.parallel.ExecutionMode

@ExtendWith(SetupExtension::class)
@Execution(ExecutionMode.CONCURRENT)
class LoginTest {

    @Test
    fun `can login with correct credentials`() {
        open(LoginPage::class, "/login")
            .getLoginForm()
            .loginWith("tomsmith", "SuperSecretPassword!")
            .getFlashMessage().getText().shouldContain("You logged into a secure area!")
    }

    @Test
    fun `can't login with fake credentials`() {
        open(LoginPage::class, "/login")
            .getLoginForm()
            .loginWith("johndoe", "InvalidPassword!")
            .at(LoginPage::class)
            .getFlashMessage().getText().shouldContain("Your username is invalid!")
    }

    @Test
    fun `can open available example`() {
        open(MainPage::class)
            .openAvailableExample(FORM_AUTHENTICATION)
            .checkPageURL().shouldEqual("/login")
    }
}