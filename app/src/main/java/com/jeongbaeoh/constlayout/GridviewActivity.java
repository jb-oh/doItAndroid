package com.jeongbaeoh.constlayout;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;

public class GridviewActivity extends AppCompatActivity {

    SingerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gridview);

        GridView gridView = (GridView) findViewById(R.id.gridView);

        adapter = new SingerAdapter();
        adapter.addItem(new SingerItem("U2", "010-1000-2000", R.drawable.icon01));
        adapter.addItem(new SingerItem("Coldplay", "010-2000-3000", R.drawable.icon02));
        adapter.addItem(new SingerItem("The Beatles", "010-3000-4000", R.drawable.icon03));
        adapter.addItem(new SingerItem("Adele", "010-4000-5000", R.drawable.icon04));
        adapter.addItem(new SingerItem("Bruno Mars", "010-5000-6000", R.drawable.icon05));
        gridView.setAdapter(adapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                SingerItem item = (SingerItem) adapter.getItem(i);
                Toast.makeText(getApplicationContext(), "Selected: "+item.getName(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    class SingerAdapter extends BaseAdapter {

        ArrayList<SingerItem> items = new ArrayList<>();

        @Override
        public int getCount() {
            return items.size();
        }

        public void addItem(SingerItem item) {
            items.add(item);
        }

        @Override
        public Object getItem(int i) {
            return items.get(i);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            SingerItemView listViewView = null;

            if(listViewView == null) {
                listViewView = new SingerItemView(getApplicationContext());
            } else {
                listViewView = (SingerItemView) view;
            }

            SingerItem item = items.get(i);
            listViewView.setName(item.getName());
            listViewView.setMobile(item.getMobile());
            listViewView.setImage(item.getResId());
            return listViewView;
        }
    }
}
