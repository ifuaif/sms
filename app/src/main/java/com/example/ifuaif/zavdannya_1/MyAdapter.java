package com.example.ifuaif.zavdannya_1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by IFuaIF on 27.05.2016.
 */
public class MyAdapter extends BaseAdapter {

    private ArrayList<Item> listData;
    private LayoutInflater layoutInflater;

    public  MyAdapter(Context context, ArrayList<Item> listData){
        layoutInflater = LayoutInflater.from(context);
        this.listData = listData;
    }

    @Override
    public int getCount() {
        return listData.size();
    }

    @Override
    public Object getItem(int position) {
        return listData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null){
            convertView = layoutInflater.inflate(R.layout.item,null);
            holder = new ViewHolder();
            holder.tViewTasks = (TextView)convertView.findViewById(R.id.tView_task);
            holder.tViewComments = (TextView)convertView.findViewById(R.id.tView_comment);
            convertView.setTag(holder);
        } else{
            holder = (ViewHolder)convertView.getTag();
        }

        holder.tViewComments.setText(listData.get(position).getComments());
        holder.tViewTasks.setText(listData.get(position).getTasks());
        return convertView;
    }


   class  ViewHolder{
       TextView tViewTasks;
       TextView tViewComments;
   }

}