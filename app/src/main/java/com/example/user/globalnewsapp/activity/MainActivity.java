package com.example.user.globalnewsapp.activity;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.Toast;

import com.example.user.globalnewsapp.R;
import com.example.user.globalnewsapp.adapter.NewsAdapter;
import com.example.user.globalnewsapp.data.vo.MyItem;
import com.example.user.globalnewsapp.data.vo.News;
import com.example.user.globalnewsapp.view_model.NewsViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity{
    Toolbar tb;
    RecyclerView rv;
    SwipeRefreshLayout sfl;
    NewsViewModel nvm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tb=findViewById(R.id.tb_am);
        setSupportActionBar(tb);
        rv=findViewById(R.id.rv_am);
        rv.setLayoutManager(new LinearLayoutManager(this));
        sfl=findViewById(R.id.srl_am);

        nvm=ViewModelProviders.of(this).get(NewsViewModel.class);
        nvm.getNews().observe(this, new Observer<List<MyItem>>() {
            @Override
            public void onChanged(@Nullable List<MyItem> myItems) {
                NewsAdapter adapter=new NewsAdapter(MainActivity.this,myItems);
                rv.setAdapter(adapter);
            }
        });

        sfl.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                nvm.loadData();
            }
        });

        Log.d("hello","onCreate works");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("hello","onResume works");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("hello","onStop works");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("hello","onDestroy works");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("hello","onRestart works");
    }
}
