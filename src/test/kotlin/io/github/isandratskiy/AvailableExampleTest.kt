package io.github.isandratskiy

import io.github.isandratskiy.core.open
import io.github.isandratskiy.extensions.SetupExtension
import io.github.isandratskiy.pages.ExampleTypes.*
import io.github.isandratskiy.pages.MainPage
import org.amshove.kluent.shouldEqual
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@DisplayName("Available Example tests")
@ExtendWith(SetupExtension::class)
class AvailableExampleTest {

    @Test
    fun `can open available example`() {
        open(MainPage::class)
            .openAvailableExample(FORM_AUTHENTICATION)
            .checkPageURL().shouldEqual("/login")
    }
}