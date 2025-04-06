package com.shifthackz.aisdv1.feature.localdiffusion.onnx.environment

import ai.onnxruntime.OrtEnvironment

internal fun interface OrtEnvironmentProvider {
    fun get(): OrtEnvironment
}
