package com.example.recycler;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class RecycleViewAdapter extends RecyclerView.Adapter<RecycleViewAdapter.ViewHolder>{

    private static final String TAG = "RecycleViewAdapter";

    private ArrayList<String> animalNames = new ArrayList<>();
    private ArrayList<String> imageUrls = new ArrayList<>();
    private Context ctx;


    public RecycleViewAdapter(ArrayList<String> animalNames, ArrayList<String> imageUrls, Context ctx) {
        this.animalNames = animalNames;
        this.imageUrls = imageUrls;
        this.ctx = ctx;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater
                .from(parent.getContext())
                .inflate(R .layout.layout_list_item,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder,final int position) {

        Log.d(TAG, "onBindViewHolder: Called");
        Glide.with(ctx)
                .asBitmap()
                .load(imageUrls.get(position))
                .into(holder.animalImage);

        holder.animalName.setText(animalNames.get(position));
        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: Clicked on: " + animalNames.get(position));
                Toast.makeText(ctx, "I will start a new Activity Here..", Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return animalNames.size() ;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        CircleImageView animalImage;
        TextView animalName;
        ConstraintLayout parentLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            animalImage = itemView.findViewById(R.id.animal_image);
            animalName = itemView.findViewById(R.id.tv_animal_name);
            parentLayout = itemView.findViewById(R.id.parent_layout);

        }
    }
}
