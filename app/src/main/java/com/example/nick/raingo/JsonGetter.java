package com.example.nick.raingo;

import android.os.AsyncTask;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;

/**
 * Created by nitta_000 on 4/23/2016.
 */
public class JsonGetter extends AsyncTask<String, Void, JSONObject>{

    JSONObject json = new JSONObject();

    private static String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
            sb.append((char) cp);
        }
        return sb.toString();
    }

    @Override
    protected JSONObject doInBackground(String... url){
        try {
            InputStream is = new URL(url[0]).openStream();
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            String jsonText = readAll(rd);
            jsonText = jsonText.substring(1, jsonText.length() - 1);
            JSONObject json = new JSONObject(jsonText);
            is.close();
            return json;
        } catch(JSONException e) {
            throw new NoSuchElementException("JsonGETTER's goddamn JSONException: " + e.getMessage());
        } catch(IOException e){
            throw new NoSuchElementException("JsonGETTER's fucking IOException: " + e.getMessage());
        }
    }

    JsonGetter() {

    }
}
