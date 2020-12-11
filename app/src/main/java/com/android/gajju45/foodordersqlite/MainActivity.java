package com.android.gajju45.foodordersqlite;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.android.gajju45.foodordersqlite.Adapters.MainAdapter;
import com.android.gajju45.foodordersqlite.Models.MainModel;
import com.android.gajju45.foodordersqlite.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());

        ArrayList<MainModel> list=new ArrayList<>();

        list.add(new MainModel(R.drawable.pizza,"Pizza","7","Bite into supreme delight of Black Olives, Onions,, Peri-Peri Chicken, Grilled"));
        list.add(new MainModel(R.drawable.burger,"Burger","5","toppings such as lettuce, tomato, onion, pickles, bacon, mayonnaise, ketchup, and mustard."));
        list.add(new MainModel(R.drawable.magiepaasta,"Paasta with ","5","Seafood pasta with shrimps and tomatoes in a pan"));

        list.add(new MainModel(R.drawable.whitepaasta,"White Paasta","10","Penne pasta, pizza, butter, carrot, garlic"));
        list.add(new MainModel(R.drawable.vegmanchurian,"Veg Manchurian Gravy","9"," Goes best with fried rice, schezwan fried rice or steamed rice."));
        list.add(new MainModel(R.drawable.magiepaasta,"Burger","5","toppings such as lettuce, tomato, onion, pickles, bacon, mayonnaise, ketchup, and mustard."));

        MainAdapter adapter=new MainAdapter(list,this);
        binding.recyclerView.setAdapter(adapter);

        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        binding.recyclerView.setLayoutManager(layoutManager);



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.orders:
                startActivity(new Intent(MainActivity.this,OrderActivity.class));
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}