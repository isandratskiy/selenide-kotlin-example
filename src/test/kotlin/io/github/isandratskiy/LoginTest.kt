package io.github.isandratskiy

import io.github.isandratskiy.extension.BaseSetup
import io.github.isandratskiy.pages.LoginPage
import io.github.isandratskiy.pages.SecurePage
import org.amshove.kluent.shouldContain
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@BaseSetup
@DisplayName("Login Form Authentication tests")
class LoginTest {

    @BeforeEach
    fun arrange() {
        LoginPage().open("/login")
    }

    @Test
    fun `can login with correct credentials`() {
        LoginPage {
            loginAs("tomsmith", "SuperSecretPassword!")
        }

        SecurePage {
            getFlashMessage().shouldContain("You logged into a secure area!")
        }
    }

    @Test
    fun `can't login with fake credentials`() {
        LoginPage {
            loginAs("johndoe", "InvalidPassword!")
            getFlashMessage().shouldContain("Your username is invalid!")
        }
    }
}