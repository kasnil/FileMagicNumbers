package com.github.kasnil.filemagicnumbers

import java.io.InputStream

abstract class FileSignature(
    extension: String,
    template: String,
) {
    val fileType: FileType = FileType(extension, MIME.from(template))
    abstract val signatures: Array<Signature>

    open fun isMatch(stream: InputStream): Boolean {
        for (signature in signatures) {
            try {
                stream.mark(signature.match.size)

                stream.skip(signature.offset)

                val buffer = ByteArray(signature.length) { 0 }

                val n = stream.read(buffer)
                if (buffer.size != signature.length) {
                    continue
                }

                if (isMatch(signature, buffer)) {
                    return true
                }
            } finally {
                stream.reset()
            }
        }

        return false
    }

    private fun isMatch(
        signature: Signature,
        buffer: ByteArray,
    ): Boolean {
        if (signature.length != buffer.size) {
            return false
        }

        for (index in 0..<signature.match.size) {
            val matchSignatureByte = signature.match[index]
            if (matchSignatureByte == null) {
                continue
            }
            if (matchSignatureByte != buffer[index]) {
                return false
            }
        }

        if (!signature.notMatch.isNullOrEmpty()) {
            for (index in 0..<signature.notMatch.size) {
                val notMatchSignatureByte = signature.notMatch[index]
                if (notMatchSignatureByte == null) {
                    continue
                }
                if (notMatchSignatureByte == buffer[index]) {
                    return false
                }
            }
        }

        return true
    }
}
