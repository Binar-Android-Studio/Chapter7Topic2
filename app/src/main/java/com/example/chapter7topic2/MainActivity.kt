package com.example.chapter7topic2

import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import com.example.chapter7topic2.databinding.ActivityMainBinding
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding
    lateinit var auth : FirebaseAuth
    lateinit var googleSignInClient : GoogleSignInClient
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        auth = FirebaseAuth.getInstance()

        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.default_web_client_id))
            .requestEmail()
            .build()



        binding.Login.setOnClickListener(){
            signin()
//            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/danialfarrosmaulana/"))
//            startActivity(browserIntent)
        }

    }

    fun signin(){
        val signinClient = googleSignInClient.signInIntent
        launcher.launch(signinClient)
    }
    private val launcher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
            result ->
        if (result.resultCode == Activity.RESULT_OK){

            val task = GoogleSignIn.getSignedInAccountFromIntent(result.data)
            results(task)
        }
    }

    private fun results(task: Task<GoogleSignInAccount>) {
        if (task.isSuccessful){
            val account : GoogleSignInAccount? = task.result
            if (account != null){

            }
        }else{
            Toast.makeText(this, task.exception.toString() , Toast.LENGTH_SHORT).show()
        }
    }
}