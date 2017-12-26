package com.rgh.multiplervview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ListView lv_main;
    private String[] title = {"线性布局实现多布局",  "网格布局多布局", "流式布局"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv_main = (ListView) findViewById(R.id.lv);
        Madapter madapter = new Madapter();
        lv_main.setAdapter(madapter);


        lvClick();
    }


    private void lvClick() {

        lv_main.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                switch (i) {
                    case 0:
                        startOtherActivity(LinearLayoutActivity.class);
                        break;
                    case 1:
                        startOtherActivity(GridActivity.class);
                        break;
                    case 2:
                        startOtherActivity(FlowLayoutActivity.class);
                        break;



                }
            }
        });
    }

    Intent intent;

    public void startOtherActivity(Class mClass) {
        intent = new Intent(MainActivity.this, mClass);
        startActivity(intent);
    }
    class Madapter extends BaseAdapter {

        @Override
        public int getCount() {
            return title.length;
        }

        @Override
        public Object getItem(int i) {
            return title[i];
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View convertView, ViewGroup viewGroup) {
            View view = convertView;
            ViewHolder holder;
            if (view == null) {
                view = new TextView(MainActivity.this);


                holder = new ViewHolder();
                holder.tv_name = (TextView) view;
                ViewGroup.LayoutParams lp = new ViewGroup.LayoutParams( RecyclerView.LayoutParams.MATCH_PARENT,100);

                ((TextView) view).setGravity(Gravity.CENTER);
             //   lp.height=20;//lp.height=LayoutParams.WRAP_CONTENT;
                view.setLayoutParams(lp);
                view.setTag(holder);
            } else {
                holder = (ViewHolder) view.getTag();
            }


            holder.tv_name.setText(title[i]);

            return view;

        }

        class ViewHolder {
            TextView tv_name;
            //ImageView icon1;
        }}
}
