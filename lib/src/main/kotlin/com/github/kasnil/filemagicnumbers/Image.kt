package com.github.kasnil.filemagicnumbers

class Jpeg : FileSignature("jpg", "image/jpeg") {
    override val signatures: Array<Signature>
        get() = arrayOf(Signature(buildByteArray(0xFF, 0xD8, 0xFF)))
}

class Jpeg2000 : FileSignature("jp2", "image/jp2") {
    override val signatures: Array<Signature>
        get() = arrayOf(Signature(buildByteArray(0x00, 0x00, 0x00, 0x0C, 0x6A, 0x50, 0x20, 0x20, 0x0D, 0x0A, 0x87, 0x0A, 0x00)))
}

class Png : FileSignature("png", "image/png") {
    override val signatures: Array<Signature>
        get() = arrayOf(Signature(buildByteArray(0x89, 0x50, 0x4E, 0x47)))
}

class Gif : FileSignature("gif", "image/gif") {
    override val signatures: Array<Signature>
        get() = arrayOf(Signature(buildByteArray(0x47, 0x49, 0x46)))
}

class Webp : FileSignature("webp", "image/webp") {
    override val signatures: Array<Signature>
        get() = arrayOf(Signature(buildByteArray(0x57, 0x45, 0x42, 0x50), offset = 8L))
}

class CR2 : FileSignature("cr2", "image/x-canon-cr2") {
    override val signatures: Array<Signature>
        get() =
            arrayOf(
                Signature(buildByteArray(0x49, 0x49, 0x2A, 0x00, null, null, null, null, 0x43, 0x52, 0x02)),
                Signature(buildByteArray(0x4D, 0x4D, 0x00, 0x2A, null, null, null, null, 0x43, 0x52, 0x02)),
            )
}

class Tiff : FileSignature("tif", "image/tiff") {
    override val signatures: Array<Signature>
        get() =
            arrayOf(
                Signature(
                    buildByteArray(0x49, 0x49, 0x2A, 0x00),
                    buildByteArray(null, null, null, null, null, null, null, null, 0x43, 0x52),
                ),
                Signature(
                    buildByteArray(0x4D, 0x4D, 0x00, 0x2A),
                    buildByteArray(null, null, null, null, null, null, null, null, 0x43, 0x52),
                ),
            )
}

class Bmp : FileSignature("bmp", "image/bmp") {
    override val signatures: Array<Signature>
        get() = arrayOf(Signature(buildByteArray(0x42, 0x4D)))
}

class Jxr : FileSignature("jxr", "image/vnd.ms-photo") {
    override val signatures: Array<Signature>
        get() = arrayOf(Signature(buildByteArray(0x49, 0x49, 0xBC)))
}

class Psd : FileSignature("psd", "image/vnd.adobe.photoshop") {
    override val signatures: Array<Signature>
        get() = arrayOf(Signature(buildByteArray(0x38, 0x42, 0x50, 0x53)))
}
