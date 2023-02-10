package com.example.classapplication.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.classapplication.Pokemon
import com.example.classapplication.PokemonAdapter
import com.example.classapplication.R


class PokemonListFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_pokemon_list, container, false)

        val recyclerView = view.findViewById<RecyclerView>(R.id.pokemon_recycler_view)

        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        val pokemon = mutableListOf<Pokemon>()

        for(i in 0 .. 30) {
            pokemon.add(createPokemon())
        }

        val adapter = PokemonAdapter(pokemon)
        recyclerView.adapter = adapter

        return view
    }
    private fun createPokemon() = Pokemon(
        name = "Bulbasaur",
        type = "Grass/Poison",
        image = R.drawable.baseline_catching_pokemon_24,
        dexNo = 1,
        region = "Kanto",
        id = 0,
        relation = listOf()

    )
}
