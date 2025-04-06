package com.shifthackz.aisdv1.feature.localdiffusion.cpp.entity

data class SDImage(
    val width: Int,
    val height: Int,
    val channel: Int,
    val data: ByteArray,
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as SDImage

        if (width != other.width) return false
        if (height != other.height) return false
        if (channel != other.channel) return false
        if (!data.contentEquals(other.data)) return false

        return true
    }

    override fun hashCode(): Int {
        var result = width
        result = 31 * result + height
        result = 31 * result + channel
        result = 31 * result + data.contentHashCode()
        return result
    }
}
