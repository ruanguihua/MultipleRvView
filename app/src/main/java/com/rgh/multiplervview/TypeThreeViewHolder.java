package com.rgh.multiplervview;

import android.graphics.Color;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by RGH on 2017/10/21.
 */

public class TypeThreeViewHolder extends TypeAbstractViewHolder {

    public ImageView mIvAvatar;
    public ImageView mIvcontent;
    public TextView name;
    public TextView content;

    public TypeThreeViewHolder(View itemView) {
        super(itemView);
        mIvAvatar = itemView.findViewById(R.id.avatar);
        mIvcontent = itemView.findViewById(R.id.iv_content);
        name = itemView.findViewById(R.id.name);
        content = itemView.findViewById(R.id.content);
        itemView.setBackgroundColor(Color.BLUE);
    }

    @Override
    public void bindHolder(DataModel dataModel) {
        mIvAvatar.setBackgroundResource(dataModel.avatarColor);
        mIvcontent.setBackgroundResource(dataModel.contentColor);
        name.setText("布局三"+dataModel.name);
        content.setText("布局三"+dataModel.content);
    }
}
