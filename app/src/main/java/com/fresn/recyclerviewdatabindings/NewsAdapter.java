package com.fresn.recyclerviewdatabindings;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fresn.recyclerviewdatabindings.databinding.NewsItemBinding;

import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsViewHolder>{
    private List<News> newsList;

    public class NewsViewHolder extends RecyclerView.ViewHolder {
        private final NewsItemBinding mBinding;

        public NewsViewHolder(View itemView) {
            super(itemView);
            mBinding = DataBindingUtil.bind(itemView);
        }

    }
    public NewsAdapter(List<News>newsList) {
        super();
        this.newsList = newsList;
}

    @Override
    public NewsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater =
                LayoutInflater.from(parent.getContext());
        NewsItemBinding itemBinding =
                NewsItemBinding.inflate(layoutInflater, parent, false);
        // Set handler to be used in XML layout
        Handlers handlers = new Handlers();
        handlers.setAppContext(parent.getContext());
        itemBinding.setHandlers(handlers);
        return new NewsViewHolder(itemBinding.getRoot());
    }

    @Override
    public void onBindViewHolder(NewsViewHolder holder, int position) {
        News sn = newsList.get(position);
        holder.mBinding.setNews(sn);
    }

    @Override
    public int getItemCount() {
        return newsList.size();
    }
}
