package ru.fd.ohayosekai

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AdapterOfFA : RecyclerView.Adapter<AdapterOfFA.Holder>() {

    var list : List<MyList> = listOf()
    var click: ((MyList) -> Unit)? = null

    class Holder(view: View): RecyclerView.ViewHolder(view){
        var sep = view.findViewById<TextView>(R.id.sticker_separator)
        var dist = view.findViewById<TextView>(R.id.sticker_distance)
        var time = view.findViewById<TextView>(R.id.sticker_time)
        var type = view.findViewById<TextView>(R.id.sticker_type)
        var tag = view.findViewById<TextView>(R.id.sticker_tag)
        var ago = view.findViewById<TextView>(R.id.sticker_ago)
        var btn = view.findViewById<LinearLayout>(R.id.sticker_button)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {

        val view = when(viewType){
            VIEW_TYPE_1 -> R.layout.list_sticker
            VIEW_TYPE_2 -> R.layout.list_sticker_other
            else -> R.layout.list_sticker
        }

        return Holder(LayoutInflater.from(parent.context).inflate(view, parent, false))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun getItemViewType(position: Int): Int {
        if (list[position].sep != null){
            return VIEW_TYPE_1
        }
        else{
            return VIEW_TYPE_2
        }
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        if (list[position].sep != null) {
            holder.sep.text = list[position].sep
        }
        holder.dist.text = list[position].dist
        holder.time.text = list[position].time
        holder.type.text = list[position].type
        holder.tag.text = list[position].tag
        holder.ago.text = list[position].ago

        holder.btn.setOnClickListener{
            click?.invoke(list[position])
        }
    }

    companion object {
        const val VIEW_TYPE_1 = 101
        const val VIEW_TYPE_2 = 102
    }
}