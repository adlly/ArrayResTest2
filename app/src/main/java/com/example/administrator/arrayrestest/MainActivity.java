package com.example.administrator.arrayrestest;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    String[] texts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        texts = getResources().getStringArray(R.array.string_arr);
        BaseAdapter ba = new BaseAdapter() {
            @Override
            public int getCount() {
                return texts.length;
            }

            @Override
            public Object getItem(int position) {
                return texts[position];
            }

            @Override
            public long getItemId(int position) {
                return position;
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                TextView text = new TextView(MainActivity.this);
                Resources res = MainActivity.this.getResources();
                text.setWidth((int) res.getDimension(R.dimen.cell_width));
                text.setHeight((int) res.getDimension(R.dimen.cell_height));
                text.setText(texts[position]);
                TypedArray icons = res.obtainTypedArray(R.array.plain_arr);
                text.setBackgroundDrawable(icons.getDrawable(position));
                text.setTextSize(20);
                return  text;
            }
        };
        GridView gridView = (GridView)findViewById(R.id.grid01);
        gridView.setAdapter(ba);

    }
}
