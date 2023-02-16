package com.example.classapplication.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.classapplication.R


class PokemonDetailFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_pokemon_detail, container, false)

        if(arguments != null) {
            val name = requireArguments().getString("name")
            val type = requireArguments().getString("type")
            val dexNo = requireArguments().getString("dexNo")
            val image = requireArguments().getString("image")
            val region = requireArguments().getString("region")

            view.findViewById<TextView>(R.id.pokemon_region).text = region
        }

        return view
    }
}
