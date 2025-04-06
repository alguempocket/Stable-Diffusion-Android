package com.shifthackz.aisdv1.feature.localdiffusion.cpp.extensions

import com.shifthackz.aisdv1.core.common.file.FileProviderDescriptor
import com.shifthackz.aisdv1.domain.entity.LocalAiModel
import com.shifthackz.aisdv1.domain.preference.PreferenceManager
import com.shifthackz.aisdv1.feature.localdiffusion.cpp.environment.LocalCppModelIdProvider

internal fun modelPathPrefix(
    preferenceManager: PreferenceManager,
    fileProviderDescriptor: FileProviderDescriptor,
    localCppModelIdProvider: LocalCppModelIdProvider,
): String {
    val modelId = localCppModelIdProvider.get()
    return if (modelId == LocalAiModel.CustomOnnx.id) {
        preferenceManager.localOnnxCustomModelPath
    } else {
       "${fileProviderDescriptor.localModelDirPath}/${modelId}"
    }
}
