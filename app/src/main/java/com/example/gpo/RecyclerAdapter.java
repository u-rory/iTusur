package com.example.gpo;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.gpo.Data.DataModel;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {
    private ArrayList<DataModel> dataSet;


    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView textViewName;
        TextView textViewVersion;
        TextView textViewName2;
        ImageView imagesnews;

        public MyViewHolder(View itemView) {
            super(itemView);
            this.textViewName = (TextView) itemView.findViewById(R.id.textViewName);
            this.textViewVersion = (TextView) itemView.findViewById(R.id.textViewVersion);
            this.textViewName2 = (TextView) itemView.findViewById(R.id.textViewGLNAME);
            this.imagesnews = (ImageView) itemView.findViewById(R.id.Imageviewnews);
        }
    }
    public RecyclerAdapter(ArrayList<DataModel> data) {
        this.dataSet = data;
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cards_layout, parent, false);
        view.setOnClickListener(podnews.myOnClickListener);//
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }
    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int listPosition) {

        TextView textViewName = holder.textViewName;
        TextView textViewVersion = holder.textViewVersion;
        TextView textViewName2 = holder.textViewName2;
        ImageView imagesnews = holder.imagesnews;
        textViewName.setText(dataSet.get(listPosition).getName());
        textViewVersion.setText(dataSet.get(listPosition).getVersion());
        textViewName2.setText(dataSet.get(listPosition).getName2());
        Picasso.with(holder.imagesnews.getContext()).load(dataSet.get(listPosition).getImages()).into(imagesnews);

    }
    @Override
    public int getItemCount() {
        return dataSet.size();
    }
}