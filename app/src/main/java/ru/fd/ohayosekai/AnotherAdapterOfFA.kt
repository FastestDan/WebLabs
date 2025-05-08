package ru.fd.ohayosekai

import android.graphics.Color
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.util.Date

class AnotherAdapterOfFA: RecyclerView.Adapter<AnotherAdapterOfFA.Holder>() {
    var list : List<String> = listOf()
    var click : ((String) -> Unit)? = null
    var pos = -1

    class Holder(view: View): RecyclerView.ViewHolder(view){
        var title = view.findViewById<TextView>(R.id.trinity_label)
        var btn = view.findViewById<LinearLayout>(R.id.trinity_select)
        var select = false
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        return Holder(LayoutInflater.from(parent.context).inflate(R.layout.part_of_trinity, parent, false))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }


    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.title.text = list[position]
        if (position == pos){
            holder.btn.findViewById<TextView>(R.id.trinity_label).setTextColor(Color.parseColor("#4B09F3"))
        }
        holder.btn.setOnClickListener {
            pos = position
            Log.d("SAS", "onBindViewHolder: ${Date().hours}:${Date().minutes}")
            click?.invoke(list[pos])
        }
    }
}