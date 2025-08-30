package com.github.kasnil.filemagicnumbers

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotNull

class AudioFileTypeIdentifierTest : FileTypeIdentifierTest() {
    @Test
    fun identifyMidi() {
        val expected = Midi().fileType
        val actual = getFileTypeIdentifier(expected)

        assertNotNull(actual)
        assertEquals(expected, actual!!)
    }

    @Test
    fun identifyMp3() {
        val expected = Mp3().fileType
        val actual = getFileTypeIdentifier(expected)

        assertNotNull(actual)
        assertEquals(expected, actual!!)
    }

    @Test
    fun identifyM4a() {
        val expected = M4a().fileType
        val actual = getFileTypeIdentifier(expected)

        assertNotNull(actual)
        assertEquals(expected, actual!!)
    }

    @Test
    fun identifyOgg() {
        val expected = Ogg().fileType
        val actual = getFileTypeIdentifier(expected)

        assertNotNull(actual)
        assertEquals(expected, actual!!)
    }

    @Test
    fun identifyFlac() {
        val expected = Flac().fileType
        val actual = getFileTypeIdentifier(expected)

        assertNotNull(actual)
        assertEquals(expected, actual!!)
    }

    @Test
    fun identifyWav() {
        val expected = Wav().fileType
        val actual = getFileTypeIdentifier(expected)

        assertNotNull(actual)
        assertEquals(expected, actual!!)
    }

    @Test
    fun identifyAmr() {
        val expected = Amr().fileType
        val actual = getFileTypeIdentifier(expected)

        assertNotNull(actual)
        assertEquals(expected, actual!!)
    }

    @Test
    fun identifyAac() {
        val expected = Aac().fileType
        val actual = getFileTypeIdentifier(expected)

        assertNotNull(actual)
        assertEquals(expected, actual!!)
    }

    @Test
    fun identifyAiff() {
        val expected = Aiff().fileType
        val actual = getFileTypeIdentifier(expected)

        assertNotNull(actual)
        assertEquals(expected, actual!!)
    }

    private fun getFileTypeIdentifier(fileType: FileType) =
        getFileTypeIdentifier().identify(readResourceFileAsInputStream("/audios/sample." + fileType.extension))
}
