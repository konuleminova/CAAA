package com.crocusoft.androidarch.asynctask;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import com.crocusoft.androidarch.activities.LoginActivity;
import com.crocusoft.androidarch.activities.MainActivity;

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

/**
 * Created by Asus on 2/27/2018.
 */

public class AsyncTaskUtil extends AsyncTask<Url, String, String> {
    BufferedReader reader;
    String message;
    Context context;

    public AsyncTaskUtil(Context context) {
        this.context = context;
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
            httpURLConnection.setRequestProperty("Accept","application/json");
            httpURLConnection.setDoInput(true);
            httpURLConnection.setDoInput(true);
            JSONObject jsonObject=new JSONObject();
            jsonObject.put("Username","ceyhun-auditor");
            jsonObject.put("Password","12341234");
            jsonObject.put("ApiKey","987654");
            OutputStream outputStream=httpURLConnection.getOutputStream();
            BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(outputStream,"UTF-8"));
            bufferedWriter.write(jsonObject.toString());
            bufferedWriter.flush();
            bufferedWriter.close();
            outputStream.close();
            //httpURLConnection.connect();
            int responseCode=httpURLConnection.getResponseCode();
            if(responseCode==HttpURLConnection.HTTP_OK) {
                Log.d("fetch","url");
            }
            InputStream stream = httpURLConnection.getInputStream();
            reader = new BufferedReader(new InputStreamReader(stream));
            StringBuffer stringBuffer = new StringBuffer();
            String line = "";
            while ((line = reader.readLine()) != null) {

                stringBuffer.append(line);
            }
            JSONObject jsonObject1=new JSONObject(stringBuffer.toString());
             message=jsonObject1.getString("MessageId");

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
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        if(message.equals("1000")){
           Log.d("fetch","htttp");

        }
    }
}
