package com.rizky.submissiononemoviecatalogue

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Movie(
    var photo: Int,
    var title: String,
    var release: String,
    var sutradara: String,
    var description: String
) : Parcelable