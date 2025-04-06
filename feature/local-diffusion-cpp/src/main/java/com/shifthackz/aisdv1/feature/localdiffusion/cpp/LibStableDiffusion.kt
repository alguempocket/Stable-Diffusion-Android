package com.shifthackz.aisdv1.feature.localdiffusion.cpp

import com.shifthackz.aisdv1.feature.localdiffusion.cpp.entity.Backend
import com.shifthackz.aisdv1.feature.localdiffusion.cpp.entity.SDImage
import com.shifthackz.aisdv1.feature.localdiffusion.cpp.entity.SDLogCallback
import com.shifthackz.aisdv1.feature.localdiffusion.cpp.entity.SDProgressCallback
import com.shifthackz.aisdv1.feature.localdiffusion.cpp.entity.SampleMethod

internal class LibStableDiffusion(backend: Backend) {

    init {
        System.loadLibrary(backend.libraryName)
    }

    external fun getNumPhysicalCores(): Int

    external fun sdSetLogCallback(sdLogCb: SDLogCallback, data: Long)

    external fun sdSetProgressCallback(sdProgressCb: SDProgressCallback, data: Long)

    external fun newSdContext(
        modelPath: String,
        clipLPath: String,
        clipGPath: String,
        t5xxlPath: String,
        diffusionModelPath: String,
        vaePath: String,
        taesdPath: String,
        controlNetPathCStr: String,
        loraModelDir: String,
        embedDirCStr: String,
        stackedIdEmbedDirCStr: String,
        vaeDecodeOnly: Boolean,
        vaeTiling: Boolean,
        freeParamsImmediately: Boolean,
        nThreads: Int,
        wtype: Int,
        rngType: Int,
        scheduleType: Int,
        keepClipOnCpu: Boolean,
        keepControlNetCpu: Boolean,
        keepVaeOnCpu: Boolean,
        diffusionFlashAttn: Boolean
    ): Long

    external fun txt2img(
        sdCtx: Long,
        prompt: String,
        negativePrompt: String,
        clipSkip: Int,
        cfgScale: Float,
        guidance: Float,
        eta: Float,
        width: Int,
        height: Int,
        sampleMethod: SampleMethod,
        sampleSteps: Int,
        seed: Long,
        batchCount: Int,
        controlCond: SDImage?,
        controlStrength: Float,
        styleStrength: Float,
        normalizeInput: Boolean,
        inputIdImagesPath: String?,
        skipLayers: IntArray?,
        skipLayersCount: Long,
        slgScale: Float,
        skipLayerStart: Float,
        skipLayerEnd: Float
    ): SDImage

    external fun freeSdCtx(ctx: Long)

    external fun freeUpscalerCtx(ctx: Long)
}
