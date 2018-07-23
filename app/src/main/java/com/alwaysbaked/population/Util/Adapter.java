package com.alwaysbaked.population.Util;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.alwaysbaked.population.FlagDialog;
import com.alwaysbaked.population.MainActivity;
import com.alwaysbaked.population.Model.Worldpopulation;
import com.alwaysbaked.population.R;
import com.bumptech.glide.Glide;

import java.util.List;


public class Adapter extends RecyclerView.Adapter<ViewHolder> {
    private static final String TAG = "Adapter";

    private Context mContext;
    private List<Worldpopulation> populationList;
    private Bundle bundle;

    public Adapter(Context mContext, List<Worldpopulation> populationList) {
        this.mContext = mContext;
        this.populationList = populationList;
        bundle = new Bundle();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.d(TAG, "onCreateViewHolder: started");
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_country, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        Log.d(TAG, "onBindViewHolder: started.");

        holder.mCountry.setText(String.valueOf(populationList.get(position).getCountry()));
        holder.mPopulation.setText(String.valueOf(populationList.get(position).getPopulation()));


        Glide.with(mContext)
                .asBitmap()
                .load(String.valueOf(populationList.get(position).getFlag()))
                .into(holder.mFlag);


        holder.mItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: clicked an item on RecyclerView");
                Toast.makeText(mContext, String.valueOf(populationList.get(position).getCountry()), Toast.LENGTH_SHORT).show();

                bundle.putString("Image URL", String.valueOf(populationList.get(position).getFlag()));

                FlagDialog flagDialog = new FlagDialog();
                flagDialog.setArguments(bundle);

                flagDialog.show(((AppCompatActivity)mContext).getSupportFragmentManager(), "Flag Dialog");
                }

        });

    }

    @Override
    public int getItemCount() {
        return populationList.size();
    }
}
