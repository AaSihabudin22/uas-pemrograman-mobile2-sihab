package com.aasihabudin.datakaryawan.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Pegawai::class], version = 1, exportSchema = false)
abstract class PegawaiDatabase : RoomDatabase() {
    abstract fun pegawaiDao(): PegawaiDao

    companion object {
        @Volatile
        private var INSTANCE: PegawaiDatabase? = null

        fun getDatabase(context: Context): PegawaiDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    PegawaiDatabase::class.java,
                    "pegawai_database"
                ).fallbackToDestructiveMigration().build()
                INSTANCE = instance
                instance
            }
        }
    }
}
