package com.example.mypokedex;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class PokemonDetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_pokemon_details);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.pokemonDetails), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Intent intent = getIntent();
        String pokemonName = intent.getStringExtra("pokemon_name");
        String pokemonDescription = intent.getStringExtra("pokemon_desc");
        int pokemonImage = intent.getIntExtra("pokemon_img", -1);

        TextView textView = findViewById(R.id.pokemonDetailName);
        TextView textView1 = findViewById(R.id.pokemonDetailDescription);
        ImageView imageView = findViewById(R.id.pokemonImage);

        textView.setText(pokemonName);
        textView1.setText(pokemonDescription);
        imageView.setImageResource(pokemonImage);

        imageView.setOnClickListener(view -> {
            finish();
        });

    }
}