package io.github.isandratskiy.pages

import com.codeborne.selenide.Selenide.*
import io.qameta.allure.Step
import org.openqa.selenium.By
import org.openqa.selenium.By.*

class UploadFilePage : AbstractPage() {
    private val uploadFile : By = cssSelector("#file-upload")
    private val uploadSubmit : By = cssSelector("#file-submit")
    private val uploadStatus : By = cssSelector("h3")

    @Step("Upload file: '{filePath} '")
    fun uploadFile(filePath: String): UploadFilePage {
        element(uploadFile).uploadFromClasspath(filePath)
        element(uploadSubmit).click()
        return this
    }

    @Step("Get upload status")
    fun getUploadStatus(): String = element(uploadStatus).text
}