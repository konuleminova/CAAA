package com.crocusoft.androidarch.utility;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by Asus on 2/27/2018.
 */

public class RecycleItemClcikListener implements RecyclerView.OnItemTouchListener {
    Context context;
    ItemClickListner listner;


    public interface ItemClickListner {
        void clickEvent(View v, int position);
    }

    GestureDetector gestureDetector;

    public RecycleItemClcikListener(Context context, ItemClickListner listner) {
        this.context = context;
        this.listner = listner;
        gestureDetector = new GestureDetector(context, new GestureDetector.OnGestureListener() {


            @Override
            public boolean onDown(MotionEvent motionEvent) {
                return false;
            }

            @Override
            public void onShowPress(MotionEvent motionEvent) {

            }

            @Override
            public boolean onSingleTapUp(MotionEvent motionEvent) {
                return true;
            }

            @Override
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
                return false;
            }

            @Override
            public void onLongPress(MotionEvent motionEvent) {

            }

            @Override
            public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
                return false;
            }
        });

    }

    @Override
    public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
        View childView = rv.findChildViewUnder(e.getX(), e.getY());
        if (childView != null && listner != null && gestureDetector.onTouchEvent(e)) {
            listner.clickEvent(childView, rv.getChildAdapterPosition(childView));
        }

        return false;
    }

    @Override
    public void onTouchEvent(RecyclerView rv, MotionEvent e) {

    }

    @Override
    public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

    }


}
