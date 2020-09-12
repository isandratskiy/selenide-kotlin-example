package io.github.isandratskiy.pages

import com.codeborne.selenide.Condition.text
import com.codeborne.selenide.ElementsCollection
import com.codeborne.selenide.Selenide.element
import com.codeborne.selenide.SelenideElement
import io.github.isandratskiy.core.navigate
import io.qameta.allure.Step

class MainPage(
        private val container: SelenideElement = element("#content.large-12")
) : AbstractPage() {

    companion object {
        @JvmStatic
        fun open(): MainPage = navigate(MainPage::class, "/")
    }

    private fun getExamplesList(): ElementsCollection = container.findAll(".columns ul li a")

    @Step("Open available example: {exampleTypes} page")
    fun openAvailableExample(exampleTypes: ExampleTypes): MainPage {
        getExamplesList().findBy(text(exampleTypes.value)).click()
        return this
    }
}

enum class ExampleTypes(val value: String) {
    FORM_AUTHENTICATION("Form Authentication"),
    ADD_REMOVE_ELEMENTS("Add/Remove Elements")
}