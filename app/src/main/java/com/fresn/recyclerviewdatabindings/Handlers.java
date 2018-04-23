package com.fresn.recyclerviewdatabindings;

import android.content.Context;
import android.widget.Toast;

public class Handlers {
    private Context appContext;

    public Context getAppContext() {
        return appContext;
    }

    public void setAppContext(Context appContext) {
        this.appContext = appContext;
    }

    public void RecycleViewClickHandler(News news){
        Toast toast = Toast.makeText(appContext, news.getNewsArticle(), Toast.LENGTH_SHORT);
        toast.show();
    }
}
