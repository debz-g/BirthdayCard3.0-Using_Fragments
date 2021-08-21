package com.example.usingfragments

import android.content.Intent
import android.graphics.drawable.BitmapDrawable
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.ImageView
import androidx.core.content.ContentProviderCompat.requireContext
import com.example.usingfragments.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val card1Fragment = Card1Fragment()
        val card2Fragment = Card2Fragment()

        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragmentView, card1Fragment)
            commit()
        }

        binding.btnFrag1.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.fragmentView, card1Fragment)
                addToBackStack("card 1")
                commit()
            }
        }

        binding.btnFrag2.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.fragmentView, card2Fragment)
                addToBackStack("card 2")
                commit()
            }
        }

    }
    }
