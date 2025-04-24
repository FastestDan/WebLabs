package ru.fd.ohayosekai

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView

class Login : Activity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }
        findViewById<ImageButton>(R.id.logArrow).setOnClickListener{
            val intent = Intent(this, Welcome::class.java)
            startActivity(intent)
        }
        findViewById<ImageView>(R.id.logArrow).setImageResource(R.drawable.ic_arrow_back)
    }
}