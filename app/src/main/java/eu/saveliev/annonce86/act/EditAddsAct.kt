package eu.saveliev.annonce86.act

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import eu.saveliev.annonce86.R
import eu.saveliev.annonce86.databinding.ActivityEditAddsBinding

class EditAddsAct : AppCompatActivity() {
    private  lateinit var rootElement: ActivityEditAddsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        rootElement = ActivityEditAddsBinding.inflate(layoutInflater)
        setContentView(rootElement.root)
    }
}