package com.example.when;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> implements Filterable {

    private Context context;
    private ArrayList<ItemModel> mData = null;

    ArrayList<ItemModel> filteredList;

    public MyAdapter(Context context, ArrayList<ItemModel> mData) {
        this.context = context;
        this.mData = mData;

        filteredList = mData;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        MyAdapter.MyViewHolder myViewHolder = new MyAdapter.MyViewHolder(view);
        return myViewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.icon.setImageResource(filteredList.get(position).getIcon());
        holder.name.setText(filteredList.get(position).getKor_name());

    }

    @Override
    public int getItemCount() {
        return filteredList.size();
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                String charString = constraint.toString();
                if(charString.isEmpty()) {
                    filteredList = mData;
                } else {
                    ArrayList<ItemModel> filteringList = new ArrayList<>();
                    for(ItemModel name : mData) {
                        if(name.getKor_name().toLowerCase().contains(charString.toLowerCase()) || SoundSearcher.matchString(name.getKor_name(), charString)) {
                            filteringList.add(name);
                        }
                    }
                    filteredList = filteringList;
                }
                FilterResults filterResults = new FilterResults();
                filterResults.values = filteredList;
                filterResults.count = filteredList.size();
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                filteredList = (ArrayList<ItemModel>)results.values;

                notifyDataSetChanged();
            }
        };
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView icon;
        TextView name;

        public MyViewHolder(@NonNull final View itemView) {
            super(itemView);

            icon = (ImageView)itemView.findViewById(R.id.iv_image);
            name = (TextView)itemView.findViewById(R.id.tv_name);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = getAdapterPosition();
                    if(pos != RecyclerView.NO_POSITION) {
                        Intent resultIntent = new Intent();

                        resultIntent.putExtra("srcId", filteredList.get(pos).getAbility());
                        resultIntent.putExtra("time_1", filteredList.get(pos).getTime_1());
                        resultIntent.putExtra("time_2", filteredList.get(pos).getTime_2());
                        resultIntent.putExtra("time_3", filteredList.get(pos).getTime_3());

                        ((SellectActivity)context).setResult(((SellectActivity)context).RESULT_OK, resultIntent);
                        ((SellectActivity)context).finish();
                    }
                }
            });
        }
    }
}
