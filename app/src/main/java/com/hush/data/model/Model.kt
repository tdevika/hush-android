package com.hush.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class HushItems(
        @SerializedName("items") @Expose var items: List<Hush>
)

data class Hush(
        @SerializedName("date") @Expose var date: String,
        @SerializedName("category") @Expose var category: String,
        @SerializedName("amount") @Expose var amount: Int,
        @SerializedName("note") @Expose var note: String
)
