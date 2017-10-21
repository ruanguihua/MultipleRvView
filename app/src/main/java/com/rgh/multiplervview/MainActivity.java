package com.rgh.multiplervview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    int colors[] = {android.R.color.holo_red_light, android.R.color.holo_orange_light, android.R.color.holo_blue_light};
    private DemoAdaper mDemoAdaper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = (RecyclerView) findViewById(R.id.rv);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mDemoAdaper = new DemoAdaper(this);
        mRecyclerView.setAdapter(mDemoAdaper);
        initData();
    }

    private void initData() {
        List<DataModel> list = new ArrayList<>();

        int type;

        for (int i = 0; i < 20; i++) {
            type = (int) ((Math.random() * 3) + 1);
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
