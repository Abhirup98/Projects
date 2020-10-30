package com.example.user.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import java.util.ArrayList;
public class GridAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<PicsBeen> all;
    LayoutInflater inflater;
    public GridAdapter(Context context,ArrayList<PicsBeen>all){
        this.context=context;
        this.all=all;
        inflater=(LayoutInflater)this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return all.size();
    }
    @Override
    public Object getItem(int position) {
        return all.get(position);
    }
    @Override
    public long getItemId(int position) {
        return position;
    }
    @Override
    public View getView(int position, View convertView,ViewGroup parent) {
        if ((convertView == null)){
            convertView= inflater.inflate(R.layout.activity_custom_grid,null);
        }
        ImageView image=(ImageView)convertView.findViewById(R.id.photo);
        PicsBeen picb=all.get(position);
        image.setImageDrawable(picb.get_pic());
        return convertView;
    }
}
