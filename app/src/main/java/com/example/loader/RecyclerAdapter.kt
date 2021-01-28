package com.example.loader

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.loader.models.DataX
import com.example.loader.models.Group

class RecyclerAdapter(private val context: Context, private val dataList:List<DataX>)
    : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val item = LayoutInflater.from(context).inflate(R.layout.item_group, parent, false)
        return ViewHolder(item)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val dataX = dataList[position]
        holder.title.text = dataX.direction.title
        holder.count.text = dataX.groups.size.toString().plus(" ").plus(context.getString(R.string.courses))
    }





        class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
            val title: TextView = itemView.findViewById(R.id.title_tv)
            val count: TextView = itemView.findViewById(R.id.count_tv)
            val icon: ImageView = itemView.findViewById(R.id.icon_iv)
        }
}