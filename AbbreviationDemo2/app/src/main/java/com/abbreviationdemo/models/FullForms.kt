package com.abbreviationdemo.models

import com.google.gson.annotations.SerializedName

data class FullForms(
    @SerializedName("sf") val sf: String,
    @SerializedName("lfs") val list: List<FullForm>
)
