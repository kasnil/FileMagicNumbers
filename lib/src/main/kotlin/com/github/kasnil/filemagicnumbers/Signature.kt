package com.github.kasnil.filemagicnumbers

data class Signature(
    val match: Array<SignatureMatcher>,
    val notMatch: Array<SignatureMatcher>? = null,
) {
    constructor(match: SignatureMatcher, notMatch: SignatureMatcher? = null) : this(
        arrayOf(match),
        if (notMatch != null) arrayOf(notMatch) else null,
    ) {
    }

    constructor(matchSignature: Array<Byte?>, notMatchSignature: Array<Byte?>? = null) : this(
        arrayOf(SignatureMatcher(matchSignature)),
        if (notMatchSignature != null) arrayOf(SignatureMatcher(notMatchSignature)) else null,
    ) {
    }
}

fun buildByteArray(vararg args: Int?) =
    args.foldIndexed(arrayOfNulls<Byte?>(args.size)) { index, acc, value ->
        acc.apply {
            set(index, value?.toByte())
        }
    }
