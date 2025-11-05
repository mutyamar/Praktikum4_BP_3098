package com.example.praktikum4_3098

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Dashboard : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dashboard)

        val dataList = ArrayList<Mahasiswa>()
        dataList.add(Mahasiswa("Calista Sasikirana", "23SI12345"))
        dataList.add(Mahasiswa("Andi Pratama", "23SI12346"))
        dataList.add(Mahasiswa("Budi Santoso", "23SI12347"))

        val btn_web: Button = findViewById(R.id.btn_web)

        val username = intent.getStringExtra("nama" )

        val rvMahasiswa: RecyclerView = findViewById(R.id.rv_mahasiswa)

        rvMahasiswa.layoutManager = GridLayoutManager(this, 2)

        val adapter = MahasiswaAdapter(dataList)

        rvMahasiswa.adapter = adapter

        btn_web.setOnClickListener {
            val url = "https://amikom.ac.id"
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            startActivity(intent)
        }
    }
}
