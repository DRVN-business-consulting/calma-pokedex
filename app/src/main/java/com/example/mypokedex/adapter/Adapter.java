package com.example.mypokedex.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mypokedex.PokemonDetails;
import com.example.mypokedex.R;
import com.example.mypokedex.model.PokemonModel;

import java.util.List;

public class Adapter extends RecyclerView.Adapter {
    private List<PokemonModel> pokemonModel;
    private Context context;

    public Adapter(List<PokemonModel> pokemonModel, Context context) {
        this.pokemonModel = pokemonModel;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       LayoutInflater inflater = LayoutInflater.from(parent.getContext());
       View view = inflater.inflate(R.layout.pokemon_item, parent, false);
       MyViewHolder viewHolder = new MyViewHolder(view);
       return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        PokemonModel pokemon = pokemonModel.get(holder.getAdapterPosition());
        ImageView imageView = holder.itemView.findViewById(R.id.pokemonImage);
        TextView textView = holder.itemView.findViewById(R.id.pokemonText);
        imageView.setImageResource(pokemon.getImageId());
        textView.setText(pokemon.getName());

        holder.itemView.setOnClickListener(view -> {
            Intent intent = new Intent(context, PokemonDetails.class);
            intent.putExtra("pokemon_name",pokemon.getName());
            intent.putExtra("pokemon_desc",pokemon.getDescription());
            intent.putExtra("pokemon_img", pokemon.getImageId());
            context.startActivity(intent);

        });
    }

    @Override
    public int getItemCount() {
        return pokemonModel.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        public  MyViewHolder(View ItemView) {
            super(ItemView);
        }
    }
}
