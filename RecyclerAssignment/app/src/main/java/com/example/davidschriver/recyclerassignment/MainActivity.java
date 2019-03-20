package com.example.davidschriver.recyclerassignment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

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
        mRecyclerView.setAdapter(rAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));


    }
}
