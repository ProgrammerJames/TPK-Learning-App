package com.team.titans.tpk_learning_app;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class WebRequest implements Runnable {

    private String response = "", address = "";

    public WebRequest(String address) {
        this.address = address;
    }

    @Override
    public void run() {
        try {
            URL url = new URL(address);
            HttpURLConnection connect = (HttpURLConnection) url.openConnection();
            try {
                InputStream in = new BufferedInputStream(connect.getInputStream());
                response = convertStreamToString(in);
            } finally {
                connect.disconnect();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String convertStreamToString(InputStream is) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();

        String line = null;
        try {
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return sb.toString();
    }

    public String getResponse() {
        return response;
    }
}
