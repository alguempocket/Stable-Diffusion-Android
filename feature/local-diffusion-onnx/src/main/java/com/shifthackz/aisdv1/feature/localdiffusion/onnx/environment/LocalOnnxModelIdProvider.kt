package com.shifthackz.aisdv1.feature.localdiffusion.onnx.environment

fun interface LocalOnnxModelIdProvider {
    fun get(): String
}
