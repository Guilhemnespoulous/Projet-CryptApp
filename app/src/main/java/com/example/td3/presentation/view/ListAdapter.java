package com.example.td3.presentation.view;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.td3.R;
import com.example.td3.presentation.model.Coin;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {
    private List<Coin> values;
    private OnItemClickListener listener;
    private Context context;
    public interface OnItemClickListener{
        void onItemClick(Coin item);
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        TextView txtHeader;
        TextView txtFooter;
        ImageView rowIcon;
        View layout;

        ViewHolder(View v) {
            super(v);
            layout = v;
            txtHeader = v.findViewById(R.id.firstLine);
            txtFooter = v.findViewById(R.id.secondLine);
            rowIcon = v.findViewById(R.id.icon);
        }
    }

    public void add(int position, Coin item) {
        values.add(position, item);
        notifyItemInserted(position);
    }

    private void remove(int position) {
        values.remove(position);
        notifyItemRemoved(position);
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public ListAdapter(List<Coin> myDataset, OnItemClickListener listener, Context context) {
        this.values = myDataset;
        this.listener = listener;
        this.context = context;
    }


    // Create new views (invoked by the layout manager)
    @Override
    public ListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {
        // create a new view
        LayoutInflater inflater = LayoutInflater.from(
                parent.getContext());
        View v =
                inflater.inflate(R.layout.row_layout, parent, false);
        // set the view's size, margins, paddings and layout parameters
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

        final Coin currentCoin = values.get(position);
        holder.txtHeader.setText(currentCoin.getName());
        Picasso.with(context).load("https://raw.githubusercontent.com/spothq/cryptocurrency-icons/master/128/color/" + currentCoin.getSymbol().toLowerCase() + ".png").into(holder.rowIcon);
      //  holder.txtHeader.setOnClickListener(new View.OnClickListener() {
      //      @Override
      //      public void onClick(View v) {
      //          remove(position);
      //      }
      //  });

        holder.txtFooter.setText(currentCoin.getSymbol());
        holder.itemView.setOnClickListener(new View.OnClickListener(){
            @Override public void onClick(View v){
                listener.onItemClick(currentCoin);
            }
        });
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return values.size();
    }

}
