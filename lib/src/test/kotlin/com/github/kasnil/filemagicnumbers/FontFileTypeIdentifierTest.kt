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

    private fun getFileTypeIdentifier(fileName: String) = 
        getFileTypeIdentifier().identify(readResourceFileAsInputStream("/fonts/" + fileName))
}
