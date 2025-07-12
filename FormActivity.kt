package com.aasihabudin.datakaryawan.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.aasihabudin.datakaryawan.data.Pegawai
import com.aasihabudin.datakaryawan.data.PegawaiDatabase
import com.aasihabudin.myapplication.databinding.ActivityFormBinding


class FormActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFormBinding
    private val viewModel: PegawaiViewModel by viewModels {
        PegawaiViewModelFactory(PegawaiDatabase.getDatabase(this).pegawaiDao())
    }
    private var pegawai: Pegawai? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFormBinding.inflate(layoutInflater)
        setContentView(binding.root)

        pegawai = intent.getParcelableExtra("pegawai")
        pegawai?.let {
            binding.editNama.setText(it.nama)
            binding.editJabatan.setText(it.jabatan)
            binding.btnHapus.isEnabled = true
        } ?: run {
            binding.btnHapus.isEnabled = false
        }

        binding.btnSimpan.setOnClickListener {
            val nama = binding.editNama.text.toString()
            val jabatan = binding.editJabatan.text.toString()
            if (pegawai == null) {
                viewModel.insert(Pegawai(nama = nama, jabatan = jabatan))
            } else {
                viewModel.update(Pegawai(id = pegawai!!.id, nama = nama, jabatan = jabatan))
            }
            finish()
        }

        binding.btnHapus.setOnClickListener {
            pegawai?.let {
                viewModel.delete(it)
                finish()
            }
        }
    }
}
