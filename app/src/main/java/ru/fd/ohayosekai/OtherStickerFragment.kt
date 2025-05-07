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
private const val ARG_PARAM7 = "param7"

/**
 * A simple [Fragment] subclass.
 * Use the [OtherStickerFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class OtherStickerFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var o_type: String? = null
    private var o_dist: String? = null
    private var o_ago: String? = null
    private var o_time: String? = null
    private var o_start: String? = null
    private var o_finish: String? = null
    private var o_tag: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            o_type = it.getString(ARG_PARAM1)
            o_dist = it.getString(ARG_PARAM2)
            o_ago = it.getString(ARG_PARAM3)
            o_time = it.getString(ARG_PARAM4)
            o_start = it.getString(ARG_PARAM5)
            o_finish = it.getString(ARG_PARAM6)
            o_tag = it.getString(ARG_PARAM7)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_other_sticker, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        this.view?.findViewById<TextView>(R.id.detail_type)?.setText(o_type)
        this.view?.findViewById<TextView>(R.id.detail_dist)?.setText(o_dist)
        this.view?.findViewById<TextView>(R.id.detail_ago)?.setText(o_ago)
        this.view?.findViewById<TextView>(R.id.detail_time)?.setText(o_time)
        this.view?.findViewById<TextView>(R.id.detail_start)?.setText(o_start)
        this.view?.findViewById<TextView>(R.id.detail_finish)?.setText(o_finish)
        view.findViewById<TextView>(R.id.detail_tag).setText(o_tag)
        this.view?.findViewById<ImageButton>(R.id.osticker_arrow)?.setOnClickListener {
            parentFragment?.parentFragmentManager?.beginTransaction()?.apply {
                replace(
                    R.id.listOfActivities,
                    OtherAcFragment()
                ).commit()
            }
        }
        super.onViewCreated(view, savedInstanceState)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment OtherStickerFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String, param3: String, param4: String, param5: String, param6: String, param7: String) =
            OtherStickerFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                    putString(ARG_PARAM3, param3)
                    putString(ARG_PARAM4, param4)
                    putString(ARG_PARAM5, param5)
                    putString(ARG_PARAM6, param6)
                    putString(ARG_PARAM7, param7)
                }
            }
    }
}