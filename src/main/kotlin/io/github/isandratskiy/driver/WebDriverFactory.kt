package io.github.isandratskiy.driver

import java.lang.System.*

class WebDriverFactory {
    companion object {
        fun createInstance() {
            when (getBrowserProperty()) {
                "firefox" -> {

                }
                "chrome" -> {

                }
                "remote.chrome" -> {

                }
                "remote.firefox" -> {

                }
                else -> {
                }
            }
        }

        fun getBrowserProperty() = getProperty("browser")

    }
}

class Chrome {

}

class FireFox {

}

enum class Browser {
    Chrome, Firefox
}