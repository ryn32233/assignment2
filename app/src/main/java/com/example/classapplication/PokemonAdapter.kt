package com.example.classapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PokemonAdapter(private val pokemon: List<Pokemon>) : RecyclerView.Adapter<PokemonAdapter.PokemonViewHolder>() {


    class PokemonViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val pokemonImage: ImageView = itemView.findViewById(R.id.pokemon_image)
        val pokemonName: TextView = itemView.findViewById(R.id.pokemon_name)
        val pokemonType: TextView = itemView.findViewById(R.id.pokemon_type)
        val pokemonNo: TextView = itemView.findViewById(R.id.pokemon_dexNo)
        val pokemonRegion: TextView = itemView.findViewById(R.id.pokemon_region)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.pokemon_card_view, parent, false)
        return PokemonViewHolder(view)
    }

    override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) {
        val pokemon = pokemon[position]
        holder.pokemonImage.setImageResource(pokemon.image)
        holder.pokemonName.text = pokemon.name
        holder.pokemonType.text = pokemon.type
        holder.pokemonNo.text = pokemon.dexNo.toString()
        holder.pokemonRegion.text = pokemon.region
    }

    override fun getItemCount() = pokemon.size

}