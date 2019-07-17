package io.github.isandratskiy.pages

import com.codeborne.selenide.Selenide.*
import com.codeborne.selenide.SelenideElement
import org.openqa.selenium.By.*

open class MainPage {

    private val PROJECT_ROW = cssSelector("span.project-name")
    private val NEW_PROJECT_BUTTON = xpath("//*[text()[contains(.,'New project')]]")

    private fun getProjectRows(): List<SelenideElement> {
        return elements(PROJECT_ROW).filter { it.text.contains("projects") }
    }
}