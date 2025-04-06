package com.shifthackz.aisdv1.feature.localdiffusion.onnx.environment

import ai.onnxruntime.OrtEnvironment

internal class OrtEnvironmentProviderImpl : OrtEnvironmentProvider {

    private val environment: OrtEnvironment = OrtEnvironment.getEnvironment()

    override fun get(): OrtEnvironment {
        return environment
    }
}
