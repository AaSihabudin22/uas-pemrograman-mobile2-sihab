package com.aasihabudin.datakaryawan.data

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "pegawai")
data class Pegawai(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val nama: String,
    val jabatan: String
) : Parcelable




