package eu.saveliev.annonce86.dialogs

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import eu.saveliev.annonce86.R

class RcViewDialogSpinner : RecyclerView.Adapter<RcViewDialogSpinner.SpViewHolder>() {

    val mainList = ArrayList<String>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SpViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.sp_list_item, parent, false)
        return SpViewHolder(view)
    }

    override fun getItemCount(): Int {
        return mainList.size
    }

    override fun onBindViewHolder(holder: SpViewHolder, position: Int) {
        holder.setData(mainList[position])
    }

    class SpViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvSpItem = itemView.findViewById<TextView>(R.id.tvSpItem)
        fun setData(text: String) {
            tvSpItem.text = text
        }
    }

    fun updateAdapter(list: ArrayList<String>) {
        mainList.clear()
        mainList.addAll(list)
        notifyDataSetChanged()
    }
}