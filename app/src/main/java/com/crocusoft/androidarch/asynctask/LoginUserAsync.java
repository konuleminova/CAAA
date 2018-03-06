package com.crocusoft.androidarch.asynctask;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.widget.Toast;

import com.crocusoft.androidarch.R;
import com.crocusoft.androidarch.activities.LoginActivity;
import com.crocusoft.androidarch.activities.MainActivity;
import com.crocusoft.androidarch.model.User;
import com.crocusoft.androidarch.utility.Helper;
import com.crocusoft.androidarch.utility.SharedPreferenceUtils;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import retrofit2.http.Url;

import static com.crocusoft.androidarch.utility.Constants.API;
import static com.crocusoft.androidarch.utility.Constants.API_KEY;
import static com.crocusoft.androidarch.utility.Constants.PASSWORD;
import static com.crocusoft.androidarch.utility.Constants.USERNAME;

/**
 * Created by Asus on 2/27/2018.
 */

public class LoginUserAsync extends AsyncTask<Url, String, String> {
    private BufferedReader reader;
    private Context context;
    private AlertDialog alertDialog;
    private User user;
    private SharedPreferenceUtils sharedPreferenceUtils;

    public LoginUserAsync(Context context, User user) {
        this.context = context;
        this.user = user;
        setAlertDialog();
        sharedPreferenceUtils = new SharedPreferenceUtils(context);
        //LoginActivity activity=(LoginActivity)context;
    }

    private void setAlertDialog() {
        alertDialog = new AlertDialog.Builder(context).create();
        alertDialog.setMessage(context.getResources().getString(R.string.please_wait));
        alertDialog.setIcon(R.drawable.backbutton);

    }

    @Override
    protected String doInBackground(Url... urls) {
        HttpURLConnection httpURLConnection = null;
        String message = null;

        try {
            URL url = new URL(context.getResources().getString(R.string.url));
            httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setConnectTimeout(15000);
            httpURLConnection.setReadTimeout(15000);
            httpURLConnection.setRequestMethod(context.getResources().getString(R.string.post));
            httpURLConnection.setRequestProperty(context.getResources().getString(R.string.content_type), context.getResources().getString(R.string.app_json));
            httpURLConnection.setRequestProperty(context.getResources().getString(R.string.accept), context.getResources().getString(R.string.app_json));
            httpURLConnection.setDoInput(true);
            httpURLConnection.setDoInput(true);
            JSONObject jsonObject = new JSONObject();
            jsonObject.put(USERNAME, user.getUsername());//user.getPassword();
            jsonObject.put(PASSWORD, user.getPassword());
            jsonObject.put(API, API_KEY);
            OutputStream outputStream = httpURLConnection.getOutputStream();
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
            bufferedWriter.write(jsonObject.toString());
            bufferedWriter.flush();
            bufferedWriter.close();
            outputStream.close();
            //httpURLConnection.connect();
            int responseCode = httpURLConnection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
            }
            InputStream stream = httpURLConnection.getInputStream();
            reader = new BufferedReader(new InputStreamReader(stream));
            StringBuffer stringBuffer = new StringBuffer();
            String line = "";
            while ((line = reader.readLine()) != null) {

                stringBuffer.append(line);
            }
            JSONObject jsonObject1 = new JSONObject(stringBuffer.toString());
            message = jsonObject1.getString("MessageId");

        } catch (MalformedURLException e) {

            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();

        } catch (JSONException e) {
            e.printStackTrace();
        } finally {
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return message;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        alertDialog.show();
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        if (s.equals("1000")) {
            Log.d("fetch", "successful");
            Intent intent = new Intent(context, MainActivity.class);
            context.startActivity(intent);
            ((LoginActivity) context).finish();
        } else {
            Helper.showMessage(context, context.getResources().getString(R.string.error_login));
        }
        alertDialog.dismiss();
    }
}
