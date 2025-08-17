package com.github.kasnil.filemagicnumbers

interface SignatureLocator<T> {
    val signatures: Array<T>
}
