package io.github.isandratskiy.core

import com.codeborne.selenide.Selenide.open
import io.github.isandratskiy.pages.AbstractPage
import io.qameta.allure.Step
import org.apache.commons.lang3.StringUtils.EMPTY
import kotlin.reflect.KClass
import kotlin.reflect.full.createInstance

@Step("Open {url} page")
fun <K : AbstractPage> navigate(pageClass: KClass<K>, url: String = EMPTY): K {
    open(url)
    return pageClass.createInstance()
}