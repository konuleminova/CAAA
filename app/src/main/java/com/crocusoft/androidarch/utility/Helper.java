package com.crocusoft.androidarch.utility;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by Asus on 2/16/2018.
 */

public class Helper {

    public static void showMessage(Context context, String showMessage) {
        Toast.makeText(context, showMessage, Toast.LENGTH_LONG).show();
    }

}
