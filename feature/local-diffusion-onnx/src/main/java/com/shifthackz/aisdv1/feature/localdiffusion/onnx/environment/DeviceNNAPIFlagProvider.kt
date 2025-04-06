package com.shifthackz.aisdv1.feature.localdiffusion.onnx.environment

fun interface DeviceNNAPIFlagProvider {
    fun get(): Int
}
