package com.example.davidschriver.recyclerassignment;


/*
 * @Date : 2019-03-20
 * @author : David Schriver
 */
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.davidschriver.recyclerassignment.model.Recipe;
import com.squareup.picasso.Picasso;

public class Recipe_Show extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe__show);

        //Get the intent
        Intent intent = getIntent();
        //Get the views
        TextView txtName = findViewById(R.id.Recipe_Name);
        TextView txtIngredients = findViewById(R.id.txt_ingredients);
        TextView txtDirections = findViewById(R.id.txt_directions);
        ImageView img = findViewById(R.id.food_img);
        //Get the raw fields
        String rawName = intent.getStringExtra(Recipe.NAME);
        String rawIngredients = intent.getStringExtra(Recipe.INGREDIENTS);
        String rawDirections = intent.getStringExtra(Recipe.DIRECTIONS);
        String rawImage = intent.getStringExtra(Recipe.IMAGE);
        //Set the fields
        txtName.setText(rawName);
        txtIngredients.setText(rawIngredients);
        txtDirections.setText(rawDirections);
        Picasso.get().load(rawImage).fit().placeholder(R.drawable.foodplaceholder).error(R.drawable.foodplaceholder).into(img);
    }
}
