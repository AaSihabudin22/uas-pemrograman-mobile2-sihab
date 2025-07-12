package com.aasihabudin.datakaryawan.data

import androidx.lifecycle.LiveData
import androidx.room.*
@Dao
interface PegawaiDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(pegawai: Pegawai)

    @Update
    suspend fun update(pegawai: Pegawai)

    @Delete
    suspend fun delete(pegawai: Pegawai)

    @Query("SELECT * FROM pegawai ORDER BY id DESC")
    fun getAll(): LiveData<List<Pegawai>>
}
