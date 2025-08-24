package com.github.kasnil.filemagicnumbers

fun ByteArray.toPosUInt(index: Int) = this[index].toUInt() and 0xFFu

fun ByteArray.toUIntShl(
    index: Int,
    shift: Int = 0,
) = this.toPosUInt(index) shl shift

fun ByteArray.getUIntAt(
    index: Int,
    bigEndian: Boolean = true,
): UInt =
    if (bigEndian) {
        toUIntShl(index, 24) or
            toUIntShl(index + 1, 16) or
            toUIntShl(index + 2, 8) or
            toUIntShl(index + 3)
    } else {
        toUIntShl(index + 3, 24) or
            toUIntShl(index + 2, 16) or
            toUIntShl(index + 1, 8) or
            toUIntShl(index)
    }
