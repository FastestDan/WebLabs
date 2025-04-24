package ru.fd.ohayosekai

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.text.SpannableString
import android.text.Spanned
import android.text.style.ClickableSpan
import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView

class Registration : Activity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
        setContentView(R.layout.activity_registration)
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }
        findViewById<ImageButton>(R.id.regArrow).setOnClickListener{
            val intent = Intent(this, Welcome::class.java)
            startActivity(intent)
        }
        findViewById<ImageView>(R.id.regArrow).setImageResource(R.drawable.ic_arrow_back)

        class MySpan: ClickableSpan(){

            override fun onClick(p0: View) {
                TODO()
            }
        }

//        var eulastr = findViewById<TextView>(R.id.regEULA).text

        var supana = SpannableString(findViewById<TextView>(R.id.regEULA).text)

        supana.setSpan(MySpan(), 37, 65, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        supana.setSpan(MySpan(), 118, 145, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)


        findViewById<TextView>(R.id.regEULA).text = supana

    }

}