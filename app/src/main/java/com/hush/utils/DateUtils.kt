package com.hush.utils

import java.text.SimpleDateFormat
import java.util.*


object DateUtils {

    private val DATE_FORMAT = SimpleDateFormat("dd-MM-yy");
    @JvmStatic
    fun formatDate(date: Date): String {
        return DATE_FORMAT.format(date)
    }

    @JvmStatic
    fun parseDate(dateString: String): String {
        return DATE_FORMAT.format(DATE_FORMAT.parse(dateString))
    }
}
