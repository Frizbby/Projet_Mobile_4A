package com.example.projetmobile4a.fragments.connexion

import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.projetmobile4a.R
import com.example.projetmobile4a.data.local.UserViewModel
import com.example.projetmobile4a.domain.entity.User
import kotlinx.android.synthetic.main.frag_connexion.*
import kotlinx.android.synthetic.main.frag_connexion.view.*


class ConnexionFragment : Fragment() {

    private lateinit var mUserViewModel: UserViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.frag_connexion, container, false)
        // Inflate the layout for this fragment

        mUserViewModel = ViewModelProvider(this).get(UserViewModel::class.java)
        mUserViewModel.readAllData


        view.register_button.setOnClickListener {
            insertDataToDatabase()
        }

        view.login_button.setOnClickListener {
           loginToDatabase()
        }

        return view
    }

    private fun loginToDatabase(){

        val email = email_text.text.toString()
        val password = password_text.text.toString()

        mUserViewModel.findUserWithName(email = email,password = password)

        findNavController().navigate(R.id.action_connexionFragment_to_pokemonList)

        //Toast.makeText(requireContext(),"wow", Toast.LENGTH_LONG).show()
    }

    private fun insertDataToDatabase() {
        val email = email_text.text.toString()
        val password = password_text.text.toString()

        if(inputCheck(email, password)){
            // Create User Object
            val user = User(0, email, password)
            // Add Data to Database
            mUserViewModel.addUser(user)
            Toast.makeText(requireContext(), "Successfully registered", Toast.LENGTH_LONG).show()

        }else{
            Toast.makeText(requireContext(), "Please fill out all fields", Toast.LENGTH_LONG).show()
        }

    }



    private fun inputCheck(email: String, password: String): Boolean{
        return !(TextUtils.isEmpty(email) && TextUtils.isEmpty(password))
    }



}