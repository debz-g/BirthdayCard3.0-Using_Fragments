package com.example.usingfragments

import android.content.Intent
import android.graphics.drawable.BitmapDrawable
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import com.example.usingfragments.databinding.FragmentCard2Binding

class Card2Fragment : Fragment(R.layout.fragment_card2) {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val vi=inflater.inflate(R.layout.fragment_card2,container,false)

        val btnShareTwo=vi.findViewById<Button>(R.id.btnShare2)
        val cardTwo=vi.findViewById<ImageView>(R.id.ivCard2)
        btnShareTwo.setOnClickListener {
            // Step 1: Create Share itent
            val intent = Intent(Intent.ACTION_SEND).setType("image/*")

            // Step 2: Get Bitmap Drawable file from imageView
            val bitmapDrawable = cardTwo.drawable as BitmapDrawable // your imageView here.

            // Step 3: Convert Drawable File to Bitmap
            val bitmap=bitmapDrawable.bitmap

            // Step 4: Save image & get path of it
            val path = MediaStore.Images.Media.insertImage(requireContext().contentResolver,bitmap,
                "tempimage", null)

            // Step 5: Get URI of saved image
            val uri = Uri.parse(path)

            // Step 6: Put Uri as extra to share intent
            intent.putExtra(Intent.EXTRA_STREAM, uri)

            // Step 7: Start Activity with chooser and pass the intent
            startActivity(Intent.createChooser(intent,"Share Image"))
        }
        return vi
    }
}