package io.github.isandratskiy.driver

import com.codeborne.selenide.Configuration.*
import java.lang.System.*
import com.codeborne.selenide.Configuration.browser

class WebDriverFactory {
    companion object {
        fun createWebDriverInstance() = when (getBrowserProperty()) {
            "firefox.remote" -> Browser.FIREFOX_REMOTE.start()
            "chrome.remote" -> Browser.CHROME_REMOTE.start()
            else -> Browser.CHROME_LOCAL.start()
        }

        private enum class Browser {
            CHROME_REMOTE {
                override fun start() {
                    setRemoteCapabilities()
                    setRemoteInstance()
                    browser = "chrome"
                }
            },
            FIREFOX_REMOTE {
                override fun start() {
                    setRemoteCapabilities()
                    setRemoteInstance()
                    browser = "firefox"
                }
            },
            CHROME_LOCAL {
                override fun start() {
                    browser = ChromeDriverProvider::class.qualifiedName
                }
            };

            abstract fun start()
        }
    }
}

private fun getBrowserProperty() = getProperty("browser")

private fun getJenkinsProperty() = getProperty("jenkins")!!.toBoolean()

private fun setRemoteInstance() {
    remote = when (getJenkinsProperty()) {
        true -> "http://selenoid:4444/wd/hub"
        else -> "http://0.0.0.0:4444/wd/hub"
    }
}

private fun setRemoteCapabilities() {
    browserCapabilities.acceptInsecureCerts()
    browserCapabilities.setCapability("noProxy", true)
    browserCapabilities.setCapability("enableVNC", true)
    browserCapabilities.setCapability("enableVideo", false)
}