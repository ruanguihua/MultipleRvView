package com.rgh.multiplervview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by RGH on 2017/10/20.
 */

public class DemoAdaper extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private LayoutInflater mLayoutInflater;
    List<DataModel> mdata = new ArrayList<>();

    public DemoAdaper(Context context) {
        mLayoutInflater = LayoutInflater.from(context);

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        switch (viewType) {
            case DataModel.TYPE_ONE:
                return new TypeOneViewHolder(mLayoutInflater.inflate(R.layout.item_type_one, parent, false));

            case DataModel.TYPE_TWO:
                return new TypeTwoViewHolder(mLayoutInflater.inflate(R.layout.item_type_two, parent, false));

            case DataModel.TYPE_THREE:
                return new TypeThreeViewHolder(mLayoutInflater.inflate(R.layout.item_type_three, parent, false));


        }


        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((TypeAbstractViewHolder) holder).bindHolder(mdata.get(position));
    }

    @Override
    public int getItemCount() {
        return mdata.size();
    }

    @Override
    public int getItemViewType(int position) {
        return mdata.get(position).type;
    }

    public void addList(List<DataModel> list) {
        mdata.addAll(list);
    }
}
