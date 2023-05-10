package com.stmik.utsabdul

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize

data class Motor(
    val imgMotor: Int,
    val nameMotor: String,
    val descMotor: String
): Parcelable
