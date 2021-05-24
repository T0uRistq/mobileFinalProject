package com.example.finalproject;

import android.content.Context;
import android.util.Pair;
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
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;

public class Adapter extends RecyclerView.Adapter<Adapter.Holder> implements Filterable{

    ArrayList <String> data;
    ArrayList <Integer> img;
    ArrayList <String> dataAll;
    ArrayList <Integer> imgAll;
    Context ctx;

    public Adapter (Context c, ArrayList <String> s, ArrayList <Integer> i){
        ctx = c;
        data = s;
        img = i;
        dataAll = new ArrayList<>(data);
        imgAll = new ArrayList<>(img);
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(ctx);
        View view = inflater.inflate(R.layout.list_row, parent, false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        holder.textView.setText(data.get(position));
        holder.imageView.setImageResource(img.get(position));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    @Override
    public Filter getFilter() {
        return filter;
    }

    Filter filter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            ArrayList <Pair <String, Integer>> filteredPairs = new ArrayList<>();
            if (constraint.toString().isEmpty()){
                for (int i = 0; i < dataAll.size(); i++){
                    Pair <String, Integer> pair = new Pair<>(dataAll.get(i), imgAll.get(i));
                    filteredPairs.add(pair);
                }
            } else {
                for (int i = 0; i < dataAll.size(); i++){
                    if (dataAll.get(i).toLowerCase().contains(constraint.toString().toLowerCase())){
                        Pair <String, Integer> pair = new Pair<>(dataAll.get(i), imgAll.get(i));
                        filteredPairs.add(pair);
                    }
                }
            }

            FilterResults filterResults = new FilterResults();
            filterResults.values = filteredPairs;

            return filterResults;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            data.clear();
            img.clear();
            ArrayList <Pair <String, Integer>> pairs = new ArrayList<>();
            pairs.addAll((Collection<? extends Pair<String, Integer>>) results.values);
            for (Pair <String, Integer> entry : pairs){
                data.add(entry.first);
                img.add(entry.second);
            }
            notifyDataSetChanged();
        }
    };

    public class Holder extends RecyclerView.ViewHolder{
        TextView textView;
        ImageView imageView;
        public Holder(@NonNull View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.hero_name);
            imageView = (ImageView) itemView.findViewById(R.id.hero_img);
        }
    }
}
