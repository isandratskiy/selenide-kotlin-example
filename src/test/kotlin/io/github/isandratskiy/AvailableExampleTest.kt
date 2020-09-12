package io.github.isandratskiy

import io.github.isandratskiy.extension.BaseSetup
import io.github.isandratskiy.pages.ExampleTypes.FORM_AUTHENTICATION
import io.github.isandratskiy.pages.MainPage
import org.amshove.kluent.shouldBeEqualTo
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@BaseSetup
@DisplayName("Available Example tests")
class AvailableExampleTest {
    @Test
    fun `can open available example`() {
        MainPage.open()
                .openAvailableExample(FORM_AUTHENTICATION)
                .getCurrentURL()
                .shouldBeEqualTo("/login")
    }
}