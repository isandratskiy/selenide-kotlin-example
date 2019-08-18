package io.github.isandratskiy.driver

import com.codeborne.selenide.WebDriverProvider
import io.github.bonigarcia.wdm.WebDriverManager.chromedriver
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.remote.DesiredCapabilities
import org.openqa.selenium.chrome.ChromeOptions



class ChromeDriverProvider : WebDriverProvider {
    override fun createDriver(desiredCapabilities: DesiredCapabilities?): WebDriver {
        chromedriver().setup()
        return ChromeDriver(getOptions())
    }
}

private fun getOptions(): ChromeOptions {
    val options = ChromeOptions()
    options.setAcceptInsecureCerts(true)
    options.addArguments("--headless")
    options.addArguments("--start-maximized")
    options.addArguments("--block-new-web-contents")
    return options
}