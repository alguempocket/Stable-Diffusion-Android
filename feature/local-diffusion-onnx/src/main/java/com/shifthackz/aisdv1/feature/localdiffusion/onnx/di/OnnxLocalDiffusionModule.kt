package com.shifthackz.aisdv1.feature.localdiffusion.onnx.di

import com.shifthackz.aisdv1.domain.feature.diffusion.LocalDiffusionONNX
import com.shifthackz.aisdv1.feature.localdiffusion.onnx.LocalDiffusionONNXImpl
import com.shifthackz.aisdv1.feature.localdiffusion.onnx.ai.tokenizer.EnglishTextTokenizer
import com.shifthackz.aisdv1.feature.localdiffusion.onnx.ai.tokenizer.LocalDiffusionTextTokenizer
import com.shifthackz.aisdv1.feature.localdiffusion.onnx.ai.unet.UNet
import com.shifthackz.aisdv1.feature.localdiffusion.onnx.environment.OrtEnvironmentProvider
import com.shifthackz.aisdv1.feature.localdiffusion.onnx.environment.OrtEnvironmentProviderImpl
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val onnxLocalDiffusionModule = module {
    singleOf(::UNet)
    singleOf(::EnglishTextTokenizer) bind LocalDiffusionTextTokenizer::class
    singleOf(::LocalDiffusionONNXImpl) bind LocalDiffusionONNX::class
    singleOf(::OrtEnvironmentProviderImpl) bind OrtEnvironmentProvider::class
}
