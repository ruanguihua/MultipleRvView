package com.rgh.multiplervview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class FlowLayoutActivity extends AppCompatActivity {

    RecyclerView mRv;

    TagAdapter mAdapter;
    private List<ScopeTypeBean> mModelList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flow_layout);

        mRv = (RecyclerView) findViewById(R.id.rv);
        initRv();
    }

    private void initRv() {
        final GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 6);

        //返回列数
        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                int type = mRv.getAdapter().getItemViewType(position);
                if (type == 1) {
                    Log.i("getSpanSize", "position: " + position);

                    return 3;
                } else {
                    Log.i("getSpanSize", "position222222: " + position);
                    return 2;
                }
            }
        });
        mRv.setLayoutManager(gridLayoutManager);
        mAdapter = new TagAdapter(mModelList);

        mRv.setAdapter(mAdapter);

        initData();
    }


    int typeOne = 0;

    private void initData() {
        // List<ScopeTypeBean> list = new ArrayList<>();

        int type;

        for (int i = 0; i < 10; i++) {


            if (i == typeOne || i == typeOne + 1) {
                type = 1;
                typeOne += 5;
            } else {
                type = 2;
            }

            ScopeTypeBean data = new ScopeTypeBean();
            //    data.avatarColor = colors[type - 1];
            data.type = type;
            data.name = "蔬菜水果"+i;
            data.content = "content" + i;
            //    data.contentColor = colors[(type + 1) % 3];
            mModelList.add(data);

        }


        mAdapter.notifyDataSetChanged();
    }
}
