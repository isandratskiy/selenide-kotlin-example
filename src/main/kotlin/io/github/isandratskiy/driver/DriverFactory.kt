package io.github.isandratskiy.driver

import com.codeborne.selenide.Configuration.*
import java.lang.System.*
import java.util.concurrent.TimeUnit.*

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
            startMaximized = true
            fastSetValue = true
            browserCapabilities.acceptInsecureCerts()
            browserCapabilities.setCapability("enableVNC", true)
            browserCapabilities.setCapability("enableVideo", false)
            timeout = SECONDS.toMillis(20)
            browser = "chrome"
            setRemoteInstance()
        }
    },
    Firefox {
        override fun configure() {
            startMaximized = true
            fastSetValue = true
            browserCapabilities.acceptInsecureCerts()
            browserCapabilities.setCapability("noProxy", true)
            browserCapabilities.setCapability("enableVNC", true)
            browserCapabilities.setCapability("enableVideo", false)
            timeout = SECONDS.toMillis(20)
            browser = "firefox"
            setRemoteInstance()
        }
    };

    abstract fun configure()
}

private enum class LocalBrowser {
    Chrome {
        override fun configure() {
            startMaximized = true
            fastSetValue = true
            browserCapabilities.acceptInsecureCerts()
            timeout = SECONDS.toMillis(20)
            baseUrl = "https://the-internet.herokuapp.com"
        }
    };

    abstract fun configure()
}

private fun setRemoteInstance() {
    baseUrl = "https://the-internet.herokuapp.com"
    remote = "http://0.0.0.0:4444/wd/hub"
}

private fun getBrowserProperty() = getProperty("browser")