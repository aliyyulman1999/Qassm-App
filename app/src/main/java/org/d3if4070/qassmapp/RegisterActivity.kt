package org.d3if4070.qassmapp

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.fragment_profil.*
import org.d3if4070.qassmapp.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {

    lateinit var binding : ActivityRegisterBinding
    lateinit var ref: DatabaseReference
    private lateinit var auth : FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        auth = FirebaseAuth.getInstance()
        ref = FirebaseDatabase.getInstance().getReference("USERS")

        binding.btnRegister.setOnClickListener {
            val email = binding.etEmail.text.toString().trim()
            val userNama = binding.etName.text.toString().trim()
            val password = binding.etPassword.text.toString().trim()
            val confirmPassword = binding.etConfirmPassword.text.toString().trim()
            val phoneNumber = binding.etPhone.text.toString().trim()

            if (email.isEmpty()){
                binding.etEmail.error ="Email requires"
                binding.etEmail.requestFocus()
                return@setOnClickListener
            }

            if (password.isEmpty() || password.length < 6){
                binding.etPassword.error="Password required"
                binding.etPassword.requestFocus()
                return@setOnClickListener
            }

            if(confirmPassword.isEmpty()){
                binding.etConfirmPassword.error = "Confirm Password required"
                binding.etConfirmPassword.requestFocus()
                return@setOnClickListener

            }

            if(confirmPassword != password){
                binding.etConfirmPassword.error = "Confirm Password Not Match"
                binding.etConfirmPassword.requestFocus()
                return@setOnClickListener

            }

            if (userNama.isEmpty()){
                binding.etName.error ="Full name requires"
                binding.etName.requestFocus()
                return@setOnClickListener
            }
            if (phoneNumber.isEmpty()){
                binding.etPhone.error ="Phone Number requires"
                binding.etPhone.requestFocus()
                return@setOnClickListener
            }

            registeriUser(email,password,userNama,phoneNumber)
        }
    }

    private fun registeriUser(email:String, password: String, userNama: String, phoneNumber: String){
        val progressDialog = ProgressDialog(this@RegisterActivity)
        progressDialog.setTitle("Registration User")
        progressDialog.setMessage("Please Wait")
        progressDialog.setCanceledOnTouchOutside(false)
        progressDialog.show()

        auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(this){
            if (it.isSuccessful){
                saveUser(email, userNama, phoneNumber, progressDialog)
//                Toast.makeText(this, "Registration Succesfull", Toast.LENGTH_SHORT).show()
//                val intent = Intent(this@RegisterActivity, MainActivity::class.java)
//                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
//                startActivity(intent)
            } else {
                val message = it.exception!!.toString()
                Toast.makeText(this, "Error : $message", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun saveUser(userNama: String, email:String, phoneNumber: String,
    progressDialog: ProgressDialog){
        val currentUserId = auth.currentUser!!.uid
        ref = FirebaseDatabase.getInstance().reference.child("USERS")
        val userMap = HashMap<String, Any>()
        userMap["id"] = currentUserId
        userMap ["email"] = email
        userMap ["userNama"] = userNama
        userMap ["phoneNumber"] = phoneNumber
        userMap ["alamat"] = ""

        ref.child(currentUserId).setValue(userMap).addOnCompleteListener{
            if (it.isSuccessful){
                progressDialog.dismiss()
                Toast.makeText(this, "Register is Successfully", Toast.LENGTH_SHORT).show()
                val intent = Intent(this@RegisterActivity, MainActivity::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
                startActivity(intent)
            } else {
                val message = it.exception!!.toString()
                Toast.makeText(this, "Error : $message", Toast.LENGTH_SHORT).show()
                progressDialog.dismiss()
            }
        }
    }
}