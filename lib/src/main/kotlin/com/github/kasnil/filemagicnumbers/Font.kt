package com.github.kasnil.filemagicnumbers

class Woff : FileSignature("woff", "font/woff") {
    override val signatures: Array<Signature>
        get() = arrayOf(Signature(buildByteArray(0x77, 0x4F, 0x46, 0x46)))
}

class Woff2 : FileSignature("woff2", "font/woff2") {
    override val signatures: Array<Signature>
        get() = arrayOf(Signature(buildByteArray(0x77, 0x4F, 0x46, 0x32)))
}

class Ttf : FileSignature("ttf", "font/ttf") {
    override val signatures: Array<Signature>
        get() = arrayOf(Signature(buildByteArray(0x00, 0x01, 0x00, 0x00, 0x00)))
}

class Otf : FileSignature("otf", "font/otf") {
    override val signatures: Array<Signature>
        get() = arrayOf(Signature(buildByteArray(0x4F, 0x54, 0x54, 0x4F)))
}
