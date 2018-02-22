package com.crocusoft.androidarch.utilities;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by Asus on 2/16/2018.
 */

public class Helper {
   public static   void setErrorMessage(Context context ,String errorMessage){
        Toast.makeText(context,errorMessage,Toast.LENGTH_LONG).show();
    }
}
