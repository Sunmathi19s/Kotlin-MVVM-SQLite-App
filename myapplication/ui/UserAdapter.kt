package com.example.myapplication.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.data.UserModel

class UserAdapter (  private val list: ArrayList<UserModel>) : RecyclerView.Adapter<UserAdapter.ViewHolder>() {
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val tvName: TextView = view.findViewById(R.id.name)
        val tvDepartment: TextView = view.findViewById(R.id.tvDepartment)
        val tvGender: TextView = view.findViewById(R.id.tvGender)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_item, parent, false)

        return ViewHolder(view)
    }
    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val user = list[position]

        holder.tvName.text = user.name
        holder.tvDepartment.text = user.department
        holder.tvGender.text = user.gender
    }
}