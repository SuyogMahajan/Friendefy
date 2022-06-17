package com.example.friendefy

import android.graphics.Bitmap
import android.graphics.Color
import android.graphics.Color.*
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.friendefy.databinding.ActivityMain2Binding
import com.google.zxing.BarcodeFormat
import com.google.zxing.qrcode.QRCodeWriter
import java.util.*


class MainActivity2 : AppCompatActivity() {

    private lateinit var binding:ActivityMain2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMain2Binding.inflate(layoutInflater)

        setContentView(binding.root)
        val qr = QrCode()
        val profile = profile()
        val scanner = QrCodeScanner()
        val bundle  = Bundle()

        binding.bottomNev.setOnItemSelectedListener{

            when(it.itemId) {
                R.id.qr -> {
                    loadFrag(qr)
                }

                R.id.scanner -> {
                    loadFrag(scanner)
                }
                R.id.profile -> {
                    loadFrag(profile)
                }
            }

            true
        }

    }
    fun loadFrag(fragment:Fragment){

        val trans = supportFragmentManager.beginTransaction()
        trans.replace(binding.constLay.id,fragment)
        trans.addToBackStack(null)
        trans.commit()

    }

}
class fragdata{
    companion object {
        var m:String = ""
    }
}
