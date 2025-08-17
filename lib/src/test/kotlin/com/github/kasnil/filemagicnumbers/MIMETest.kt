package com.github.kasnil.filemagicnumbers

import kotlin.test.Test
import kotlin.test.assertEquals

class MIMETest {
    @Test
    fun createMIME() {
        val cases =
            arrayOf(
                arrayOf("audio/ogg", "audio", "ogg"),
                arrayOf("/ogg", "", "ogg"),
                arrayOf("audio/", "audio", ""),
                arrayOf("/", "", ""),
                arrayOf("audio", "audio", ""),
            )
        for (case in cases) {
            val mime = MIME.from(case[0])
            assertEquals(case[0], mime.template)
            assertEquals(case[1], mime.type)
            assertEquals(case[2], mime.subtype)
        }
    }
}
