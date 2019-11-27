package io.github.isandratskiy.driver

import com.codeborne.selenide.Configuration.*
import java.lang.System.*
import com.codeborne.selenide.Configuration.browser
import io.github.isandratskiy.driver.WebDriverFactory.Companion.RemoteBrowser.*

class WebDriverFactory {
    companion object {
        fun createWebDriverInstance() = when (getBrowserProperty()) {
            Firefox.toString().toLowerCase() -> Firefox.configure()
            Chrome.toString().toLowerCase() -> Chrome.configure()
            else -> LocalBrowser.Chrome.configure()
        }

        private enum class RemoteBrowser {
            Chrome {
                override fun configure() {
                    setRemoteCapabilities()
                    setRemoteInstance()
                    browser = "chrome"
                }
            },
            Firefox {
                override fun configure() {
                    setRemoteCapabilities()
                    setRemoteInstance()
                    browser = "firefox"
                }
            };
            abstract fun configure()
        }

        enum class LocalBrowser {
            Chrome {
                override fun configure() {
                    browser = ChromeDriverProvider::class.qualifiedName
                }
            };
            abstract fun configure()
        }
    }
}

private fun getBrowserProperty() = getProperty("browser")

private fun setRemoteInstance() {
    remote = "http://0.0.0.0:4444/wd/hub"
}

private fun setRemoteCapabilities() {
    browserCapabilities.acceptInsecureCerts()
    browserCapabilities.setCapability("noProxy", true)
    browserCapabilities.setCapability("enableVNC", true)
    browserCapabilities.setCapability("enableVideo", false)
}