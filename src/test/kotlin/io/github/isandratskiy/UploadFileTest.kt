package io.github.isandratskiy

import io.github.isandratskiy.core.open
import io.github.isandratskiy.extension.SetupExtension
import io.github.isandratskiy.pages.UploadFilePage
import org.amshove.kluent.shouldContain
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.junit.jupiter.api.parallel.Execution
import org.junit.jupiter.api.parallel.ExecutionMode

@DisplayName("Upload File tests")
@Execution(ExecutionMode.CONCURRENT)
@ExtendWith(SetupExtension::class)
class UploadFileTest {

    @Test
    fun `can upload file from classpath`() {
        open(UploadFilePage::class, "/upload")
                .uploadFile("hello_world.txt")
                .getUploadStatus()?.shouldContain("File Uploaded!")
    }
}