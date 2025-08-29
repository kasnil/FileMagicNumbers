package com.github.kasnil.filemagicnumbers

data class SignatureMatcher(
    val value: Array<Byte?>,
    val offset: Long = 0,)