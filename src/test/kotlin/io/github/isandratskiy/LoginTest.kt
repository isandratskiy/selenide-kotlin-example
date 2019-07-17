package io.github.isandratskiy

import com.codeborne.selenide.Configuration.*
import io.github.isandratskiy.pages.LoginPage
import io.github.isandratskiy.pages.SecurePage
import org.amshove.kluent.shouldContain
import org.junit.jupiter.api.*
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.TestInstance.Lifecycle.PER_CLASS
import io.qameta.allure.selenide.AllureSelenide
import com.codeborne.selenide.logevents.SelenideLogger
import org.amshove.kluent.shouldBeEqualTo

@TestInstance(PER_CLASS)
class LoginTest {

    private val loginPage = LoginPage()

    @BeforeAll
    fun setup() {
        SelenideLogger.addListener(
            "allure", AllureSelenide().screenshots(true).savePageSource(true)
        )
        startMaximized = true
        browserCapabilities.acceptInsecureCerts()
        browserCapabilities.setCapability("enableVNC", true)
        browserCapabilities.setCapability("enableVideo", false)
        remote = "http://192.168.1.232:4444/wd/hub"
    }

    @Test
    fun `can login with correct credentials`() {
        loginPage.open()
            .login("tomsmith", "SuperSecretPassword!")
            .clickLoginButton(SecurePage::class)!!
            .getErrorMessage()?.shouldContain("You logged into a secure area!")
            .also { loginPage.checkPage()?.shouldBeEqualTo("/secure") }
    }

    @Test
    fun `can't login with fake credentials`() {
        loginPage.open()
            .login("johndoe", "InvalidPassword!")
            .clickLoginButton(LoginPage::class)!!
            .getErrorMessage()?.shouldContain("Your username is invalid!")
    }
}