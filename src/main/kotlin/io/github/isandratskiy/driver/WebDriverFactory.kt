package io.github.isandratskiy.driver

import com.codeborne.selenide.Configuration.*
import java.lang.System.*
import com.codeborne.selenide.Configuration.browser
import io.github.isandratskiy.driver.WebDriverFactory.Companion.RemoteBrowser.*

class WebDriverFactory {
    companion object {
        fun createWebDriverInstance() = when (getBrowserProperty()) {
            Firefox.toString().toLowerCase() -> Firefox.start()
            Chrome.toString().toLowerCase() -> Chrome.start()
            else -> LocalBrowser.Chrome.start()
        }

        private enum class RemoteBrowser {
            Chrome {
                override fun start() {
                    setRemoteCapabilities()
                    setRemoteInstance()
                    browser = "chrome"
                }
            },
            Firefox {
                override fun start() {
                    setRemoteCapabilities()
                    setRemoteInstance()
                    browser = "firefox"
                }
            };
            abstract fun start()
        }

        enum class LocalBrowser {
            Chrome {
                override fun start() {
                    browser = ChromeDriverProvider::class.qualifiedName
                }
            };
            abstract fun start()
        }
    }
}

private fun getBrowserProperty() = getProperty("browser")

private fun getJenkinsProperty() = getProperty("jenkins")

private fun setRemoteInstance() {
    remote = when (getJenkinsProperty()) {
        "true" -> "http://selenoid:4444/wd/hub"
        else -> "http://0.0.0.0:4444/wd/hub"
    }
}

private fun setRemoteCapabilities() {
    browserCapabilities.acceptInsecureCerts()
    browserCapabilities.setCapability("noProxy", true)
    browserCapabilities.setCapability("enableVNC", true)
    browserCapabilities.setCapability("enableVideo", false)
}