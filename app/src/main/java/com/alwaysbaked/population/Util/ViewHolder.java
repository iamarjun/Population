package com.alwaysbaked.population.Util;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.alwaysbaked.population.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ViewHolder extends RecyclerView.ViewHolder {

    //widgets
    @BindView(R.id.tvCountry)
    TextView mCountry;
    @BindView(R.id.tvPopulation)
    TextView mPopulation;

    @BindView(R.id.ivFlag)
    ImageView mFlag;

    @BindView(R.id.rlItem)
    RelativeLayout mItem;

    public ViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

}
