package io.github.isandratskiy.pages

import com.codeborne.selenide.Selenide.element
import io.qameta.allure.Step

class UploadFilePage(function: UploadFilePage.() -> Unit = {}) : AbstractPage() {

    init {
        this.function()
    }

    @Step("Upload file: '{filePath} '")
    fun uploadFile(filePath: String): UploadFilePage {
        element("#file-upload").uploadFromClasspath(filePath)
        element("#file-submit").click()
        return this
    }

    @Step("Get upload status")
    fun getUploadStatus(): String = element("h3").text
}