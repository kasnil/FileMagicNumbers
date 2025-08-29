package com.github.kasnil.filemagicnumbers

import java.io.InputStream

abstract class FileSignature(
    extension: String,
    template: String,
) {
    val fileType: FileType = FileType(extension, MIME.from(template))
    abstract val signatures: Array<Signature>

    open fun isMatch(stream: InputStream) =
        signatures.any { signature ->
            signature.match?.all { matcher -> isMatch(matcher, stream) } ?: true &&
                signature.notMatch?.all { matcher -> isNotMatch(matcher, stream) } ?: true
        }

    private fun isMatch(
        matcher: SignatureMatcher?,
        stream: InputStream,
    ): Boolean {
        if (matcher == null) {
            return true
        }
        try {
            stream.mark(matcher.value.size)

            stream.skip(matcher.offset)

            val buffer = ByteArray(matcher.value.size) { 0 }

            val n = stream.read(buffer)
            if (n != matcher.value.size) {
                return false
            }

            for (index in 0..<matcher.value.size) {
                val matchSignatureByte = matcher.value[index]
                if (matchSignatureByte == null) {
                    continue
                }
                if (matchSignatureByte != buffer[index]) {
                    return false
                }
            }
            return true
        } finally {
            stream.reset()
        }
    }

    private fun isNotMatch(
        matcher: SignatureMatcher?,
        stream: InputStream,
    ): Boolean {
        if (matcher == null) {
            return true
        }
        try {
            stream.mark(matcher.value.size)

            stream.skip(matcher.offset)

            val buffer = ByteArray(matcher.value.size) { 0 }

            val n = stream.read(buffer)
            if (n != matcher.value.size) {
                return false
            }

            for (index in 0..<matcher.value.size) {
                val notMatchSignatureByte = matcher.value[index]
                if (notMatchSignatureByte == null) {
                    continue
                }
                if (notMatchSignatureByte == buffer[index]) {
                    return false
                }
            }
            return true
        } finally {
            stream.reset()
        }
    }
}
