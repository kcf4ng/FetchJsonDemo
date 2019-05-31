package com.example.fetchjsondemo;

import android.os.AsyncTask;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class FetchDataAct extends AsyncTask<Void,Void,Void> {
    String strKey ="MyLog";
    String strJson;
    String strDataParse, strSingleParse;
    Integer intTotal;



    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected Void doInBackground(Void... voids) {
        try {
            //網址轉碼
            URL url = new URL("https://api.myjson.com/bins/a2j5r");
            //取得連線
            URLConnection conn = url.openConnection();
            //取得串流
            InputStream streamIn = conn.getInputStream();
            //準備開始解碼，首先，把剛剛的串流讀進來，製作一個串流讀取器(BufferReader)
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(streamIn));
            //做一個StringBuilder,接著不斷地去讀取串流，讀到他是NULL為止，在這之前則把每一行 append  到 StringBuilder 裡面
            StringBuilder html  = new StringBuilder();

            String line ;

            while ( (line = bufferedReader.readLine()) != null){
                html.append(line);
            }

            strJson = html.toString();

            JSONObject jsonObject = new JSONObject(strJson);

//          JSONArray ja = (JSONArray) jsonObject.opt("data");
            JSONArray ja  = jsonObject.getJSONArray("data");

           for(int i = 0 ; i<ja.length();i++){
                JSONObject dataJo = ja.getJSONObject(i);
                strDataParse = strDataParse+ dataJo.getString("mom_name");
                Log.d(strKey,strDataParse);
            }

//           intTotal= (Integer) jsonObject.opt("total");
//            strDataParse = intTotal.toString();





        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }


        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
//        MainActivity.lblJson.setText(this.strJson);
        MainActivity.lblJson.setText(strDataParse);
    }
}
