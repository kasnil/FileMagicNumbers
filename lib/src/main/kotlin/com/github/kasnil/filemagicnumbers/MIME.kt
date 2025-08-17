package com.github.kasnil.filemagicnumbers

data class MIME(
    val type: String,
    val subtype: String,
    val template: String,
) {
    companion object {
        fun from(mime: String): MIME {
            val terms = mime.split("/")
            val type: String
            var subtype = ""
            if (terms.size > 1) {
                type = terms[0]
                subtype = terms[1]
            } else {
                type = terms[0]
            }

            return MIME(type, subtype, mime)
        }
    }
}
