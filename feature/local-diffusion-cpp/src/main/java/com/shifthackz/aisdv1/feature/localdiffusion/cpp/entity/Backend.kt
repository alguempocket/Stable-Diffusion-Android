package com.shifthackz.aisdv1.feature.localdiffusion.cpp.entity

enum class Backend(val libraryName: String) {
    Vulkan("stable-diffusion_vulkan"),
    OpenCL("stable-diffusion_opencl"),
    Cpu("stable-diffusion");
}
