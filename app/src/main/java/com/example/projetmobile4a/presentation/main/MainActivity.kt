package com.example.projetmobile4a.presentation.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.projetmobile4a.R
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {

     val mainViewModel : MainViewModel by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        setupActionBarWithNavController(findNavController(R.id.fragment))

      /* mainViewModel.loginLiveData.observe(this, Observer {
            when(it){
                is LoginSuccess -> {
                    // TODO Navigate
                }
                LoginError -> {
                    MaterialAlertDialogBuilder(this)
                        .setTitle("Erreur")
                        .setMessage("Compte inconnu")
                        .setPositiveButton("OK") { dialog, which -> dialog.dismiss() }
                        .show()
                }

            }
        })

        login_button.setOnClickListener{
            mainViewModel.onClickedLogin(email_text.text.toString().trim(), password_text.toString())
        }*/

    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.fragment)
        return navController.navigateUp() || super.onSupportNavigateUp()
    }

}










