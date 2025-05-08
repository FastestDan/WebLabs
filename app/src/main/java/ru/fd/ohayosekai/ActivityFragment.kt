package ru.fd.ohayosekai

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.tabs.TabLayoutMediator

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "SASISKA"
private const val ARG_PARAM2 = "ZERO"

/**
 * A simple [Fragment] subclass.
 * Use the [ActivityFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ActivityFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var message: String? = null
    private var tag: String? = null
//    var db: DBController? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            message = it.getString(ARG_PARAM1)
            tag = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view = inflater.inflate(R.layout.fragment_activity, container, false)
        view.findViewById<FloatingActionButton>(R.id.floatingActionButton).setOnClickListener {
            val intent = Intent(view.context, FullActionActivity::class.java)
            startActivity(intent)
        }
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val adapter = AdapterOfBS(this)

        val list = mutableListOf<String>()
        list.add(getString(R.string.activUpTab1))
        list.add(getString(R.string.activUpTab2))

        this.view?.findViewById<ViewPager2>(R.id.viewPager2)?.adapter = adapter

        this.view?.let { TabLayoutMediator(it.findViewById(R.id.tabLayout), it.findViewById(R.id.viewPager2),
            { tab, pos ->
                tab.text = list[pos]
            }).attach()
        }

        super.onViewCreated(view, savedInstanceState)
    }


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param message Parameter 1.
         * @param tag Parameter 2.
         * @return A new instance of fragment ActivityFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(message: String, tag: String) =
            ActivityFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, message)
                    putString(ARG_PARAM2, tag)
                }
//                db = dab
            }
    }
}