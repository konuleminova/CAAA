package com.crocusoft.androidarch.recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.crocusoft.androidarch.R;

import java.util.List;

/**
 * Created by Asus on 2/19/2018.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ItemViewHolder>{

    private List<RecyclerObjects> recyclerObjectsList;
    private Context context;
    //OnItemClickListener onItemClickListener;

    public RecyclerAdapter(List<RecyclerObjects> recyclerObjectsList, Context context) {
        this.recyclerObjectsList = recyclerObjectsList;
        this.context = context;
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.items_recycleview_layout, parent, false);
        ItemViewHolder holder = new ItemViewHolder(view);
       // onItemClickListener.onItemClick(view,holder.getLayoutPosition());
        return holder;
    }

    @Override
    public void onBindViewHolder(final ItemViewHolder holder, final int position) {
        holder.recylerTextView.setText(recyclerObjectsList.get(position).getItemName());
        holder.recylerImageView.setImageResource(recyclerObjectsList.get(position).getItemImage());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("itemclick", recyclerObjectsList.get(position).toString());
               // onItemClickListener.onItemClick();
               // onItemClickListener.onItemClick(view,holder.getAdapterPosition());
            }
        });
    }


    @Override
    public int getItemCount() {
        return recyclerObjectsList.size();
    }



    public class ItemViewHolder extends RecyclerView.ViewHolder {
        private TextView recylerTextView;
        private ImageView recylerImageView;

        public ItemViewHolder(View itemView) {
            super(itemView);
            recylerTextView = (TextView) itemView.findViewById(R.id.recycler_textview);
            recylerImageView = (ImageView) itemView.findViewById(R.id.recycler_imageview);

        }
    }
}
