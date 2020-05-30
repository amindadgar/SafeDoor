package com.example.sampleapp.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.sampleapp.Model.Users
import com.example.sampleapp.R

class MainRecyclerAdapter(val NameList:List<Users>): RecyclerView.Adapter<MyViewHolder>() {




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder{
        var view = LayoutInflater.from(parent.context).inflate(R.layout.main_recycler_layout,parent,false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return NameList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.textView.text = NameList[position].Name
    }
}
class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val textView:TextView= itemView.findViewById(R.id.MainRecyclerText)
//    val TextView :TextView = itemView.findViewById(R.id.)

}