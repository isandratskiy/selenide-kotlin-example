package io.github.isandratskiy.pages

import com.codeborne.selenide.Selenide.element
import io.github.isandratskiy.core.navigate
import io.qameta.allure.Step

class UploadFilePage : AbstractPage() {

    companion object {
        @JvmStatic
        fun open(): UploadFilePage = navigate(UploadFilePage::class, "/upload")
    }

    @Step("Upload file: '{filePath} '")
    fun uploadFile(filePath: String): UploadFilePage {
        element("#file-upload").uploadFromClasspath(filePath)
        element("#file-submit").click()
        return this
    }

    @Step("Get upload status")
    fun getUploadStatus(): String = element("h3").text!!
}