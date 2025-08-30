package com.github.kasnil.filemagicnumbers

class Midi : FileSignature("mid", "audio/midi") {
    override val signatures: Array<Signature>
        get() = arrayOf(Signature(buildByteArray(0x4D, 0x54, 0x68, 0x64)))
}

class Mp3 : FileSignature("mp3", "audio/mpeg") {
    override val signatures: Array<Signature>
        get() =
            arrayOf(
                Signature(buildByteArray(0x49, 0x44, 0x33)),
                Signature(buildByteArray(0xFF, 0xF3)),
                Signature(buildByteArray(0xFF, 0xFA)),
                Signature(buildByteArray(0xFF, 0xFB)),
            )
}

class M4a : FileSignature("m4a", "audio/mp4") {
    override val signatures: Array<Signature>
        get() =
            arrayOf(
                Signature(arrayOf(SignatureMatcher(buildByteArray(0x1C, 0x66, 0x74, 0x79, 0x70, 0x4D, 0x34, 0x41), offset = 3L))),
                Signature(buildByteArray(0x66, 0x74, 0x79, 0x70, 0x4D, 0x34, 0x41, 0x4D, 0x34, 0x41, 0x20)),
            )
}

class Ogg : FileSignature("ogg", "audio/ogg") {
    override val signatures: Array<Signature>
        get() = arrayOf(Signature(buildByteArray(0x4F, 0x67, 0x67, 0x53)))
}

class Flac : FileSignature("flac", "audio/x-flac") {
    override val signatures: Array<Signature>
        get() = arrayOf(Signature(buildByteArray(0x66, 0x4C, 0x61, 0x43)))
}

class Wav : FileSignature("wav", "audio/x-wav") {
    override val signatures: Array<Signature>
        get() = arrayOf(Signature(buildByteArray(0x52, 0x49, 0x46, 0x46, null, null, null, null, 0x57, 0x41, 0x56, 0x45)))
}

class Amr : FileSignature("amr", "audio/amr") {
    override val signatures: Array<Signature>
        get() = arrayOf(Signature(buildByteArray(0x23, 0x21, 0x41, 0x4D, 0x52)))
}

class Aac : FileSignature("aac", "audio/aac") {
    override val signatures: Array<Signature>
        get() = arrayOf(Signature(buildByteArray(0xFF, 0xF1)), Signature(buildByteArray(0xFF, 0xF9)))
}

class Aiff : FileSignature("aiff", "audio/x-aiff") {
    override val signatures: Array<Signature>
        get() = arrayOf(Signature(buildByteArray(0x46, 0x4F, 0x52, 0x4D, null, null, null, null, 0x41, 0x49, 0x46, 0x46)))
}
