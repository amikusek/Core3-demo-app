package com.core3.demo.data.remote.model

import com.google.gson.annotations.SerializedName

data class CommentRemote(val id: Int?,
                         val email: String?,
                         @SerializedName("name") val title: String?,
                         @SerializedName("body") val content: String?)
