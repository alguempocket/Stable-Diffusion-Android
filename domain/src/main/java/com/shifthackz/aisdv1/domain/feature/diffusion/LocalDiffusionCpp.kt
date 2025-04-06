package com.shifthackz.aisdv1.domain.feature.diffusion

import android.graphics.Bitmap
import com.shifthackz.aisdv1.domain.entity.TextToImagePayload
import io.reactivex.rxjava3.core.Single

interface LocalDiffusionCpp {
    fun process(payload: TextToImagePayload): Single<Bitmap>
}
