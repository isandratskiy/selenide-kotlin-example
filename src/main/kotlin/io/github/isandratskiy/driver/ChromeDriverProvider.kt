package io.github.isandratskiy.driver

import com.codeborne.selenide.WebDriverProvider
import io.github.bonigarcia.wdm.WebDriverManager.chromedriver
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions
import org.openqa.selenium.remote.DesiredCapabilities

class ChromeDriverProvider : WebDriverProvider {
    override fun createDriver(desiredCapabilities: DesiredCapabilities): WebDriver {
        chromedriver().setup()
        return ChromeDriver(getOptions())
    }
}

private fun getOptions(): ChromeOptions {
    val options = ChromeOptions()
    options.setHeadless(true)
    options.setAcceptInsecureCerts(true)
    options.addArguments("--no-sandbox")
    return options
}
