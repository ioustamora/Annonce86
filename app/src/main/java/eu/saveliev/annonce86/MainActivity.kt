package eu.saveliev.annonce86

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.main_content.*

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }

    private fun init() {
        val toggle = ActionBarDrawerToggle(this, drawerLayaut, toolbar, R.string.open, R.string.close)
        drawerLayaut.addDrawerListener(toggle)
        toggle.syncState()
        navView.setNavigationItemSelectedListener(this)
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
                Toast.makeText(this, "signin", Toast.LENGTH_LONG).show()
            }
            R.id.id_acc_logout -> {
                Toast.makeText(this, "logout", Toast.LENGTH_LONG).show()
            }
            R.id.id_acc_login -> {
                Toast.makeText(this, "login", Toast.LENGTH_LONG).show()
            }
        }
        drawerLayaut.closeDrawer(GravityCompat.START)
        return true
    }
}