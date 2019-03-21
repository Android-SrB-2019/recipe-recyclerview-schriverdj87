package com.example.davidschriver.recyclerassignment;
/*
 * @Date : 2019-03-20
 * @author : David Schriver
 */
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.davidschriver.recyclerassignment.model.Recipe;

import java.util.LinkedList;

public class RecipeListAdapter extends RecyclerView.Adapter<RecipeListAdapter.RecipeViewHolder>{


    private final LinkedList<Recipe> mRecipeList;
    private LayoutInflater mInflater;
    private MainActivity myParent;//*maniacal laughter*

    class RecipeViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        public final TextView name;
        public final TextView description;
        final RecipeListAdapter myAdapter;

        public RecipeViewHolder( View itemView, RecipeListAdapter adapter) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            description = itemView.findViewById(R.id.description);
            myAdapter = adapter;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            int myPosition = getLayoutPosition();
            Recipe datRecipe = mRecipeList.get(myPosition);

            myParent.seeRecipe(datRecipe);
        }
    }

    public RecipeListAdapter(Context context, LinkedList<Recipe> recipes)
    {
        mInflater = LayoutInflater.from(context);
        this.mRecipeList = recipes;
    }


    public void setParent (MainActivity to)
    {
        this.myParent = to;
    }

    @NonNull
    @Override
    public RecipeListAdapter.RecipeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View mRecipeView = mInflater.inflate(R.layout.recipe_item,parent,false);

        return new RecipeViewHolder(mRecipeView, this);
    }

    @Override
    public void onBindViewHolder(@NonNull RecipeListAdapter.RecipeViewHolder recipeViewHolder, int position) {
        Recipe currentRecipe = mRecipeList.get(position);
        recipeViewHolder.name.setText(currentRecipe.name);
        recipeViewHolder.description.setText(currentRecipe.description);
    }

    @Override
    public int getItemCount() {
        return mRecipeList.size();
    }
}
