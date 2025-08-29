package com.github.kasnil.filemagicnumbers

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotNull

class FontFileTypeIdentifierTest : FileTypeIdentifierTest() {
    @Test
    fun identifyWoff() {
        val expected = Woff().fileType
        val actual = getFileTypeIdentifier("sample.woff")

        assertNotNull(actual)
        assertEquals(expected, actual!!)
    }

    @Test
    fun identifyWoff2() {
        val expected = Woff2().fileType
        val actual = getFileTypeIdentifier("sample.woff2")

        assertNotNull(actual)
        assertEquals(expected, actual!!)
    }

    @Test
    fun identifyTtf() {
        val expected = Ttf().fileType
        val actual = getFileTypeIdentifier("sample.ttf")

        assertNotNull(actual)
        assertEquals(expected, actual!!)
    }

    @Test
    fun identifyOtf() {
        val expected = Otf().fileType
        val actual = getFileTypeIdentifier("sample.otf")

        assertNotNull(actual)
        assertEquals(expected, actual!!)
    }

    private fun getFileTypeIdentifier(fileName: String) = 
        getFileTypeIdentifier().identify(readResourceFileAsInputStream("/fonts/" + fileName))
}
