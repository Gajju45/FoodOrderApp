package com.android.gajju45.foodordersqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.android.gajju45.foodordersqlite.Database.DBHelper;
import com.android.gajju45.foodordersqlite.databinding.ActivityDetailBinding;
import com.android.gajju45.foodordersqlite.databinding.ActivityOrderBinding;

public class DetailActivity extends AppCompatActivity {

    ActivityDetailBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setTitle("Order Detail ");

        final DBHelper helper = new DBHelper(this);
        if (getIntent().getIntExtra("type", 0) == 1) {
            final int image = getIntent().getIntExtra("image", 0);
            final int price = Integer.parseInt(getIntent().getStringExtra("price"));
            final String name = getIntent().getStringExtra("name");
            final String description = getIntent().getStringExtra("desc");


            binding.detailImages.setImageResource(image);
            binding.pricelbl.setText(String.format("%d", price));
            binding.foodname.setText(name);
            binding.detailDescription.setText(description);


            binding.insertBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    boolean isInserted = helper.inserOrder(
                            binding.yourname.getText().toString(),
                            binding.phonenum.getText().toString(),
                            price,
                            image,
                            name,
                            description,
                            Integer.parseInt(binding.quantity.getText().toString())


                    );
                    if (isInserted) {
                        Toast.makeText(DetailActivity.this, "Inserted", Toast.LENGTH_SHORT).show();

                    } else {
                        Toast.makeText(DetailActivity.this, "Not Insert", Toast.LENGTH_SHORT).show();
                    }


                }
            });
        } else {
            /*
            values.put("name", name);//1
        values.put("phone", phone);//2
        values.put("price", price);//3
        values.put("image", image);//4
        values.put("description", desc);//5
        values.put("foodname", foodName);//6
        values.put("quantity", quantity);//7
             */
            int id = getIntent().getIntExtra("id", 0);
            Cursor cursor = helper.getOrderById(id);
            binding.yourname.setText(cursor.getString(1));
            binding.phonenum.setText(cursor.getString(2));
            binding.pricelbl.setText(String.format("%d", cursor.getInt(3)));
            int  image= cursor.getInt(4);
            binding.detailImages.setImageResource(image);
            binding.detailDescription.setText(cursor.getString(6));
            binding.foodname.setText(cursor.getString(7));
            binding.quantity.setText(cursor.getString(5));




            binding.insertBtn.setText("Update Now");
            binding.insertBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    boolean isUpdated=helper.updateOrder(
                            binding.yourname.getText().toString(),
                            binding.phonenum.getText().toString(),
                            id);

                    if (isUpdated)
                        Toast.makeText(DetailActivity.this, "Updated", Toast.LENGTH_SHORT).show();
                    else
                        Toast.makeText(DetailActivity.this, "Failed", Toast.LENGTH_SHORT).show();
                }
            });


        }

    }
}