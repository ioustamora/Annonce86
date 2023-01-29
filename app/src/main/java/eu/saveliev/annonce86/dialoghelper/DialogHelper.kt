package eu.saveliev.annonce86.dialoghelper
import android.app.AlertDialog
import eu.saveliev.annonce86.MainActivity
import eu.saveliev.annonce86.databinding.SignDialogBinding

class DialogHelper(act: MainActivity) {
    private  val act = act
    fun createSignDialog() {
        val builder = AlertDialog.Builder(act)
        val rootDialogElement = SignDialogBinding.inflate(act.layoutInflater)
        val view = rootDialogElement.root
        builder.setView(view)
        builder.show()
    }
}