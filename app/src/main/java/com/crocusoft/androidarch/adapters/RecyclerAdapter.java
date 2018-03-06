package com.crocusoft.androidarch.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.crocusoft.androidarch.R;
import com.crocusoft.androidarch.model.User;

import java.util.List;

/**
 * Created by Asus on 2/19/2018.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ItemViewHolder> {

    private List<User> userList;
    private Context context;

    public RecyclerAdapter(List<User> userList, Context context) {
        this.userList = userList;
        this.context = context;
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.items_recycleview_layout, parent, false);
        ItemViewHolder holder = new ItemViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(final ItemViewHolder holder, final int position) {
        holder.idTextView.setText(userList.get(position).getUserId());
        holder.nameTextView.setText(userList.get(position).getName());
        holder.surnameTextView.setText(userList.get(position).getSurname());
        holder.imageView.setImageResource(userList.get(position).getImage());
    }


    @Override
    public int getItemCount() {
        return userList.size();
    }


    public class ItemViewHolder extends RecyclerView.ViewHolder {
        private TextView idTextView, nameTextView, surnameTextView;
        private ImageView imageView;

        public ItemViewHolder(View itemView) {
            super(itemView);
            idTextView = (TextView) itemView.findViewById(R.id.id_textview);
            nameTextView = (TextView) itemView.findViewById(R.id.name_textview);
            surnameTextView = (TextView) itemView.findViewById(R.id.surname_textview);
            imageView = (ImageView) itemView.findViewById(R.id.recycler_imageview);

        }
    }
}
