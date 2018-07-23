package com.alwaysbaked.population;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FlagDialog extends DialogFragment {
    private static final String TAG = "FlagDialog";

    @BindView(R.id.ivFlag)
    ImageView mFlag;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dialog_flag,  container, false);
        Log.d(TAG, "onCreateView: started");

        ButterKnife.bind(this, view);

        String URL = getArguments().getString("Image URL");

        Glide.with(getActivity())
                .asBitmap()
                .load(URL)
                .into(mFlag);

        return view;
    }

}
