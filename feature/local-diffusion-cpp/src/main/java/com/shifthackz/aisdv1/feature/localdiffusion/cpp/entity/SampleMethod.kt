package com.shifthackz.aisdv1.feature.localdiffusion.cpp.entity

enum class SampleMethod(val value: Int) {
    EULER_A(0),
    EULER(1),
    HEUN(2),
    DPM2(3),
    DPMPP2S_A(4),
    DPMPP2M(5),
    DPMPP2Mv2(6),
    IPNDM(7),
    IPNDM_V(8),
    LCM(9),
    DDIM_TRAILING(10),
    TCD(11),
    N_SAMPLE_METHODS(12);

    companion object {
        fun fromInt(value: Int): SampleMethod {
            return entries.firstOrNull { it.value == value }
                ?: throw IllegalArgumentException("Unknown SampleMethod value: $value")
        }
    }
}
