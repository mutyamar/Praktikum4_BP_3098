package com.example.praktikum4_3098

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.Spinner
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Register : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.register)

        val et_RegUsername: EditText = findViewById(R.id.et_reg_username)
        val et_RegEmail: EditText = findViewById(R.id.et_reg_email)
        val et_RegPassword: EditText = findViewById(R.id.et_reg_password)
        val et_RegConfirmPassword: EditText = findViewById(R.id.et_reg_confirm_password)
        val btn_Register: Button = findViewById(R.id.btn_register)
        val btn_BackToLogin: Button = findViewById(R.id.btn_back_to_login)
        val rg_JenisKelamin: RadioGroup = findViewById(R.id.rg_jenis_kelamin)
        val cb_Setuju: CheckBox = findViewById(R.id.cb_setuju)
        val spin_domisili: Spinner = findViewById(R.id.spin_domisili)

        spin_domisili.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View?,
                position: Int,
                id: Long
            ) {
                val selectedItem = parent.getItemAtPosition(position).toString()
                Toast.makeText(this@Register, "Domisili : $selectedItem", Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
            }
        }

        btn_Register.setOnClickListener {
            val selectedId = rg_JenisKelamin.checkedRadioButtonId
            val JenisKelamin = when(selectedId){
                R.id.rb_pria -> "Pria"
                R.id.rb_wanita -> "Wanita"
                else -> "Belum Dipilih"
            }
            val isAgreed = cb_Setuju.isChecked
            val selectedDom = spin_domisili.selectedItem.toString()
            Toast.makeText(this, "Domisili : $selectedDom, Jenis Kelamin : $JenisKelamin, Setuju : $isAgreed",Toast.LENGTH_SHORT).show()
        }

        // Tombol Kembali ke Login
        btn_BackToLogin.setOnClickListener {
            finish() // Tutup activity Register
        }
    }
}