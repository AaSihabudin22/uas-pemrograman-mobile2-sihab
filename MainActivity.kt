package com.aasihabudin.datakaryawan.ui

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.aasihabudin.datakaryawan.adapter.PegawaiAdapter
import com.aasihabudin.datakaryawan.data.PegawaiDatabase
import com.aasihabudin.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: PegawaiViewModel by viewModels {
        PegawaiViewModelFactory(PegawaiDatabase.getDatabase(this).pegawaiDao())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = PegawaiAdapter {
            val intent = Intent(this, FormActivity::class.java)
            intent.putExtra("pegawai", it)
            startActivity(intent)
        }

        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = adapter

        viewModel.allPegawai.observe(this) {
            adapter.setData(it ?: emptyList())
        }

        binding.fabAdd.setOnClickListener {
            startActivity(Intent(this, FormActivity::class.java))
        }
    }
}
