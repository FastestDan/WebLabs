package ru.fd.ohayosekai

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.ImageButton
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.FragmentActivity
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentContainerView
import androidx.fragment.app.FragmentManager
import com.google.android.material.bottomnavigation.BottomNavigationView

class ActivityList : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_list)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction().apply {
                add(
                    R.id.listOfActivities,
                    ActivityFragment.newInstance("Activity", "Mine"),
                    "Mine"
                )
                commit()
            }
        }

        findViewById<BottomNavigationView>(R.id.bottomNavigationView).setOnItemSelectedListener{
            item -> when (item.itemId) {
                R.id.profile_button -> {
                    supportFragmentManager.beginTransaction().replace(
                        R.id.listOfActivities,
                        ProfileFragment()
                    ).commit()
//                    if (supportFragmentManager.findFragmentByTag("Mine") != null) {
//                        supportFragmentManager.beginTransaction().apply {
//                            detach(ActivityFragment())
//                            commit()
//                        }
//                    }
//                    if (supportFragmentManager.findFragmentByTag("Pass") != null) {
//                        supportFragmentManager.beginTransaction().apply {
//                            attach(ProfileFragment())
//                            commit()
//                        }
//                    } else {
//                        supportFragmentManager.beginTransaction().apply {
//                            add(
//                                R.id.listOfActivities,
//                                ProfileFragment.newInstance("Profile", "Pass"),
//                                "Pass"
//                            )
//                            commit()
//                        }
//                    }
                }
                R.id.active_button -> {
                    supportFragmentManager.beginTransaction().replace(
                        R.id.listOfActivities,
                        ActivityFragment()
                    ).commit()
//                    if (supportFragmentManager.findFragmentByTag("Mine") != null) {
//                        supportFragmentManager.beginTransaction().apply {
//                            attach(ActivityFragment())
//                            commit()
//                        }
//                    }
//                    if (supportFragmentManager.findFragmentByTag("Pass") != null) {
//                        supportFragmentManager.beginTransaction().apply {
//                            detach(ProfileFragment())
//                            commit()
//                        }
//                    }
                }
            };true
        }
        findViewById<TextView?>(R.id.profchange)?.setOnClickListener {
            supportFragmentManager.beginTransaction().replace(
                R.id.listOfActivities,
                PasswordFragment()
            ).commit()
        }
        findViewById<ImageButton>(R.id.passBtn)?.setOnClickListener {
            supportFragmentManager.beginTransaction().replace(
                R.id.listOfActivities,
                ProfileFragment()
            ).commit()
        }
    }
}