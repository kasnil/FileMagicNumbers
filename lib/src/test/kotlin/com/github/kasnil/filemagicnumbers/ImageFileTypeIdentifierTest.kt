package com.github.kasnil.filemagicnumbers

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotNull

class ImageFileTypeIdentifierTest : FileTypeIdentifierTest() {
    @Test
    fun identifyJpeg() {
        val expected = Jpeg().fileType
        val actual = getFileTypeIdentifier("sample.jpg")

        assertNotNull(actual)
        assertEquals(expected, actual!!)
    }

    @Test
    fun identifyJpeg2000() {
        val expected = Jpeg2000().fileType
        val actual = getFileTypeIdentifier("sample.jp2")

        assertNotNull(actual)
        assertEquals(expected, actual!!)
    }

    @Test
    fun identifyPng() {
        val expected = Png().fileType
        val actual = getFileTypeIdentifier("sample.png")

        assertNotNull(actual)
        assertEquals(expected, actual!!)
    }

    @Test
    fun identifyGif() {
        val expected = Gif().fileType
        val actual = getFileTypeIdentifier("sample.gif")

        assertNotNull(actual)
        assertEquals(expected, actual!!)
    }

    @Test
    fun identifyWebp() {
        val expected = Webp().fileType
        val actual = getFileTypeIdentifier("sample.webp")

        assertNotNull(actual)
        assertEquals(expected, actual!!)
    }

    @Test
    fun identifyCR2() {
        val expected = CR2().fileType
        val actual = getFileTypeIdentifier("sample.cr2")

        assertNotNull(actual)
        assertEquals(expected, actual!!)
    }

    @Test
    fun identifyTiff() {
        val expected = Tiff().fileType
        val actual = getFileTypeIdentifier("sample.tiff")

        assertNotNull(actual)
        assertEquals(expected, actual!!)
    }

    @Test
    fun identifyBmp() {
        val expected = Bmp().fileType
        val actual = getFileTypeIdentifier("sample.bmp")

        assertNotNull(actual)
        assertEquals(expected, actual!!)
    }

    @Test
    fun identifyJxr() {
        val expected = Jxr().fileType
        val actual = getFileTypeIdentifier("sample.jxr")

        assertNotNull(actual)
        assertEquals(expected, actual!!)
    }

    @Test
    fun identifyPsd() {
        val expected = Psd().fileType
        val actual = getFileTypeIdentifier("sample.psd")

        assertNotNull(actual)
        assertEquals(expected, actual!!)
    }

    @Test
    fun identifyIco() {
        val expected = Ico().fileType
        val actual = getFileTypeIdentifier("sample.ico")

        assertNotNull(actual)
        assertEquals(expected, actual!!)
    }

    @Test
    fun identifyHeif() {
        val expected = Heif().fileType
        val actual = getFileTypeIdentifier("sample.heif")

        assertNotNull(actual)
        assertEquals(expected, actual!!)
    }

    @Test
    fun identifyDwg() {
        val expected = Dwg().fileType
        val actual = getFileTypeIdentifier("sample.dwg")

        assertNotNull(actual)
        assertEquals(expected, actual!!)
    }

    @Test
    fun identifyExr() {
        val expected = Exr().fileType
        val actual = getFileTypeIdentifier("sample.exr")

        assertNotNull(actual)
        assertEquals(expected, actual!!)
    }

    @Test
    fun identifyAvif() {
        val expected = Avif().fileType
        val actual = getFileTypeIdentifier("sample.avif")

        assertNotNull(actual)
        assertEquals(expected, actual!!)
    }

    private fun getFileTypeIdentifier(fileName: String) = 
        getFileTypeIdentifier().identify(readResourceFileAsInputStream("/images/" + fileName))
}
