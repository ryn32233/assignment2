package com.example.classapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.pokemon_recycler_view)

        recyclerView.layoutManager = LinearLayoutManager(this)

        val pokemon = mutableListOf<Pokemon>()

        for(i in 0 .. 30) {
            pokemon.add(createPokemon())
        }

        val adapter = PokemonAdapter(pokemon)
        recyclerView.adapter = adapter
    }

    private fun createPokemon() = Pokemon(
        name="Bulbasaur",
        type="Grass/Poison",
        image = R.drawable.baseline_catching_pokemon_24,
        dexNo = 1,
        region = "Kanto",
        id = 0,
        relation = listOf()

    )

}