package com.winnie.stickynavscrollview.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.winnie.stickynavscrollview.R;

import java.util.List;

/**
 * Created by winnie on 2017/7/4.
 */

public class RecyclerTestAdapter extends RecyclerView.Adapter<RecyclerTestAdapter.MyViewHolder> {

    private Context context;
    private List<String> data;

    public RecyclerTestAdapter(Context context, List<String> data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recycler_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.gridView.setAdapter(new GridTestAdapter(context, data));
    }

    @Override
    public int getItemCount() {
        return 10;
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        GridView gridView;

        public MyViewHolder(View itemView) {
            super(itemView);
            gridView = (GridView) itemView.findViewById(R.id.gridview);
        }
    }
}
