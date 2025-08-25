package com.github.kasnil.filemagicnumbers

import java.io.InputStream
import kotlin.collections.toString

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

class Ico : FileSignature("ico", "image/vnd.microsoft.icon") {
    override val signatures: Array<Signature>
        get() = arrayOf(Signature(buildByteArray(0x00, 0x00, 0x01, 0x00)))
}

class Heif : FileSignature("heif", "image/heif") {
    override val signatures: Array<Signature>
        get() = arrayOf()

    override fun isMatch(stream: InputStream): Boolean {
        val ftypLength: Int
        val charset = Charsets.US_ASCII
        val majorBrand: String
        val minorVersion: String
        try {
            val size = 16

            stream.mark(size)

            val buffer = ByteArray(size) { 0 }
            val n = stream.read(buffer)

            if (buffer.size != n) {
                return false
            }

            val format = buffer.slice(4..<8).toByteArray().toString(charset)
            if (format != "ftyp") {
                return false
            }

            majorBrand = buffer.slice(8..<12).toByteArray().toString(charset)
            if (majorBrand == "heic") {
                return true
            }

            minorVersion = buffer.slice(12..<16).toByteArray().toString(charset)
            if ((majorBrand != "mif1") && (majorBrand != "msf1")) {
                return false
            }

            ftypLength = buffer.getUIntAt(0).toInt()
            if (ftypLength < buffer.size) {
                return false
            }
        } finally {
            stream.reset()
        }

        try {
            stream.mark(ftypLength)

            val offset = 16L
            val size = ftypLength - offset.toInt()

            stream.skip(offset)

            val buffer = ByteArray(size) { 0 }
            val n = stream.read(buffer)

            if (buffer.size != n) {
                return false
            }

            val compatibleBrands = mutableListOf<String>()
            for (i in (0..<buffer.size).step(4)) {
                if (buffer.size >= (i + 4)) {
                    compatibleBrands += buffer.slice(i..<(i + 4)).toByteArray().toString(charset)
                }
            }

            if (compatibleBrands.any { compatibleBrand -> compatibleBrand == "heic" }) {
                return true
            }

            return false
        } finally {
            stream.reset()
        }
    }
}

class Dwg : FileSignature("dwg", "image/vnd.dwg") {
    override val signatures: Array<Signature>
        get() = arrayOf(Signature(buildByteArray(0x41, 0x43, 0x31, 0x30)))
}

class Exr : FileSignature("exr", "image/x-exr") {
    override val signatures: Array<Signature>
        get() = arrayOf(Signature(buildByteArray(0x76, 0x2F, 0x31, 0x01)))
}
