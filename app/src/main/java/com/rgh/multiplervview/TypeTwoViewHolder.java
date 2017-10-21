package com.rgh.multiplervview;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by RGH on 2017/10/21.
 */

public class TypeTwoViewHolder extends TypeAbstractViewHolder {

    public ImageView mIvAvatar;
    public TextView name;
    public TextView content;

    public TypeTwoViewHolder(View itemView) {
        super(itemView);
        mIvAvatar = itemView.findViewById(R.id.avatar);
        name = itemView.findViewById(R.id.name);
        content = itemView.findViewById(R.id.content);
        itemView.setBackgroundColor(Color.GREEN);

    }

    @Override
    public void bindHolder(DataModel dataModel) {
        mIvAvatar.setBackgroundResource(dataModel.avatarColor);
        name.setText("布局二"+dataModel.name);
        content.setText("布局二"+dataModel.content);
    }
}
