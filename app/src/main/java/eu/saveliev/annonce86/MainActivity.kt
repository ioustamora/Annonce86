package eu.saveliev.annonce86

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.common.api.ApiException
import com.google.android.material.navigation.NavigationView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import eu.saveliev.annonce86.databinding.ActivityMainBinding
import eu.saveliev.annonce86.dialoghelper.DialogConst
import eu.saveliev.annonce86.dialoghelper.DialogHelper
import eu.saveliev.annonce86.dialoghelper.GoogleAccConst

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    private lateinit var tvAccount: TextView
    private lateinit var rootElement:ActivityMainBinding
    private val dialogHelper = DialogHelper(this)
    val mAuth = FirebaseAuth.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        rootElement = ActivityMainBinding.inflate(layoutInflater)
        val view = rootElement.root
        setContentView(view)
        init()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if(requestCode == GoogleAccConst.GOOGLE_SIGN_IN_REQUEST_CODE) {
            //Log.d("My Log", "Sign in result")
            val task = GoogleSignIn.getSignedInAccountFromIntent(data)
            try {
               // val account =
            } catch (e: ApiException) {
                Log.d("My Log", "Api error: ${e.message}")
            }
        }
        super.onActivityResult(requestCode, resultCode, data)
    }

    override fun onStart() {
        super.onStart()
        uiUpdate(mAuth.currentUser)
    }

    private fun init() {
        val toggle = ActionBarDrawerToggle(this, rootElement.drawerLayaut, rootElement.mainContent.toolbar, R.string.open, R.string.close)
        rootElement.drawerLayaut.addDrawerListener(toggle)
        toggle.syncState()
        rootElement.navView.setNavigationItemSelectedListener(this)
        tvAccount = rootElement.navView.getHeaderView(0).findViewById(R.id.tvAccountEmail)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.id_tech -> {
                Toast.makeText(this, "tech", Toast.LENGTH_LONG).show()
            }
            R.id.id_voiture -> {
                Toast.makeText(this, "voiture", Toast.LENGTH_LONG).show()
            }
            R.id.id_pc -> {
                Toast.makeText(this, "pc", Toast.LENGTH_LONG).show()
            }
            R.id.id_moto -> {
                Toast.makeText(this, "moto", Toast.LENGTH_LONG).show()
            }
            R.id.id_mobile -> {
                Toast.makeText(this, "mobile", Toast.LENGTH_LONG).show()
            }
            R.id.id_acc_sign -> {
                dialogHelper.createSignDialog(DialogConst.SIGNUP_STATE)
                //Toast.makeText(this, "signin", Toast.LENGTH_LONG).show()
            }
            R.id.id_acc_logout -> {
                uiUpdate(null)
                Toast.makeText(this, "logout", Toast.LENGTH_LONG).show()
            }
            R.id.id_acc_login -> {
                dialogHelper.createSignDialog(DialogConst.LOGIN_STATE)
                //Toast.makeText(this, "login", Toast.LENGTH_LONG).show()
            }
        }
        rootElement.drawerLayaut.closeDrawer(GravityCompat.START)
        return true
    }

    fun uiUpdate(user: FirebaseUser?) {
        tvAccount.text = if(user == null) {
            resources.getString(R.string.not_reg)
        } else {
            user.email
        }
    }
}