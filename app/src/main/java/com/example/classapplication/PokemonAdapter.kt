package com.example.classapplication

import android.icu.text.Transliterator.Position
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.fragment.app.commit
import androidx.recyclerview.widget.RecyclerView
import com.example.classapplication.ui.PokemonDetailFragment

class PokemonAdapter(private val pokemon: List<Pokemon>) :
    RecyclerView.Adapter<PokemonAdapter.PokemonViewHolder>() {


    inner class PokemonViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val pokemonImage: ImageView = itemView.findViewById(R.id.pokemon_image)
        val pokemonName: TextView = itemView.findViewById(R.id.pokemon_name)
        val pokemonType: TextView = itemView.findViewById(R.id.pokemon_type)
        val pokemonNo: TextView = itemView.findViewById(R.id.pokemon_dexNo)
        val pokemonRegion: TextView = itemView.findViewById(R.id.pokemon_region)

        init {
            itemView.setOnClickListener(
                onItemClick(adapterPosition)
            )

        }
    }
}

override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonViewHolder {
    val view = LayoutInflater.from(parent.context)
        .inflate(R.layout.pokemon_card_view, parent, false)
    return PokemonViewHolder(view) { position ->
        val pokemon = pokemon[position]
        val bundle = bundleOf(
            "name" to pokemon.name,
            "type" to pokemon.type,
            "dexNo" to pokemon.dexNo,
            "region" to pokemon.region,
            "image" to pokemon.image
        )

        val detailFragment: PokemonDetailFragment()
        detailFragment.arguments = bundle

        val activity = view.context as AppCompatActivity
        activity.supportFragmentManager.commit {
            setReorderingAllowed(true)
            replace(R.id.fragment_container_view, detailFragment)
        }

    }
}

override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) {
    val pokemon = pokemon[position]
    //holder.pokemonImage.setImageResource(pokemon.image)

    Glide.with(holder.itemView.context)load(pokemon.image).into()
    holder.pokemonName.text = pokemon.name
    holder.pokemonType.text = pokemon.type
    holder.pokemonNo.text = pokemon.dexNo.toString()
    holder.pokemonRegion.text = pokemon.region
}

override fun getItemCount() = pokemon.size

