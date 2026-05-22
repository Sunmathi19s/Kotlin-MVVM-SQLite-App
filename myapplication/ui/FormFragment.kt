package com.example.myapplication.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Spinner
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.R
import com.example.myapplication.data.UserModel
import com.example.myapplication.viewmodel.userViewModel

class FormFragment : Fragment() {
    lateinit var viewModel: userViewModel

    lateinit var etName: EditText
    lateinit var spinner: Spinner
    lateinit var radioGroup: RadioGroup
    lateinit var checkBox: CheckBox
    lateinit var btnSave: Button
    lateinit var btnView: Button

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_form, container, false)

        viewModel = ViewModelProvider(this)[userViewModel::class.java]

        etName = view.findViewById(R.id.etName)
        spinner = view.findViewById(R.id.spDepartment)
        radioGroup = view.findViewById(R.id.radioGroup)
        checkBox = view.findViewById(R.id.checkTerms)
        btnSave = view.findViewById(R.id.btnSave)
        btnView = view.findViewById(R.id.btnView)
        // Spinner Data
        val departments = arrayOf(
            "IT",
            "CSE",
            "ECE",
            "MECH"
        )

        val adapter = ArrayAdapter(
            requireContext(),
            android.R.layout.simple_spinner_dropdown_item,
            departments
        )

        spinner.adapter = adapter

        // Save Button
        btnSave.setOnClickListener {

            val name = etName.text.toString()

            val department = spinner.selectedItem.toString()

            val gender =
                if (view.findViewById<RadioButton>(R.id.rbMale).isChecked)
                    "Male"
                else
                    "Female"

            val terms =
                if (checkBox.isChecked)
                    "Accepted"
                else
                    "Not Accepted"

            val user = UserModel(
                0,
                name,
                department,
                gender,
                terms
            )

            val result = viewModel.insertUser(user)

            if (result) {

                Toast.makeText(
                    requireContext(),
                    "Inserted Successfully",
                    Toast.LENGTH_SHORT
                ).show()

                etName.setText("")
            }
            else {

                Toast.makeText(
                    requireContext(),
                    "Insertion Failed",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

        // Move to RecyclerView Page
        btnView.setOnClickListener {

            parentFragmentManager.beginTransaction()
                .replace(R.id.frameLayout, ListFragment())
                .addToBackStack(null)
                .commit()
        }

        return view
    }
}