package eu.saveliev.annonce86.dialoghelper
import android.app.AlertDialog
import android.view.View
import android.widget.Toast
import eu.saveliev.annonce86.MainActivity
import eu.saveliev.annonce86.R
import eu.saveliev.annonce86.accounthelper.AccountHelper
import eu.saveliev.annonce86.databinding.SignDialogBinding

class DialogHelper(private val act: MainActivity) {

    val accHelper = AccountHelper(act)
    fun createSignDialog(index: Int) {
        val builder = AlertDialog.Builder(act)
        val rootDialogElement = SignDialogBinding.inflate(act.layoutInflater)
        val view = rootDialogElement.root
        builder.setView(view)

        setDialogState(index, rootDialogElement)

        val dialog = builder.create()

        rootDialogElement.btSigninLogin.setOnClickListener {
            setonClickSignupLogin(index, rootDialogElement, dialog)
        }
        rootDialogElement.btForgetPassword.setOnClickListener {
            setOnClickForget(rootDialogElement, dialog)
        }
        rootDialogElement.btGoogleSignIn.setOnClickListener {
            accHelper.signInWithGoogle()
            dialog.dismiss()
        }

        dialog.show()
    }

    private fun setOnClickForget(rootDialogElement: SignDialogBinding, dialog: AlertDialog?) {
        if (rootDialogElement.edSignEmail.text.isNotEmpty()) {
            act.mAuth.sendPasswordResetEmail(rootDialogElement.edSignEmail.text.toString()).addOnCompleteListener {task ->
                if (task.isSuccessful) {
                    Toast.makeText(act, R.string.email_reset_password_sent, Toast.LENGTH_LONG).show()
                }
            }
            dialog?.dismiss()
        } else {
            rootDialogElement.tvDialogMessage.visibility = View.VISIBLE
        }
    }

    private fun setonClickSignupLogin(index: Int, rootDialogElement: SignDialogBinding, dialog: AlertDialog?) {
        dialog?.dismiss()

        if (index == DialogConst.SIGNUP_STATE) {
            accHelper.signUpWithEmail(rootDialogElement.edSignEmail.text.toString(), rootDialogElement.edSignPassword.text.toString())
        } else {
            accHelper.loginWithEmail(rootDialogElement.edSignEmail.text.toString(), rootDialogElement.edSignPassword.text.toString())
        }
    }

    private fun setDialogState(index: Int, rootDialogElement: SignDialogBinding) {
        if (index == DialogConst.SIGNUP_STATE) {
            rootDialogElement.tvSignTitle.text = act.resources.getString(R.string.sign_up)
            rootDialogElement.btSigninLogin.text = act.resources.getString(R.string.sign_up_action)
        } else {
            rootDialogElement.tvSignTitle.text = act.resources.getString(R.string.log_in)
            rootDialogElement.btSigninLogin.text = act.resources.getString(R.string.log_in_action)
            rootDialogElement.btForgetPassword.visibility = View.VISIBLE
        }
    }
}