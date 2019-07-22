package io.github.isandratskiy.driver

import java.lang.System.*

class WebDriverFactory {
    companion object {
        fun createInstance(): Chrome? {
            when (getBrowserProperty()) {
                Browser.Chrome.toString() -> return Chrome()
                else -> return null
            }
        }

        fun getBrowserProperty() = getProperty("browser")
    }
}

class Chrome {

}

class FireFox {

}

enum class Browser() {
    Chrome, Firefox
}