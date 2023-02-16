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
import kotlin.random.Random


class PokemonListFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_pokemon_list, container, false)

        val recyclerView = view.findViewById<RecyclerView>(R.id.pokemon_recycler_view)

        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        val pokemon = mutableListOf<Pokemon>()
        val type = mutableListOf("Grass", "Fire", "Water", "Electric")
        val name = mutableListOf("Bulbasaur", "Charmander", "Squirtle", "Pikachu")
        val region = mutableListOf("Kanto", "Johto")
        val id = mutableListOf(1, 2, 3, 4)

        for(i in 0 .. 30) {
            pokemon.add(
                createPokemon(
                    "${name.random()}".trimStart(),
                    region.random(),
                    type.random(),
                    i
                )
            )
        }

        val adapter = PokemonAdapter(pokemon)
        recyclerView.adapter = adapter

        return view
    }
    private fun createPokemon(
        name: String,
        region: String,
        type: String,
        dexNo: Int,
        description: String,
        id: Int
    ) = Pokemon(
        name = name,
        region = region,
        type = type,
        dexNo = dexNo,
        description = description,
        image = "https://i.ebayimg.com/images/g/yhgAAOSws95fBYkU/s-l500.jpg",
        id = id,
        relation = listOf()
    )
}
