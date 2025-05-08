package ru.fd.ohayosekai

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AnotherAdapterOfFA: RecyclerView.Adapter<AnotherAdapterOfFA.Holder>() {
    var list : List<String> = listOf()

    class Holder(view: View): RecyclerView.ViewHolder(view){
        var title = view.findViewById<TextView>(R.id.trinity_label)

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
    }
}