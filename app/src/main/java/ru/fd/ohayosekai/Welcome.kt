package ru.fd.ohayosekai

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.text.SpannableString
import android.text.style.ClickableSpan

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.google.android.material.button.MaterialButton

class Welcome: Activity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)

        setContentView(R.layout.welcome)
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }
        findViewById<ImageView>(R.id.welImage).setImageResource(R.drawable.ic_registration_bicycles)
        findViewById<MaterialButton>(R.id.regButton).setOnClickListener{
            val intent = Intent(this, Registration::class.java)
            startActivity(intent)
        }
        findViewById<TextView>(R.id.logButton).setOnClickListener{
            val intent = Intent(this, Login::class.java)
            startActivity(intent)
        }
    }
}

