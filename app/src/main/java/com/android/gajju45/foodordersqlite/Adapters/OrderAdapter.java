package com.android.gajju45.foodordersqlite.Adapters;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.gajju45.foodordersqlite.Database.DBHelper;
import com.android.gajju45.foodordersqlite.DetailActivity;
import com.android.gajju45.foodordersqlite.Models.OrdersModel;
import com.android.gajju45.foodordersqlite.R;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.viewHolder> {

    ArrayList<OrdersModel> list;
    Context context;

    public OrderAdapter(ArrayList<OrdersModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.order_sapmle, parent, false);

        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {

        final OrdersModel model = list.get(position);
        holder.orderImage.setImageResource(model.getOrderImage());
        holder.soldItemName.setText(model.getSoldItemName());
        holder.orderNumber.setText(model.getOrderNumber());
        holder.price.setText(model.getPrice());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(context, DetailActivity.class);
                intent.putExtra("id",Integer.parseInt(model.getOrderNumber()));
                intent.putExtra("type",2);
                context.startActivity(intent);
            }
        });

        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                new AlertDialog.Builder(context)
                        .setTitle("delete Item")
                        .setMessage("Are u sure to delete this")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                DBHelper helper=new DBHelper(context);
                                if (helper.deleteOrder(model.getOrderNumber())>=0){
                                    Toast.makeText(context, "Delete", Toast.LENGTH_SHORT).show();
                                }
                                else {
                                    Toast.makeText(context, "Error", Toast.LENGTH_SHORT).show();
                                }

                            }
                        }).setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                }).show();

                return false;
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {

        ImageView orderImage;
        TextView soldItemName, orderNumber, price;

        public viewHolder(@NonNull View itemView) {
            super(itemView);

            orderImage = itemView.findViewById(R.id.orderImage);
            soldItemName = itemView.findViewById(R.id.orderItemName);
            orderNumber = itemView.findViewById(R.id.orderNUm);
            price = itemView.findViewById(R.id.orderPriceOrderActivity);
        }
    }
}
