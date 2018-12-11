package com.example.gpo.Data;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.gpo.R;

import java.util.List;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {
     public LayoutInflater inflater;
    public  List<Phone> phones;
   public  DataAdapter(Context context, List<Phone> phones) {this.phones = phones;this.inflater = LayoutInflater.from(context);}
    @Override
    public DataAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.list_item_person, parent, false);
        return new ViewHolder(view);
    }
    @Override
    public void onBindViewHolder(DataAdapter.ViewHolder holder, int position) {
        Phone phone = phones.get(position);
        holder.timeView.setText(phone.getTime());
        holder.nameView.setText(phone.getName());
        holder.companyView.setText(phone.getCompany());
        holder. prepodView.setText(phone.getPrepodd());
        holder. audView.setText(phone.getAudd());
    }
    @Override
    public int getItemCount() {return phones.size();}
    public class ViewHolder extends RecyclerView.ViewHolder {
        final TextView nameView, companyView, prepodView, audView,timeView;
        ViewHolder(View view){
            super(view);
            nameView = (TextView) view.findViewById(R.id.name);
            companyView = (TextView) view.findViewById(R.id.company);
            prepodView = (TextView) view.findViewById(R.id.aud);
            audView = (TextView) view.findViewById(R.id.prepod);
            timeView = (TextView) view.findViewById(R.id.time);
        }
    }
}