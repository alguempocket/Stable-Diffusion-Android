package com.shifthackz.aisdv1.app.di

import com.shifthackz.aisdv1.feature.auth.di.authModule
import com.shifthackz.aisdv1.feature.localdiffusion.cpp.di.cppLocalDiffusionModule
import com.shifthackz.aisdv1.feature.localdiffusion.onnx.di.onnxLocalDiffusionModule
import com.shifthackz.aisdv1.feature.mediapipe.di.mediaPipeModule

val featureModule = arrayOf(
    authModule,
    cppLocalDiffusionModule,
    onnxLocalDiffusionModule,
    mediaPipeModule,
)
