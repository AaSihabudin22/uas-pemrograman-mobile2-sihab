package com.aasihabudin.datakaryawan.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.aasihabudin.datakaryawan.data.PegawaiDao

class PegawaiViewModelFactory(
    private val dao: PegawaiDao
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(PegawaiViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return PegawaiViewModel(dao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
