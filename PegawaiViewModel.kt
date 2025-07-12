package com.aasihabudin.datakaryawan.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aasihabudin.datakaryawan.data.PegawaiDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import androidx.lifecycle.LiveData
import com.aasihabudin.datakaryawan.data.Pegawai

class PegawaiViewModel(
    private val dao: PegawaiDao
) : ViewModel() {

    // LiveData daftar semua pegawai
    val allPegawai: LiveData<List<Pegawai>> = dao.getAll()

    // Menambahkan pegawai baru
    fun insert(pegawai: Pegawai) = viewModelScope.launch(Dispatchers.IO) {
        dao.insert(pegawai)
    }

    // Memperbarui data pegawai
    fun update(pegawai: Pegawai) = viewModelScope.launch(Dispatchers.IO) {
        dao.update(pegawai)
    }

    // Menghapus pegawai
    fun delete(pegawai: Pegawai) = viewModelScope.launch(Dispatchers.IO) {
        dao.delete(pegawai)
    }
}
