package com.example.friendefy

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.friendefy.databinding.FragmentQrCodeBinding
import com.google.zxing.BarcodeFormat
import com.google.zxing.qrcode.QRCodeWriter
import java.lang.Exception

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [QrCode.newInstance] factory method to
 * create an instance of this fragment.
 */
class QrCode : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var binding: FragmentQrCodeBinding
    val key = "message"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentQrCodeBinding.inflate(layoutInflater)

        try{


            val v = QRCodeWriter().encode(fragdata.m, BarcodeFormat.QR_CODE,600,600);
            var mBitmap = Bitmap.createBitmap(600, 600, Bitmap.Config.ARGB_8888)
            for (i in 0..599) {
                for (j in 0..599) {
                    mBitmap.setPixel(i, j, if (v.get(i, j)) Color.BLACK else Color.WHITE)
                }
            }

            binding.imageView.setImageBitmap(mBitmap)

        }catch ( e:Exception){
            e.printStackTrace()
            Log.d("hello??",e.message.toString())
        }



        return binding.root
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment QrCode.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            QrCode().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}