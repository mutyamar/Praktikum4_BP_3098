package com.example.praktikum4_3098

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Dashboard : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dashboard)

        val username = intent.getStringExtra("nama")
        val btn_web: Button = findViewById(R.id.btn_web)
        val dashboardFragment = DashboardFragment()

        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, dashboardFragment)
            .commit()

        btn_web.setOnClickListener {
            val url = "https://amikom.ac.id"
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            startActivity(intent)
        }
    }
}