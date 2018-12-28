package com.xpns.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class RepositoriesResponse(
        @SerializedName("total_count") @Expose var totalCount: Int,
        @SerializedName("incomplete_results") @Expose var incompleteResults: Boolean,
        @SerializedName("items") @Expose var items: List<Item>)

data class Item(
        @SerializedName("id") @Expose var id: Int,
        @SerializedName("name") @Expose var name: String,
        @SerializedName("owner") @Expose var owner: Owner,
        @SerializedName("description") @Expose var description: String,
        @SerializedName("subscribers_url") @Expose var subscribersUrl: String,
        @SerializedName("forks_count") @Expose var forksCount: Int
)

data class Owner(
        @SerializedName("login") @Expose var login: String,
        @SerializedName("id") @Expose var id: Int,
        @SerializedName("avatar_url") @Expose var avatarUrl: String
)

data class Subscribers(
        @SerializedName("login") @Expose var login: String,
        @SerializedName("id") @Expose var id: Int,
        @SerializedName("avatar_url") @Expose var avatarUrl: String
)
