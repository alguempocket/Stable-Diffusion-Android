package com.shifthackz.aisdv1.feature.localdiffusion.onnx.extensions

import com.shifthackz.aisdv1.core.common.file.FileProviderDescriptor
import com.shifthackz.aisdv1.domain.entity.LocalAiModel
import com.shifthackz.aisdv1.domain.preference.PreferenceManager
import com.shifthackz.aisdv1.feature.localdiffusion.onnx.environment.LocalOnnxModelIdProvider

internal fun modelPathPrefix(
    preferenceManager: PreferenceManager,
    fileProviderDescriptor: FileProviderDescriptor,
    localOnnxModelIdProvider: LocalOnnxModelIdProvider,
): String {
    val modelId = localOnnxModelIdProvider.get()
    return if (modelId == LocalAiModel.CustomOnnx.id) {
        preferenceManager.localOnnxCustomModelPath
    } else {
        "${fileProviderDescriptor.localModelDirPath}/${modelId}"
    }
}
