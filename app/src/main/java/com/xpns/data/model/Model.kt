package com.xpns.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class XpnsItems(
        @SerializedName("items") @Expose var items: List<Xpns>
)

data class Xpns(
        @SerializedName("date") @Expose var date: String,
        @SerializedName("category") @Expose var category: String,
        @SerializedName("amount") @Expose var amount: Int,
        @SerializedName("note") @Expose var note: String
)
