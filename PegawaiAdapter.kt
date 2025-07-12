package com.aasihabudin.datakaryawan.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.aasihabudin.datakaryawan.data.Pegawai
import com.aasihabudin.myapplication.R

class PegawaiAdapter(
    private val onItemClicked: (Pegawai) -> Unit
) : RecyclerView.Adapter<PegawaiAdapter.ViewHolder>() {

    private var pegawaiList = listOf<Pegawai>()

    @SuppressLint("NotifyDataSetChanged")
    fun setData(list: List<Pegawai>) {
        pegawaiList = list
        notifyDataSetChanged()
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val nama: TextView = view.findViewById(R.id.textNama)
        val jabatan: TextView = view.findViewById(R.id.textJabatan)

        init {
            view.setOnClickListener {
                onItemClicked(pegawaiList[layoutPosition])
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_pegawai, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val pegawai = pegawaiList[position]
        holder.nama.text = pegawai.nama
        holder.jabatan.text = pegawai.jabatan
    }

    override fun getItemCount(): Int = pegawaiList.size
}
