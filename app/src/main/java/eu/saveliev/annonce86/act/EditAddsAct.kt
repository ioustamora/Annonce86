package eu.saveliev.annonce86.act

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import eu.saveliev.annonce86.R
import eu.saveliev.annonce86.databinding.ActivityEditAddsBinding
import eu.saveliev.annonce86.utils.CityHelper

class EditAddsAct : AppCompatActivity() {
    private  lateinit var rootElement: ActivityEditAddsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        rootElement = ActivityEditAddsBinding.inflate(layoutInflater)
        setContentView(rootElement.root)

        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, CityHelper.getAllCountries(this))
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        rootElement.spCountry.adapter = adapter
    }
}