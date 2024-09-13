package com.example.mypokedex;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mypokedex.adapter.Adapter;
import com.example.mypokedex.model.PokemonModel;

import java.util.List;

public class PokemonList extends AppCompatActivity {
    RecyclerView recyclerView;
    Adapter adapter;

    List<PokemonModel> pokemonModel = List.of(
            new PokemonModel (1, "Bulbasaur", "Bulbasaur is a dual-type Grass/Poison Pokémon known for its small, squat body and the plant bulb growing on its back. This bulb stores energy and grows into a large plant as it evolves. It has a calm, gentle nature and is often seen as a starter Pokémon. The bulb also gives Bulbasaur access to various plant-based attacks, like Vine Whip and Solar Beam. Its signature move, Leech Seed, allows it to drain energy from opponents.", R.drawable.bulbasaur),
            new PokemonModel(2, "Charmander", "Charmander is a Fire-type Pokémon with a small, dinosaur-like body and a flame on the tip of its tail, which reflects its life force. As a warm-hearted but fierce Pokémon, Charmander can unleash fire-based attacks like Ember and Flamethrower. The intensity of its tail flame increases with its emotions, and it evolves into the more powerful Charmeleon and eventually Charizard. It’s known for being a loyal and determined companion.", R.drawable.charmander),
            new PokemonModel(3, "Squirtle", "Squirtle is a Water-type Pokémon resembling a small, blue turtle with a hard shell that provides defense in battle. It can retract into its shell for protection and uses its water-based attacks, like Water Gun and Hydro Pump, to defeat opponents. Squirtle is playful but brave, often loyal to its trainer. As it grows, it evolves into Wartortle and later into the powerful Blastoise. Its shell also helps it swim at high speeds, making it a swift and agile fighter.", R.drawable.squirtle)
    );

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_pokemon_list);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.recyclerView), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        recyclerView = findViewById(R.id.recyclerView);
        adapter = new Adapter(pokemonModel, this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }
}