package io.github.isandratskiy

import io.github.isandratskiy.extension.BaseSetup
import io.github.isandratskiy.pages.UploadFilePage
import org.amshove.kluent.shouldContain
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@BaseSetup
@DisplayName("Upload File tests")
class UploadFileTest {

    @Test
    fun `can upload file from classpath`() {
        UploadFilePage {
            open("/upload")
            uploadFile("hello_world.txt")
            getUploadStatus().shouldContain("File Uploaded!")
        }
    }
}