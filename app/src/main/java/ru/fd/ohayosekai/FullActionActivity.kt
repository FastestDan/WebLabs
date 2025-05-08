package ru.fd.ohayosekai

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView

class FullActionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_full_action)
//        if (savedInstanceState == null) {
//            supportFragmentManager.beginTransaction().apply {
//                add(
//                    R.id.trinityAction,
//                    TrinityStartFragment.newInstance("Trinity", "Start"),
//                    "Start"
//                )
//                commit()
//            }
//        }
//        enableEdgeToEdge()

//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }
    }
}