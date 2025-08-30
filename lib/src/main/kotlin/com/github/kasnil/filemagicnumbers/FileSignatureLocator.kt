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
                Psd(),
                Ico(),
                Heif(),
                Dwg(),
                Exr(),
                Avif(),

                Woff(),
                Woff2(),
                Ttf(),
                Otf(),

                Midi(),
                Mp3(),
                M4a(),
                Ogg(),
                Flac(),
                Wav(),
                Amr(),
                Aac(),
                Aiff(),
            )
}
