package com.dev.weathernews.common

import com.dev.weathernews.common.Utils.formatTimestampToDateTime
import com.dev.weathernews.common.Utils.kelvinToFarhenheit
import io.mockk.every
import io.mockk.mockk
import org.junit.Assert.*

import org.junit.Test
import java.text.SimpleDateFormat
import java.util.Date

class UtilsTest {

    @Test
    fun testFormatTimestampToDateTimeWithDefaultPattern() {
        val timestamp = 1631651100000L // 2021-09-15 12:25:00 UTC
        val expectedDateTime = "2021-09-14 15:25:00"

        val formattedDateTime = formatTimestampToDateTime(timestamp)

        assertEquals(expectedDateTime, formattedDateTime)
    }


    @Test
    fun testFormatTimestampToDateTime() {
        val timestamp = 1631651100000L // 2021-09-14 15:25:00
        val pattern = "yyyy-MM-dd HH:mm:ss"

        // Mock the Date and SimpleDateFormat classes
        // Mock the Date class
        val date = mockk<Date>()
        every { date.time } returns timestamp

        // Mock the SimpleDateFormat class
        val sdf = mockk<SimpleDateFormat>()
        every { sdf.format(date) } returns "2021-09-14 15:25:00"


        // Call the function with the mocked objects
        val formattedDateTime = formatTimestampToDateTime(timestamp, pattern)

        // Verify the result
        assertEquals("2021-09-14 15:25:00", formattedDateTime)
    }


    @Test
    fun testKelvinToFarhenheit() {
        // Test with some example Kelvin temperatures and expected Fahrenheit results
        assertEquals("80.33", kelvinToFarhenheit(300.0))
        assertEquals("32.00", kelvinToFarhenheit(273.15))
        assertEquals("212.00", kelvinToFarhenheit(373.15))
    }

    @Test
    fun testKelvinToFarhenheitNegative() {
        // Test with negative Kelvin temperature
        assertEquals("-459.67", kelvinToFarhenheit(0.0))
        assertEquals("-468.67", kelvinToFarhenheit(-5.0))
    }

    @Test
    fun testKelvinToFarhenheitWithDecimals() {
        // Test with Kelvin temperatures with decimals
        assertEquals("34.45", kelvinToFarhenheit(274.51))
        assertEquals("105.30", kelvinToFarhenheit(313.87))
    }
}