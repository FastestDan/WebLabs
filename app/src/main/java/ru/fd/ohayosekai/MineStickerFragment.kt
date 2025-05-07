package ru.fd.ohayosekai

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"
private const val ARG_PARAM3 = "param3"
private const val ARG_PARAM4 = "param4"
private const val ARG_PARAM5 = "param5"
private const val ARG_PARAM6 = "param6"
/**
 * A simple [Fragment] subclass.
 * Use the [MineStickerFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MineStickerFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var m_type: String? = null
    private var m_dist: String? = null
    private var m_ago: String? = null
    private var m_time: String? = null
    private var m_start: String? = null
    private var m_finish: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            m_type = it.getString(ARG_PARAM1)
            m_dist = it.getString(ARG_PARAM2)
            m_ago = it.getString(ARG_PARAM3)
            m_time = it.getString(ARG_PARAM4)
            m_start = it.getString(ARG_PARAM5)
            m_finish = it.getString(ARG_PARAM6)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_mine_sticker, container, false)
        view.findViewById<ImageButton>(R.id.msticker_arrow).setOnClickListener {
            parentFragmentManager.beginTransaction().replace(
                R.id.listOfActivities,
                ActivityFragment()
            ).commit()
        }
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        view.findViewById<TextView>(R.id.detail_type).setText(m_type)
        view.findViewById<TextView>(R.id.detail_dist).setText(m_dist)
        view.findViewById<TextView>(R.id.detail_ago).setText(m_ago)
        view.findViewById<TextView>(R.id.detail_time).setText(m_time)
        view.findViewById<TextView>(R.id.detail_start).setText(m_start)
        view.findViewById<TextView>(R.id.detail_finish).setText(m_finish)
        super.onViewCreated(view, savedInstanceState)
//        view.findViewById<ImageButton>(R.id.msticker_arrow).setOnClickListener {
//            parentFragment?.parentFragmentManager?.beginTransaction()?.apply {
//                replace(
//                    R.id.listOfActivities,
//                    MineAcFragment()
//                ).commit()
//            }
//        }
    }


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment StickerFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String, param3: String, param4: String, param5: String, param6: String) =
            MineStickerFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                    putString(ARG_PARAM3, param3)
                    putString(ARG_PARAM4, param4)
                    putString(ARG_PARAM5, param5)
                    putString(ARG_PARAM6, param6)
                }
            }
    }
}