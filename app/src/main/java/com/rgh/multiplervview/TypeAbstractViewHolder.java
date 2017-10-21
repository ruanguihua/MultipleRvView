package com.rgh.multiplervview;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by RGH on 2017/10/21.
 */

public abstract class TypeAbstractViewHolder extends RecyclerView.ViewHolder {
    public TypeAbstractViewHolder(View itemView) {
        super(itemView);
    }
    public abstract void bindHolder(DataModel dataModel);
}
