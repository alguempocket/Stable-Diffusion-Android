package com.shifthackz.aisdv1.domain.usecase.generation

import com.shifthackz.aisdv1.domain.repository.LocalDiffusionOnnxGenerationRepository

internal class ObserveLocalDiffusionProcessStatusUseCaseImpl(
    private val localDiffusionOnnxGenerationRepository: LocalDiffusionOnnxGenerationRepository,
) : ObserveLocalDiffusionProcessStatusUseCase {

    override fun invoke() = localDiffusionOnnxGenerationRepository
        .observeStatus()
        .distinctUntilChanged()
}
