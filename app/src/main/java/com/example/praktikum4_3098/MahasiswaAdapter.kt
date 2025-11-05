package com.example.praktikum4_3098

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import android.widget.Toast

class MahasiswaAdapter(private val listMahasiswa: List<Mahasiswa>) :
    RecyclerView.Adapter<MahasiswaAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvNama: TextView = itemView.findViewById(R.id.tv_nama_mahasiswa)
        val tvNim: TextView = itemView.findViewById(R.id.tv_nim_mahasiswa)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_row_mahasiswa, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = listMahasiswa[position]
        holder.tvNama.text = data.nama
        holder.tvNim.text = data.nim

        holder.itemView.setOnClickListener {
            Toast.makeText(holder.itemView.context, "Kamu memilih: ${data.nama}", Toast.LENGTH_SHORT).show()
        }
    }

    override fun getItemCount(): Int {
        return listMahasiswa.size
    }
}
