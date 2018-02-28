package com.crocusoft.androidarch.listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.crocusoft.androidarch.R;

import java.util.List;

/**
 * Created by Asus on 2/22/2018.
 */

public class ListAdapter extends BaseAdapter {
    private Context context;
    private List<ListObjects> listObjectsList;

    public ListAdapter(Context context, List<ListObjects> listObjectsList) {
        this.context = context;
        this.listObjectsList = listObjectsList;
    }

    @Override
    public int getCount() {

        return listObjectsList.size();
    }

    @Override
    public Object getItem(int i) {
        return listObjectsList.get(i);
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
        viewHolder.itemImage.setImageResource(listObjectsList.get(i).getItemImage());
        viewHolder.itemName.setText(listObjectsList.get(i).getItemName());
        viewHolder.itemContent.setText(listObjectsList.get(i).getItemContent());
        return view;
    }

    private class CustomViewHolder {
        private TextView itemName;
        private TextView itemContent;
        private ImageView itemImage;

        public CustomViewHolder(View view) {
            itemName = (TextView) view.findViewById(R.id.text_list_view);
            itemContent = (TextView) view.findViewById(R.id.listview_content);
            itemImage = (ImageView) view.findViewById(R.id.image_list_view);
        }
    }
}
