package com.alwaysbaked.population

import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView

import com.bumptech.glide.Glide

class FlagDialog : DialogFragment() {

    private var mFlag: ImageView? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.dialog_flag, container, false)
        Log.d(TAG, "onCreateView: started")

        mFlag!!.findViewById<View>(R.id.ivFlag)

        val url = arguments!!.getString("Image URL")

        Glide.with(activity!!)
                .asBitmap()
                .load(url)
                .into(mFlag!!)

        return view
    }

    companion object {
        private val TAG = "FlagDialog"
    }

}
