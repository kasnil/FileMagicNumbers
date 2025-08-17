package com.github.kasnil.filemagicnumbers

import java.io.InputStream

class FileTypeIdentifier(
    val fileSignatureLocator: SignatureLocator<FileSignature>,
) {
    fun identify(stream: InputStream) =
        fileSignatureLocator.signatures
            .firstOrNull { fs ->
                fs.isMatch(stream)
            }?.fileType
}
