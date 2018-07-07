package com.core3.demo.data.entity

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Post(val id: Int,
                val userId: Int,
                val title: String,
                val content: String) : Parcelable
