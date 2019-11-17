package io.github.isandratskiy.driver

import com.codeborne.selenide.Configuration.*
import java.lang.System.*
import com.codeborne.selenide.Configuration.browser

class WebDriverFactory {
    companion object {
        fun createWebDriverInstance() = when (getBrowserProperty()) {
            RemoteBrowser.Firefox.toString() -> RemoteBrowser.Firefox.configure()
            RemoteBrowser.Chrome.toString() -> RemoteBrowser.Chrome.configure()
            else -> LocalBrowser.Chrome.configure()
        }
    }
}

private enum class RemoteBrowser {
    Chrome {
        override fun configure() {
            println("http://${getRemoteHub()}:4444/wd/hub")
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

private fun getBrowserProperty() = getProperty("browser")

private fun getRemoteHub(): String {
    return when {
        getProperty("remoteHub").isNullOrEmpty() -> "0.0.0.0"
        else -> getProperty("remoteHub")
    }
}

private fun setRemoteInstance() {
    remote = "http://${getRemoteHub()}:4444/wd/hub"
}

private fun setRemoteCapabilities() {
    browserCapabilities.acceptInsecureCerts()
    browserCapabilities.setCapability("noProxy", true)
    browserCapabilities.setCapability("enableVNC", true)
    browserCapabilities.setCapability("enableVideo", false)
}