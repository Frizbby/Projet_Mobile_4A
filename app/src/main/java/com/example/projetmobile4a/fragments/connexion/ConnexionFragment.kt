package com.example.projetmobile4a.fragments.connexion

import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.projetmobile4a.R
import com.example.projetmobile4a.data.local.UserViewModel
import com.example.projetmobile4a.data.local.ViewModel
import com.example.projetmobile4a.domain.entity.User
import com.example.projetmobile4a.presentation.main.LoginError
import com.example.projetmobile4a.presentation.main.LoginSuccess
import com.example.projetmobile4a.presentation.main.MainViewModel
import kotlinx.android.synthetic.main.frag_connexion.*
import kotlinx.android.synthetic.main.frag_connexion.view.*
import org.koin.android.ext.android.inject


class ConnexionFragment : Fragment() {

    private lateinit var mUserViewModel: UserViewModel
    private lateinit var mUserViewModel2: ViewModel
    val mainViewModel : MainViewModel by inject()

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
        if(inputCheck(email, password)) {
            //val user = User(0,email,password)

                    //mUserViewModel.findUserWithName(email = email,password = password)
            //findNavController().navigate(R.id.action_connexionFragment_to_pokemonList)
            mUserViewModel.loginLiveData.observe(this, Observer {
                when(it){
                    is LoginSuccess -> {
                        Toast.makeText(requireContext(), "Welcome "+ email_text.text.toString(), Toast.LENGTH_LONG).show()
                        findNavController().navigate(R.id.action_connexionFragment_to_pokemonList)
                    }
                    LoginError -> {
                        Toast.makeText(requireContext(), "Bad credentials", Toast.LENGTH_LONG).show()
                    }

                }
            })
            login_button.setOnClickListener{
                mUserViewModel.onClickedLogin(email_text.text.toString(), password_text.text.toString())
            }



        }else{
            Toast.makeText(requireContext(), "Please fill out all fields", Toast.LENGTH_LONG).show()
        }
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