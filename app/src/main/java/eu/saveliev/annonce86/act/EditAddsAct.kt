package eu.saveliev.annonce86.act

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import eu.saveliev.annonce86.R
import eu.saveliev.annonce86.databinding.ActivityEditAddsBinding
import eu.saveliev.annonce86.dialogs.DialogSpinnerHelper
import eu.saveliev.annonce86.utils.CityHelper

class EditAddsAct : AppCompatActivity() {
    lateinit var rootElement: ActivityEditAddsBinding
    private val dialog = DialogSpinnerHelper()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        rootElement = ActivityEditAddsBinding.inflate(layoutInflater)
        setContentView(rootElement.root)
        init()
    }

    private fun init() {
        //
    }

    //OnClicks
    fun onClickSelectCountry(view: View) {
        val listCountries = CityHelper.getAllCountries(this)
        dialog.ShowSpinnerDialog(this, listCountries)
    }
}