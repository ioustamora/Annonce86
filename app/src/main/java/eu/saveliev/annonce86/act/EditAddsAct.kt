package eu.saveliev.annonce86.act

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import eu.saveliev.annonce86.R
import eu.saveliev.annonce86.databinding.ActivityEditAddsBinding
import eu.saveliev.annonce86.dialogs.DialogSpinnerHelper
import eu.saveliev.annonce86.utils.CityHelper

class EditAddsAct : AppCompatActivity() {
    private  lateinit var rootElement: ActivityEditAddsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        rootElement = ActivityEditAddsBinding.inflate(layoutInflater)
        setContentView(rootElement.root)

        val listCountries = CityHelper.getAllCountries(this)
        val dialog = DialogSpinnerHelper()
        dialog.ShowSpinnerDialog(this, listCountries)
    }
}