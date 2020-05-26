package io.github.isandratskiy.pages

import com.codeborne.selenide.Selenide.*
import io.qameta.allure.Step

class UploadFilePage : AbstractPage() {

    @Step("Upload file: '{filePath} '")
    fun uploadFile(filePath: String): UploadFilePage {
        element("#file-upload").uploadFromClasspath(filePath)
        element("#file-submit").click()
        return this
    }

    @Step("Get upload status")
    fun getUploadStatus(): String? = element("h3").text
}