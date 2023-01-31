package eu.saveliev.annonce86.dialoghelper
import android.app.AlertDialog
import eu.saveliev.annonce86.MainActivity
import eu.saveliev.annonce86.R
import eu.saveliev.annonce86.accounthelper.AccountHelper
import eu.saveliev.annonce86.databinding.SignDialogBinding

class DialogHelper(private val act: MainActivity) {

    private val accHelper = AccountHelper(act)
    fun createSignDialog(index: Int) {
        val builder = AlertDialog.Builder(act)
        val rootDialogElement = SignDialogBinding.inflate(act.layoutInflater)
        val view = rootDialogElement.root
        builder.setView(view)

        if (index == DialogConst.SIGNUP_STATE) {
            rootDialogElement.tvSignTitle.text = act.resources.getString(R.string.sign_up)
            rootDialogElement.btSigninLogin.text = act.resources.getString(R.string.sign_up_action)
        } else {
            rootDialogElement.tvSignTitle.text = act.resources.getString(R.string.log_in)
            rootDialogElement.btSigninLogin.text = act.resources.getString(R.string.log_in_action)
        }
        val dialog = builder.create()
        rootDialogElement.btSigninLogin.setOnClickListener {
            dialog.dismiss()

            if (index == DialogConst.SIGNUP_STATE) {
                accHelper.signUpWithEmail(rootDialogElement.edSignEmail.text.toString(), rootDialogElement.edSignPassword.text.toString())
            } else {
                accHelper.loginWithEmail(rootDialogElement.edSignEmail.text.toString(), rootDialogElement.edSignPassword.text.toString())
            }
        }

        dialog.show()
    }
}