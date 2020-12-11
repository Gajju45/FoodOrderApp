package com.android.gajju45.foodordersqlite;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.icu.text.CaseMap;
import android.os.Bundle;

import com.android.gajju45.foodordersqlite.Adapters.MainAdapter;
import com.android.gajju45.foodordersqlite.Adapters.OrderAdapter;
import com.android.gajju45.foodordersqlite.Database.DBHelper;
import com.android.gajju45.foodordersqlite.Models.OrdersModel;
import com.android.gajju45.foodordersqlite.databinding.ActivityMainBinding;
import com.android.gajju45.foodordersqlite.databinding.ActivityOrderBinding;

import java.util.ArrayList;

public class OrderActivity extends AppCompatActivity {

    ActivityOrderBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityOrderBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setTitle("Orders");

        DBHelper helper=new DBHelper(this);
        ArrayList<OrdersModel> list=helper.getOrders();
        /*list.add(new OrdersModel(R.drawable.whitepaasta,"White Pasta","4","456491658"));
      list.add(new OrdersModel(R.drawable.whitepaasta,"White Pasta","4","456491658"));
      list.add(new OrdersModel(R.drawable.whitepaasta,"White Pasta","4","456491658"));
      list.add(new OrdersModel(R.drawable.whitepaasta,"White Pasta","4","456491658"));
      list.add(new OrdersModel(R.drawable.whitepaasta,"White Pasta","4","456491658"));
      list.add(new OrdersModel(R.drawable.whitepaasta,"White Pasta","4","456491658"));
      list.add(new OrdersModel(R.drawable.whitepaasta,"White Pasta","4","456491658"));
      list.add(new OrdersModel(R.drawable.whitepaasta,"White Pasta","4","456491658"));
      list.add(new OrdersModel(R.drawable.whitepaasta,"White Pasta","4","456491658"));
      list.add(new OrdersModel(R.drawable.whitepaasta,"White Pasta","4","456491658"));
      list.add(new OrdersModel(R.drawable.whitepaasta,"White Pasta","4","456491658"));
      list.add(new OrdersModel(R.drawable.whitepaasta,"White Pasta","4","456491658"));
      list.add(new OrdersModel(R.drawable.whitepaasta,"White Pasta","4","456491658"));

         */


        OrderAdapter adapter=new OrderAdapter(list,this);
        binding.orderRecyclerView.setAdapter(adapter);

        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        binding.orderRecyclerView.setLayoutManager(layoutManager);



    }
}