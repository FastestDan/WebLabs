package ru.fd.ohayosekai

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.util.Date

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private var ARG_PARAM2 = Date()
private const val ARG_PARAM3 = "param3"
private const val ARG_PARAM4 = "param4"

/**
 * A simple [Fragment] subclass.
 * Use the [TrinityGoingFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class TrinityGoingFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: Date? = null
    private var param3: Date? = null
    private var param4: Int? = null

    lateinit var dbcon: DBController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = ARG_PARAM2
            param4 = it.getInt(ARG_PARAM4)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dbcon = ViewModelProvider(this)[DBController::class.java]
        var view = inflater.inflate(R.layout.fragment_trinity_going, container, false)
        view.findViewById<TextView>(R.id.goingtype).text = param1
        view.findViewById<TextView>(R.id.goingtimer).text = "${param2.hours}:${param2.minutes}:${param2.seconds}"
        view.findViewById<TextView>(R.id.goingdist).text = "${param4.toString()} км"
        view.findViewById<FloatingActionButton>(R.id.goingfinish).setOnClickListener {
            param1?.let {
                it1 -> param2?.let {
                    it2 -> param4?.let {
                        it3 -> dbcon.addUser(it1, it2, Date(), it3)
                    }
                }
            }
            parentFragmentManager.beginTransaction().replace(
                R.id.actionOfTrinity,
                TrinityStartFragment()
            ).commit()
        }
        return view
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment TrinityGoingFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: Date, param4: Int) =
            TrinityGoingFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    ARG_PARAM2 = param2
                    putInt(ARG_PARAM4, param4)
                }
            }
    }
}