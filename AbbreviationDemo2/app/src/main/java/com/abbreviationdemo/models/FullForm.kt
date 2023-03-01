package com.abbreviationdemo.models

import com.google.gson.annotations.SerializedName

data class FullForm(
    @SerializedName("lf") val lf: String,
    @SerializedName("freq") val freq: Int,
    @SerializedName("since") val year: String,
    @SerializedName("vars") val list: List<FullForm>
)
