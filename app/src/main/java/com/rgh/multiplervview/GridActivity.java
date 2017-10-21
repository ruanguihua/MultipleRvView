package com.rgh.multiplervview;

import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class GridActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    int colors[] = {android.R.color.holo_red_light, android.R.color.holo_orange_light, android.R.color.holo_blue_light};
    private DemoAdaper mDemoAdaper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = (RecyclerView) findViewById(R.id.rv);

        final GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);


        //返回占用表格数
        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                int type = mRecyclerView.getAdapter().getItemViewType(position);
                if (type == DataModel.TYPE_THREE) {
                    return gridLayoutManager.getSpanCount();
                } else {
                    return 1;
                }


            }
        });

        mRecyclerView.setLayoutManager(gridLayoutManager);
        mDemoAdaper = new DemoAdaper(this);
        mRecyclerView.setAdapter(mDemoAdaper);
        mRecyclerView.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
                super.getItemOffsets(outRect, view, parent, state);

                GridLayoutManager.LayoutParams params = (GridLayoutManager.LayoutParams) view.getLayoutParams();
                int spanSize = params.getSpanSize();
                int spanIndex = params.getSpanIndex();
                outRect.top = 20;
                if (spanSize != gridLayoutManager.getSpanCount()) {
                    if (spanIndex == 1) {
                        outRect.left = 10;
                    } else {
                      //  outRect.right = 10;
                    }

                }
            }
        });

        initData();
    }

    private void initData() {
        List<DataModel> list = new ArrayList<>();

        int type;

        for (int i = 0; i < 30; i++) {

            if (i < 5 || (i > 15 && i < 20)) {
                type = 1;
            } else if (i < 10 || i > 26) {
                type = 2;
            } else {
                type = 3;
            }


            DataModel data = new DataModel();
            data.avatarColor = colors[type - 1];
            data.type = type;
            data.name = "小" + i;
            data.content = "content" + i;
            data.contentColor = colors[(type + 1) % 3];
            list.add(data);

        }

        mDemoAdaper.addList(list);
        mDemoAdaper.notifyDataSetChanged();
    }
}
