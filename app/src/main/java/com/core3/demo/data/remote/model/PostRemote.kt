package com.core3.demo.data.remote.model

import com.google.gson.annotations.SerializedName

data class PostRemote(val id: Int?,
                      val userId: Int?,
                      val title: String?,
                      @SerializedName("body") val content: String?)
