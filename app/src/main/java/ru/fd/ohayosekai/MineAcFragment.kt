package ru.fd.ohayosekai

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import java.text.SimpleDateFormat

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [MineAcFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MineAcFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    lateinit var dbcon: DBController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_mine_ac, container, false)
    }

    @SuppressLint("SimpleDateFormat")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        var stamp = view.findViewById<RecyclerView>(R.id.stickers_mine)
        dbcon = ViewModelProvider(this)[DBController::class.java]
        var list = mutableListOf<MyList>()
        dbcon.actions.observe(viewLifecycleOwner){
            for (i in 0..it.size){
                var ml = MyList(
                    type = it[i].type,
                    start = it[i].start.toString(),
                    finish = it[i].finish.toString(),
                    time = (it[i].finish.toInt() - it[i].start.toInt()).toString(),
                    ago = "Несколько секунд назад",
                    tag = "",
                    sep = SimpleDateFormat("dow mon dd hh:mm:ss zzz yyyy").parse(it[i].finish)?.month.toString(),
                    dist = it[i].latlot.toString() + " км"
                )
                list.add(ml)
            }
        }
//        var list = listOf(MyList(
//            "14 км",
//            "Пробежка",
//            "1 час 5 минут",
//            "13:00",
//            "14:05",
//            "",
//            "14 часов назад",
//            "Вчера"),
//            MyList(
//                "100 м",
//                "Велосипед",
//                "30 минут",
//                "15:04",
//                "15:34",
//                "",
//                "06.05.2025",
//                "Май 2025"),
//            MyList(
//                "1 км",
//                "Пробежка",
//                "20 минут",
//                "13:00",
//                "13:20",
//                "",
//                "05.05.2025"),
//            MyList(
//                "5 км",
//                "Пробежка",
//                "1 час",
//                "16:05",
//                "17:05",
//                "",
//                "26.04.2025",
//                "Апрель 2025"))

        var aug = AdapterOfFA()
        aug.list = list

        aug.click = {
            parentFragment?.parentFragmentManager?.beginTransaction()?.apply {
                replace(
                    R.id.listOfActivities,
                    MineStickerFragment.newInstance(it.type, it.dist, it.ago, it.time, it.start, it.finish)
                ).commit()
            }
        }

        stamp.adapter = aug


        super.onViewCreated(view, savedInstanceState)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment MineAcFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            MineAcFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}