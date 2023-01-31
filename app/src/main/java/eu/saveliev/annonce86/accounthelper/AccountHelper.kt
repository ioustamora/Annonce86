package eu.saveliev.annonce86.accounthelper

import android.widget.Toast
import com.google.firebase.auth.FirebaseUser
import eu.saveliev.annonce86.MainActivity
import eu.saveliev.annonce86.R

class AccountHelper(private val act: MainActivity) {

    fun signUpWithEmail(email: String, password: String) {
        if(email.isNotEmpty() && password.isNotEmpty()) {
            act.mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener {task ->
                if (task.isSuccessful) {
                    sendEmailVerification(task.result?.user!!)
                    act.uiUpdate(task.result?.user)
                } else {

                    Toast.makeText(act, act.resources.getString(R.string.signup_error), Toast.LENGTH_LONG).show()
                }
            }
        }
    }

    fun loginWithEmail(email: String, password: String) {
        if(email.isNotEmpty() && password.isNotEmpty()) {
            act.mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener {task ->
                if (task.isSuccessful) {
                    act.uiUpdate(task.result?.user)
                } else {

                    Toast.makeText(act, act.resources.getString(R.string.log_in_error), Toast.LENGTH_LONG).show()
                }
            }
        }
    }

    private fun sendEmailVerification(user: FirebaseUser) {
        user.sendEmailVerification().addOnCompleteListener {task ->
            if(task.isSuccessful) {
                Toast.makeText(act, act.resources.getString(R.string.send_verification_email_sent), Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(act, act.resources.getString(R.string.send_verification_email_error), Toast.LENGTH_LONG).show()
            }
        }
    }
}