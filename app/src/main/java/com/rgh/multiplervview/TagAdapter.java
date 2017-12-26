package com.rgh.multiplervview;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;



import java.util.List;


/**
 * Created by Allen on 2017/4/14.
 *
 * 评论页面的适配器
 */

public class TagAdapter extends RecyclerView.Adapter<TagAdapter.ViewHolder> {

    private List<ScopeTypeBean> tagList;

    private int num=-1;

    public TagAdapter(List<ScopeTypeBean> tagList) {
        this.tagList = tagList;

    }

    @Override
    public TagAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_scope, parent, false);
        ViewHolder vh = new ViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(final TagAdapter.ViewHolder holder, final int position) {
        holder.mTextView.setText(tagList.get(position).name);
        holder.itemView.setTag(tagList.get(position));

        if (position == num) {
            holder.mTextView.setChecked(true);
        } else {
            holder.mTextView.setChecked(false);
        }
        holder.mTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                notifyAdapter(position);

                if (mOnChoiceClickListen != null) {
                    mOnChoiceClickListen.choiceClick( holder.mTextView,position);
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return tagList.size();
    }
    @Override
    public int getItemViewType(int position) {
        return tagList.get(position).type;
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        public CheckBox mTextView;

        public ViewHolder(View view) {
            super(view);
            mTextView = (CheckBox) view.findViewById(R.id.cb_fruit);
        }
    }

    private OnChoiceClickListen mOnChoiceClickListen;


    public interface OnChoiceClickListen {

        void choiceClick(TextView textView, int position);
    }


    public void setOnChoiceClickListen(OnChoiceClickListen mOnChoiceClickListen) {

        this.mOnChoiceClickListen = mOnChoiceClickListen;
    }
    public void notifyAdapter(int position) {
        num = position;
        TagAdapter.this.notifyDataSetChanged();
    }
}
