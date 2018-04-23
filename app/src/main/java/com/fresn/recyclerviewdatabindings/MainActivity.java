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


public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding mBinding;
    private RecyclerView.LayoutManager mLayoutManager;
    private RecyclerView.Adapter mAdapter;
    private List<News> newsList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mLayoutManager = new LinearLayoutManager(this);
        mBinding.mainView.setLayoutManager(mLayoutManager);
        mAdapter = new NewsAdapter(newsList);
        mBinding.mainView.setAdapter(mAdapter);
        // Add some news
        News news = new News();
        news.setNewsArticle("News article 1");
        news.setNewsHeading("News heading 1");
        newsList.add(news);
        news = new News();
        news.setNewsArticle("News article 2");
        news.setNewsHeading("News heading 2");
        newsList.add(news);
        news = new News();
        news.setNewsArticle("News article 3");
        news.setNewsHeading("News heading 3");
        newsList.add(news);
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public View onCreateView(View parent, String name, Context context, AttributeSet attrs) {
        return super.onCreateView(parent, name, context, attrs);
    }
}
