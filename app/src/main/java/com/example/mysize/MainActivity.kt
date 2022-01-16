package com.example.mysize

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.edit
import androidx.preference.PreferenceManager
import com.example.mysize.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setupBinding()
        setupPreference()

    }

    private fun setupBinding() {
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    private fun setupPreference() {
        val pref = PreferenceManager.getDefaultSharedPreferences(this)
        val editNeck = pref.getString("NECK", "")
        val editSleeve = pref.getString("SLEEVE", "")
        val editWaist = pref.getString("WAIST", "")
        val editInseam = pref.getString("INSEAM", "")

        setText(editNeck, editSleeve, editWaist, editInseam)

        binding.save.setOnClickListener { onSaveTapped() }
    }

    private fun setText(neck: String?,
                        sleeve: String?,
                        waist: String?,
                        inseam: String?) {
        binding.neck.setText(neck)
        binding.sleeve.setText(sleeve)
        binding.waist.setText(waist)
        binding.inseam.setText(inseam)
    }

    private fun onSaveTapped() {
        val pref = PreferenceManager.getDefaultSharedPreferences(this)
        pref.edit {
            putString("NECK", binding.neck.text.toString())
            putString("SLEEVE", binding.sleeve.text.toString())
            putString("WAIST", binding.waist.text.toString())
            putString("INSEAM", binding.inseam.text.toString())
        }
    }

}