package com.github.kasnil.filemagicnumbers

class Woff : FileSignature("woff", "application/font-woff") {
    override val signatures: Array<Signature>
        get() = arrayOf(Signature(buildByteArray(0x77, 0x4F, 0x46, 0x46)))
}