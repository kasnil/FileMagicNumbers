package com.github.kasnil.filemagicnumbers

class FileSignatureLocator : SignatureLocator<FileSignature> {
    override val signatures: Array<FileSignature>
        get() =
            arrayOf(
                Jpeg(),
                Jpeg2000(),
                Png(),
                Gif(),
                Webp(),
                CR2(),
                Tiff(),
                Bmp(),
                Jxr(),
            )
}
