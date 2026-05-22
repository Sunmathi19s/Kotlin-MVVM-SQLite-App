package com.example.myapplication.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.data.UserModel
import com.example.myapplication.viewmodel.userViewModel

class ListFragment : Fragment() {

    lateinit var recyclerView: RecyclerView

    lateinit var viewModel: userViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val view = inflater.inflate(
            R.layout.fragment_item_list,
            container,
            false
        )

        recyclerView = view.findViewById(R.id.recyclerView)

        viewModel = ViewModelProvider(this)[userViewModel::class.java]

        val list = viewModel.getUsers()

        recyclerView.layoutManager =
            LinearLayoutManager(requireContext())

        recyclerView.adapter = UserAdapter(list)

        return view
    }
}