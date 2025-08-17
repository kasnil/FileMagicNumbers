package com.github.kasnil.filemagicnumbers

open class FileTypeIdentifierTest {
    internal fun readResourceFileAsInputStream(fileName: String) = javaClass.getResource(fileName)!!.openStream()

    internal fun getFileTypeIdentifier() = FileTypeIdentifier(FileSignatureLocator())
}