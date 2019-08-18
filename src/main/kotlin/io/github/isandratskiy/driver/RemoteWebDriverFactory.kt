package io.github.isandratskiy.driver

import com.codeborne.selenide.Configuration.*
import java.lang.System.*
import com.codeborne.selenide.Configuration.browser



class DriverFactory {
    companion object {
        fun createDriverInstance() = when (getBrowserProperty()) {
            Browser.Firefox.toString() -> Browser.Firefox.configure()
            Browser.Chrome.toString() -> Browser.Chrome.configure()
            else -> LocalBrowser.Chrome.configure()
        }
    }
}

private enum class Browser {
    Chrome {
        override fun configure() {
            setRemoteCapabilities()
            browser = "chrome"
            setRemoteInstance()
        }
    },
    Firefox {
        override fun configure() {
            setRemoteCapabilities()
            browser = "firefox"
            setRemoteInstance()
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