package com.fresn.recyclerviewdatabindings;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;
import com.fresn.recyclerviewdatabindings.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

import static java.security.AccessController.getContext;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding mBinding;
    private RecyclerView.LayoutManager mLayoutManager;
    private RecyclerView.Adapter mAdapter;
    private List<News> newsList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Add some news
        News news = new News();
        news.setNewsArticle("Test article 1");
        news.setNewsHeading("Test heading 1");
        newsList.add(news);
    }

    @Override
    public View onCreateView(View parent, String name, Context context, AttributeSet attrs) {
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mLayoutManager = new LinearLayoutManager(this);
        mBinding.mainView.setLayoutManager(mLayoutManager);
        mAdapter = new NewsAdapter(newsList);
        mBinding.mainView.setAdapter(mAdapter);
        return super.onCreateView(parent, name, context, attrs);

    }
}
