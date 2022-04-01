package com.binar.recyclerviewsample

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Contacts(val username : String,val phoneNumber : Long):Parcelable

