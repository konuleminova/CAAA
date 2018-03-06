package com.crocusoft.androidarch.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.crocusoft.androidarch.R;
import com.crocusoft.androidarch.model.User;

import java.util.List;

/**
 * Created by Asus on 2/22/2018.
 */

public class ListAdapter extends BaseAdapter {
    private Context context;
    private List<User> userList;

    public ListAdapter(Context context, List<User> userList) {
        this.context = context;
        this.userList = userList;
    }

    @Override
    public int getCount() {

        return userList.size();
    }

    @Override
    public Object getItem(int i) {
        return userList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        CustomViewHolder viewHolder;
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.items_listview_layout, viewGroup, false);
            viewHolder = new CustomViewHolder(view);
            view.setTag(viewHolder);
        } else {
            viewHolder = (CustomViewHolder) view.getTag();
        }
        viewHolder.userId.setText(userList.get(i).getUserId());
        viewHolder.itemImage.setImageResource(userList.get(i).getImage());
        viewHolder.itemName.setText(userList.get(i).getName());
        viewHolder.itemContent.setText(userList.get(i).getSurname());
        return view;
    }

    private class CustomViewHolder {
        private TextView userId;
        private TextView itemName;
        private TextView itemContent;
        private ImageView itemImage;

        public CustomViewHolder(View view) {
            userId = (TextView) view.findViewById(R.id.user_id);
            itemName = (TextView) view.findViewById(R.id.text_list_view);
            itemContent = (TextView) view.findViewById(R.id.listview_content);
            itemImage = (ImageView) view.findViewById(R.id.image_list_view);
        }
    }
}
