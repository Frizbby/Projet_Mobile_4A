package com.example.projetmobile4a.fragments.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.projetmobile4a.R
import kotlinx.android.synthetic.main.frag_home.view.*


class HomeFragment : Fragment() {




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.frag_home, container, false)

        view.button.setOnClickListener{
            findNavController().navigate(R.id.action_homeFragment_to_connexionFragment)
        }

    return view

    }


}