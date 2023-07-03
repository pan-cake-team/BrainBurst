package com.pancake.brainburst.data.source.remote.models

data class BaseResponse<T>(
    val value: T?,
    val isSuccess: Boolean,
)
