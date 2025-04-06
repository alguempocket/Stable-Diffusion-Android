package com.shifthackz.aisdv1.feature.localdiffusion.cpp

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import com.shifthackz.aisdv1.core.common.file.FileProviderDescriptor
import com.shifthackz.aisdv1.core.common.schedulers.SchedulersProvider
import com.shifthackz.aisdv1.domain.entity.TextToImagePayload
import com.shifthackz.aisdv1.domain.feature.diffusion.LocalDiffusionCpp
import com.shifthackz.aisdv1.domain.preference.PreferenceManager
import com.shifthackz.aisdv1.feature.localdiffusion.cpp.entity.Backend
import com.shifthackz.aisdv1.feature.localdiffusion.cpp.entity.SDImage
import com.shifthackz.aisdv1.feature.localdiffusion.cpp.entity.SDType
import com.shifthackz.aisdv1.feature.localdiffusion.cpp.entity.SampleMethod
import com.shifthackz.aisdv1.feature.localdiffusion.cpp.environment.LocalCppModelIdProvider
import com.shifthackz.aisdv1.feature.localdiffusion.cpp.extensions.modelPathPrefix
import io.reactivex.rxjava3.core.Single

internal class LocalDiffusionCppImpl(
    private val preferenceManager: PreferenceManager,
    private val fileProviderDescriptor: FileProviderDescriptor,
    private val localCppModelIdProvider: LocalCppModelIdProvider,
    private val schedulersProvider: SchedulersProvider,
) : LocalDiffusionCpp {

    override fun process(payload: TextToImagePayload): Single<Bitmap> = Single.fromCallable {
        val libStableDiffusion = LibStableDiffusion(Backend.OpenCL)

        val ctx = libStableDiffusion.newSdContext(
            modelPath = modelPathPrefix(preferenceManager, fileProviderDescriptor, localCppModelIdProvider) + "model.safetensors",
            clipLPath = "",
            clipGPath = "",
            t5xxlPath = "",
            diffusionModelPath = "",
            vaePath = "",
            taesdPath = "",
            controlNetPathCStr = "",
            loraModelDir = "",
            embedDirCStr = "",
            stackedIdEmbedDirCStr = "",
            vaeDecodeOnly = false,
            vaeTiling = false,
            freeParamsImmediately = false,
            nThreads = libStableDiffusion.getNumPhysicalCores() * 2,
            wtype = SDType.NONE.ordinal,
            rngType = 0,
            scheduleType = 0,
            keepClipOnCpu = false,
            keepControlNetCpu = false,
            keepVaeOnCpu = false,
            diffusionFlashAttn = false
        )

        val result = libStableDiffusion.txt2img(
            sdCtx = ctx,
            prompt = payload.prompt,
            negativePrompt = payload.negativePrompt,
            clipSkip = 2,
            cfgScale = payload.cfgScale,
            guidance = 0f,
            eta = 0f,
            width = payload.width,
            height = payload.height,
            sampleMethod = SampleMethod.EULER,
            sampleSteps = payload.samplingSteps,
            seed = payload.seed.toLongOrNull() ?: 0L,
            batchCount = 1,
            controlCond = null,
            controlStrength = 1.0f,
            styleStrength = 0f,
            normalizeInput = false,
            inputIdImagesPath = null,
            skipLayers = null,
            skipLayersCount = 0,
            slgScale = 0f,
            skipLayerStart = 0f,
            skipLayerEnd = 0f,
        )

        val bitmap = convertSDImageToBitmap(result)

        bitmap
    }

    private fun convertSDImageToBitmap(sdImage: SDImage): Bitmap {
        if (sdImage.channel != 3) {
            throw IllegalArgumentException("Unexpected channel count: ${sdImage.channel}")
        }

        val width = sdImage.width
        val height = sdImage.height
        val bytes = sdImage.data

        val rgbaBytes = ByteArray(width * height * 4)

        for (i in 0 until width * height) {
            rgbaBytes[i * 4] = bytes[i * 3]
            rgbaBytes[i * 4 + 1] = bytes[i * 3 + 1]
            rgbaBytes[i * 4 + 2] = bytes[i * 3 + 2]
            rgbaBytes[i * 4 + 3] = 255.toByte()
        }

        return BitmapFactory.decodeByteArray(rgbaBytes, 0, rgbaBytes.size)
    }
}
