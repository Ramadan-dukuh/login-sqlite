package com.example.loginsql

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.loginsql.databinding.ActivitySignupBinding
import android.content.Intent
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SignupActivity : AppCompatActivity() {
    private lateinit var db: DatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_signup)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        findViewById<Button>(R.id.signupButton).setOnClickListener {
            val name = findViewById<EditText>(R.id.signupUsername).text.toString()
            val pass = findViewById<EditText>(R.id.signupPassword).text.toString()

            db.insertUser(name,pass)
            Toast.makeText(this,"Regis Succes",Toast.LENGTH_SHORT).show()
            finish()

        }
    }
}