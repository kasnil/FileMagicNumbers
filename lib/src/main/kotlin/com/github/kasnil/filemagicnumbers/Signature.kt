package com.github.kasnil.filemagicnumbers

import kotlin.math.max

data class Signature(
    val match: Array<Byte?>,
    val notMatch: Array<Byte?>? = null,
    val offset: Long = 0,
) {
    val length: Int
        get() = max(match.size, notMatch?.size ?: 0)
}

fun buildByteArray(vararg args: Int?) =
    args.foldIndexed(arrayOfNulls<Byte?>(args.size)) { index, acc, value ->
        acc.apply {
            set(index, value?.toByte())
        }
    }
