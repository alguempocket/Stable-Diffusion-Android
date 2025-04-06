package com.shifthackz.aisdv1.domain.usecase.settings

import io.reactivex.rxjava3.core.Single

interface ConnectToLocalDiffusionOnnxUseCase {
    operator fun invoke(modelId: String): Single<Result<Unit>>
}
