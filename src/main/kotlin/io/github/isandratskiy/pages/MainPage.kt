package io.github.isandratskiy.pages

import com.codeborne.selenide.Condition.*
import com.codeborne.selenide.ElementsCollection
import com.codeborne.selenide.Selenide.*
import com.codeborne.selenide.SelenideElement
import io.qameta.allure.Step

class MainPage(
    private val element: SelenideElement = element("#content.large-12")
) : AbstractPage() {

    private fun getExampleRows(): ElementsCollection = element.`$$`(".columns ul li a")

    @Step("Open available example: {exampleTypes} page")
    fun openAvailableExample(exampleTypes: ExampleTypes): MainPage {
        getExampleRows().filterBy(text(exampleTypes.type)).find(visible).click()
        return this
    }
}

enum class ExampleTypes(val type: String) {
    FORM_AUTHENTICATION("Form Authentication"),
    ADD_REMOVE_ELEMENTS("Add/Remove Elements")
}