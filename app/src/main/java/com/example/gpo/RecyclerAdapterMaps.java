package com.example.gpo;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.gpo.Data.DataMaps;

import java.util.ArrayList;

public class RecyclerAdapterMaps extends RecyclerView.Adapter<RecyclerAdapterMaps.MyViewHolder2> {
    private ArrayList<DataMaps> dataSet;

    public static class MyViewHolder2 extends RecyclerView.ViewHolder {

        TextView textViewName;
        TextView textViewVersion;
        ImageView imageviewa;

        public MyViewHolder2(View itemView) {
            super(itemView);
            this.textViewName = (TextView) itemView.findViewById(R.id.textViewNamemaps);
            this.textViewVersion = (TextView) itemView.findViewById(R.id.textViewmaps);
            this.imageviewa = (ImageView) itemView.findViewById(R.id.imageViewmaps);
        }
    }
    public RecyclerAdapterMaps(ArrayList<DataMaps> data) {
        this.dataSet = data;
    }
    @Override
    public MyViewHolder2 onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cards_layoutmaps, parent, false);
        view.setOnClickListener(Maps2.myOnClickListener);//
        MyViewHolder2 myViewHolder = new MyViewHolder2(view);
        return myViewHolder;
    }
    @Override
    public void onBindViewHolder(final MyViewHolder2 holder, final int listPosition) {

        TextView textViewName = holder.textViewName;
        TextView textViewVersion = holder.textViewVersion;
        ImageView imageviewa = holder.imageviewa;
        textViewName.setText(dataSet.get(listPosition).getName());
        textViewVersion.setText(dataSet.get(listPosition).getOpisanie());
        imageviewa.setImageResource(dataSet.get(listPosition).getPhotoId());
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }
}