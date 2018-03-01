package com.crocusoft.androidarch.asynctask;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.crocusoft.androidarch.R;
import com.crocusoft.androidarch.activities.LoginActivity;
import com.crocusoft.androidarch.activities.MainActivity;
import com.crocusoft.androidarch.utilities.SharedPreferenceUtils;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
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

import static com.crocusoft.androidarch.utilities.Constants.DEFAULT_VALUE;
import static com.crocusoft.androidarch.utilities.Constants.KEY_ID;

/**
 * Created by Asus on 2/27/2018.
 */

public class AsyncTaskUtil extends AsyncTask<Url, String, String> {
    private BufferedReader reader;
    private String message;
    private Context context;
    private AlertDialog alertDialog;
    private String username, password;
    private SharedPreferenceUtils sharedPreferenceUtils;

    public AsyncTaskUtil(Context context, String username, String password) {
        this.context = context;
        this.username = username;
        this.password = password;
        alertDialog = new AlertDialog.Builder(context).create();
        alertDialog.setMessage("Please Wait ... ");
        alertDialog.setIcon(R.drawable.backbutton);
        sharedPreferenceUtils = new SharedPreferenceUtils(context);
        //LoginActivity activity=(LoginActivity)context;
    }

    @Override
    protected String doInBackground(Url... urls) {
        HttpURLConnection httpURLConnection = null;

        try {
            URL url = new URL("http://94.130.226.167/rsabackend/api/user/login");
            httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setConnectTimeout(15000);
            httpURLConnection.setReadTimeout(15000);
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setRequestProperty("Content-Type", "application/json");
            httpURLConnection.setRequestProperty("Accept", "application/json");
            httpURLConnection.setDoInput(true);
            httpURLConnection.setDoInput(true);
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("Username", username);
            jsonObject.put("Password", password);
            jsonObject.put("ApiKey", "987654");
            OutputStream outputStream = httpURLConnection.getOutputStream();
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
            bufferedWriter.write(jsonObject.toString());
            bufferedWriter.flush();
            bufferedWriter.close();
            outputStream.close();
            //httpURLConnection.connect();
            int responseCode = httpURLConnection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                Log.d("fetch", "url");
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

        return null;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        alertDialog.show();
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        if (message.equals("1000")) {
            Log.d("fetch", "successful");
            Intent intent = new Intent(context, MainActivity.class);
            context.startActivity(intent);
            ((LoginActivity) context).finish();
        } else {
            Toast.makeText(context, "Your username or password is incorrect", Toast.LENGTH_LONG).show();
        }
        alertDialog.dismiss();
    }
}
