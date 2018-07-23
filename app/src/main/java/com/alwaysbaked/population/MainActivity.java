package com.alwaysbaked.population;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.alwaysbaked.population.Model.Root;
import com.alwaysbaked.population.Retrofit.API;
import com.alwaysbaked.population.Retrofit.RetrofitClient;
import com.alwaysbaked.population.Util.Adapter;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    private API myAPI;
    private CompositeDisposable disposable = new CompositeDisposable();
    private Retrofit retrofit;

    @BindView(R.id.rvFeed)
    RecyclerView mFeed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate: started.");
        ButterKnife.bind(this);

        //initialise
        retrofit = RetrofitClient.getInstance();
        myAPI = retrofit.create(API.class);

        //recycler view
        mFeed.setHasFixedSize(true);
        mFeed.setLayoutManager(new LinearLayoutManager(this));

        fetchData();
    }

    private void fetchData() {
        disposable.add(myAPI.getTheWorldPopulation()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Root>() {
                    @Override
                    public void accept(Root root) throws Exception {
                        displayData(root);
                    }
                }));

    }

    private void displayData(Root root) {
        Adapter adapter = new Adapter(this, root.getWorldpopulation());
        mFeed.setAdapter(adapter);
    }

    @Override
    protected void onStop() {
        disposable.clear();
        super.onStop();
    }
}
