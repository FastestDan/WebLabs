package ru.fd.ohayosekai

import android.app.Activity
import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.FragmentManager

class ActivityList : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        var manager = FragmentManager()
        var frag = FragmentActivity()

        manager.beginTransaction().apply{
            add(
                R.id.listOfActivities,
                frag.newInstance("Testing here, nothing to see", "First Fragment")
            )
            addToBackStack("tag name")
            commit()
        }
    }
}