package de.freischlag.sandbox.pizza.common

import java.text.MessageFormat
import java.util.*

val ERROR_CUSTOMER_UNKNOWN_PHONE_NUMBER = {phoneNumber: String? -> Messages.resolve("ERROR_CUSTOMER_UNKNOWN_PHONE_NUMBER",  phoneNumber) }
val ERROR_CUSTOMER_WITH_ID_EXISTS = { customerId : Long? -> Messages.resolve("ERROR_CUSTOMER_WITH_ID_EXISTS", customerId) }

object Messages {

    private val DEFAULT_RESOURCE_BUNDLE_LOCATION : String = de.freischlag.sandbox.pizza.PizzaApp::class.java.packageName  + ".messages"

    fun resolve(key : String, vararg values : Any?) = resolve(Locale.getDefault(), key, *values)

    private fun resolve(locale : Locale, key : String, vararg values : Any?) = resolve(DEFAULT_RESOURCE_BUNDLE_LOCATION, locale, key, *values)

    private fun resolve(resourceBundleLocation : String, locale : Locale, key : String, vararg values : Any?) : String {
        try {
            val msg =  ResourceBundle.getBundle(resourceBundleLocation,locale).getString(key)
            return MessageFormat.format(msg,*values)
        } catch (e : MissingResourceException) {
            return "?$key?"
        }
    }
}
