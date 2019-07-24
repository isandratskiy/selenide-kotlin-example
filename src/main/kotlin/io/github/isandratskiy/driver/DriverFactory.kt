package io.github.isandratskiy.driver

import com.codeborne.selenide.Configuration.*
import java.lang.System.*
import java.util.concurrent.TimeUnit.*

class DriverFactory {
    companion object {
        fun createDriverInstance() {
            when (getBrowserProperty()) {
                Browser.Firefox.toString() -> FireFox()
                Browser.Chrome.toString() -> Chrome()
                else -> Chrome()
            }
        }
    }
}

private class Chrome {
    init {
        startMaximized = true
        fastSetValue = true
        browserCapabilities.acceptInsecureCerts()
        browserCapabilities.setCapability("enableVNC", true)
        browserCapabilities.setCapability("enableVideo", false)
        timeout = SECONDS.toMillis(15)
        browser = "chrome"
        getRemoteInstance()
    }
}

private class FireFox {
    init {
        startMaximized = true
        fastSetValue = true
        browserCapabilities.acceptInsecureCerts()
        browserCapabilities.setCapability("noProxy", true)
        browserCapabilities.setCapability("enableVNC", true)
        browserCapabilities.setCapability("enableVideo", false)
        timeout = SECONDS.toMillis(15)
        browser = "firefox"
        getRemoteInstance()
    }
}

private fun getRemoteInstance() {
    remote = "http://0.0.0.0:4444/wd/hub"
}

private fun getBrowserProperty() = getProperty("browser")

enum class Browser {
    Chrome, Firefox
}