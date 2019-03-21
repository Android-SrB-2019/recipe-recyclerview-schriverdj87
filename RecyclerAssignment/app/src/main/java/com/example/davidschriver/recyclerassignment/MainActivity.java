package com.example.davidschriver.recyclerassignment;

/*
* @Date : 2019-03-20
* @author : David Schriver
 */
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.davidschriver.recyclerassignment.model.DataProvider;
import com.example.davidschriver.recyclerassignment.model.Recipe;

import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {

    private  LinkedList<Recipe> mRecipies = new LinkedList<>();
    private RecyclerView mRecyclerView;
    private RecipeListAdapter rAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = findViewById(R.id.mainRecycle);
        mRecipies = Recipe.getRecipes();
        rAdapter = new RecipeListAdapter(this,mRecipies);
        rAdapter.setParent(this);
        mRecyclerView.setAdapter(rAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));


    }


    public void seeRecipe(Recipe recipe)
    {
        Intent intent = new Intent(this,Recipe_Show.class);
        intent.putExtra(Recipe.NAME,recipe.name);
        intent.putExtra(Recipe.DESCRIPTION, recipe.description);
        intent.putExtra(Recipe.DIRECTIONS, recipe.directions);
        intent.putExtra(Recipe.IMAGE, recipe.image);
        intent.putExtra (Recipe.INGREDIENTS, recipe.ingredients);
        startActivity(intent);

    }

    public void ToastIt(String message)
    {
        Toast toPut = Toast.makeText(getApplicationContext(),message,Toast.LENGTH_SHORT);
        toPut.show();
    }

}
