package com.example.mad_project;
import java.*;
import java.util.List;

import android.*;
import android.content.Context;
//import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>{

    private List<NgoModel> objectList;
    private LayoutInflater inflater;
    public MyAdapter(Context context, List<NgoModel> objectList){
        inflater = LayoutInflater.from(context);
        this.objectList = objectList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.ngo_list, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        NgoModel current = objectList.get(position);
        //holder.setData(current, position);
        holder.title.setText(current.getTitle());
        holder.logo.setImageResource(current.getImageid());
        holder.type.setText(current.getType());
        holder.location.setText(current.getLocation());
        holder.phone.setText(current.getPhone());
        holder.website.setText(current.getWebsite());
    }

    @Override
    public int getItemCount() {
        return objectList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView title, type, location, phone, website;
        private ImageView logo;
        private int position;
        private NgoModel currentObject;

        public MyViewHolder(View itemView) {
            super(itemView);
            logo = itemView.findViewById(R.id.logo);
            title = itemView.findViewById(R.id.title);
            type = itemView.findViewById(R.id.type);
            location = itemView.findViewById(R.id.location);
            phone = itemView.findViewById(R.id.phone);
            website = itemView.findViewById(R.id.website);
        }
    }
}
