package com.shifthackz.aisdv1.feature.localdiffusion.cpp.di

import com.shifthackz.aisdv1.domain.feature.diffusion.LocalDiffusionCpp
import com.shifthackz.aisdv1.feature.localdiffusion.cpp.LocalDiffusionCppImpl
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.bind
import org.koin.dsl.module

val cppLocalDiffusionModule = module {
    factoryOf(::LocalDiffusionCppImpl) bind LocalDiffusionCpp::class
}
