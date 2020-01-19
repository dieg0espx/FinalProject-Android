package com.example.morecipes;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;

import java.util.ArrayList;
import java.util.List;

public class ArticulosAdapter  extends FirestoreRecyclerAdapter<Articulo, ArticulosAdapter.ViewHolder> {

    /**
     * Create a new RecyclerView adapter that listens to a Firestore Query.  See {@link
     * FirestoreRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public ArticulosAdapter(@NonNull FirestoreRecyclerOptions<Articulo> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull ViewHolder holder, int position, @NonNull Articulo articulo) {
        System.out.println(position);
        holder.textViewDishname.setText(articulo.getDishname());
        holder.textViewIngredients.setText(articulo.getIngredients());
        holder.textViewSteps.setText(String.valueOf(articulo.getSteps()));
    }

    @Override
    public void updateOptions(@NonNull FirestoreRecyclerOptions<Articulo> options) {
        super.updateOptions(options);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.view_articulos,viewGroup,false);
        return new ViewHolder(view);
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView textViewDishname;
        TextView textViewIngredients;
        TextView textViewSteps;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewDishname = itemView.findViewById(R.id.textViewDishname);
            textViewIngredients = itemView.findViewById(R.id.textViewIngredients);
            textViewSteps = itemView.findViewById(R.id.textViewSteps);
        }
    }

}
