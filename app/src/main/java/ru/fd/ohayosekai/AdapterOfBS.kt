package ru.fd.ohayosekai

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class AdapterOfBS(fa: Fragment): FragmentStateAdapter(fa) {
    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        val temp = listOf(MineAcFragment(), OtherAcFragment())
        return temp[position]
    }
}