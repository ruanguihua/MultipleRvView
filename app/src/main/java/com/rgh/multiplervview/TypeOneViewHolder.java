package com.rgh.multiplervview;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by RGH on 2017/10/21.
 */

public class TypeOneViewHolder extends TypeAbstractViewHolder {

    public ImageView mIvAvatar;
    public TextView name;

    public TypeOneViewHolder(View itemView) {
        super(itemView);
        mIvAvatar = itemView.findViewById(R.id.avatar);
        name = itemView.findViewById(R.id.name);
        itemView.setBackgroundColor(Color.BLACK);

    }

    @Override
    public void bindHolder(DataModel dataModel) {
        mIvAvatar.setBackgroundResource(dataModel.avatarColor);
        name.setText("布局一" + dataModel.name);
    }
}
