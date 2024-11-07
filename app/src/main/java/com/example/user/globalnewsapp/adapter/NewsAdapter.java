package com.example.user.globalnewsapp.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.user.globalnewsapp.R;
import com.example.user.globalnewsapp.data.vo.MyItem;
import com.squareup.picasso.Picasso;

import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsHolder>{
    Context ctxt;
    List<MyItem>items;

    public NewsAdapter(Context ctxt, List<MyItem> items) {
        this.ctxt = ctxt;
        this.items = items;
    }

    @NonNull
    @Override
    public NewsHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater li=LayoutInflater.from(ctxt);
        View v=li.inflate(R.layout.sample_view,parent,false);
        NewsHolder nh=new NewsHolder(v);
        return nh;
    }

    @Override
    public void onBindViewHolder(@NonNull NewsHolder holder, int position) {
        MyItem i=items.get(position);
        Picasso.get().load(i.getImgLink())
                .into(holder.iv);
        holder.tvTitle.setText(i.getTitle());
        holder.tvContent.setText(i.getDescription());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class NewsHolder extends RecyclerView.ViewHolder {
        ImageView iv;
        TextView tvTitle,tvContent;
        public NewsHolder(View itemView) {
            super(itemView);
            iv=itemView.findViewById(R.id.iv_sv);
            tvTitle=itemView.findViewById(R.id.tv_title_sv);
            tvContent=itemView.findViewById(R.id.tv_content_sv);
        }
    }
}
