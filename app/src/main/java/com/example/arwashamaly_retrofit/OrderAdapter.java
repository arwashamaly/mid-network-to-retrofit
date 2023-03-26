package com.example.arwashamaly_retrofit;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.arwashamaly_retrofit.databinding.OrderItemBinding;

import java.util.ArrayList;

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.orderViewHolder> {
    ArrayList<Order> dataArrayList;
    Context context;

    public OrderAdapter(ArrayList<Order> dataArrayList, Context context) {
        this.dataArrayList = dataArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public orderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        OrderItemBinding binding = OrderItemBinding.inflate(LayoutInflater.from(parent.getContext())
                ,parent,false);
        return new orderViewHolder(binding);    }

    @Override
    public void onBindViewHolder(@NonNull orderViewHolder holder, int position) {
        Order order = dataArrayList.get(position);
        holder.tv_phone_num.setText(order.getPhone());
        holder.tv_details.setText(order.getDetails());

        Photo photo =order.getPhoto_order().get(0);
        Glide.with(context).load(photo.getPhoto()).into(holder.img);

    }

    @Override
    public int getItemCount() {
        return dataArrayList.size();
    }

    class orderViewHolder extends RecyclerView.ViewHolder {
        TextView tv_details , tv_phone_num;
        ImageView img;
        public orderViewHolder(@NonNull OrderItemBinding binding) {
            super(binding.getRoot());
            tv_details = binding.tvDetails;
            tv_phone_num=binding.tvPhone;
            img=binding.img;
        }
    }
}
