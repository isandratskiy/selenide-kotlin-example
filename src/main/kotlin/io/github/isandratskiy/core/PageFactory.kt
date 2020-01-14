package io.github.isandratskiy.core

import com.codeborne.selenide.Selenide.*
import io.github.isandratskiy.pages.AbstractPage
import io.qameta.allure.Step
import org.apache.commons.lang3.StringUtils.*
import kotlin.reflect.KClass
import kotlin.reflect.full.createInstance

@Step("Open {url} page")
fun <K : AbstractPage> open(pageObjectClass: KClass<K>, url: String = EMPTY): K {
    open(url)
    return pageObjectClass.createInstance()
}