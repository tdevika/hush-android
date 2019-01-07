//package com.xpns;
//
//import android.support.annotation.NonNull;
//import android.util.Log;
//
//import com.squareup.okhttp.OkHttpClient;
//import com.squareup.okhttp.Request;
//import com.squareup.okhttp.Response;
//
//import org.json.JSONException;
//import org.json.JSONObject;
//
//import java.io.IOException;
//
//
//public class Controller {
//
//
//    public static final String TAG = "TAG";
//
//    public static final String WAURL = "https://script.google.com/macros/s/AKfycbx8ZOc919VWx5FXYZgVcZ71x7I5qo4mA_CISnhS/exec?";
//
//    private static Response response;
//
//    public static JSONObject readAllData() {
//        try {
//            OkHttpClient client = new OkHttpClient();
//            Request request = new Request.Builder()
//                    .url(WAURL + "action=readAll")
//                    .build();
//            response = client.newCall(request).execute();
//            return new JSONObject(response.body().string());
//        } catch (@NonNull IOException | JSONException e) {
//            Log.e(TAG, "" + e.getLocalizedMessage());
//        }
//
//
//        return null;
//    }
//
//
//    public static JSONObject insertData(String itemName, String brand) {
//        try {
//            OkHttpClient client = new OkHttpClient();
//            Request request = new Request.Builder()
//                    .url(WAURL + "action=saveExpns&itemName=" + itemName + "&brand=" + brand)
//                    .build();
//            response = client.newCall(request).execute();
//            Log.e(TAG, "response from gs" + response.body().string());
//            return new JSONObject(response.body().string());
//
//
//        } catch (@NonNull IOException | JSONException e) {
//            Log.e(TAG, "recieving null " + e.getLocalizedMessage());
//        }
//        return null;
//    }
//
//    public static JSONObject updateData(String id, String name) {
//        try {
//            OkHttpClient client = new OkHttpClient();
//            Request request = new Request.Builder()
//                    .url(WAURL + "action=update&itemName=" + id + "&brand=" + name)
//                    .build();
//            response = client.newCall(request).execute();
//            //    Log.e(TAG,"response from gs"+response.body().string());
//            return new JSONObject(response.body().string());
//
//
//        } catch (@NonNull IOException | JSONException e) {
//            Log.e(TAG, "recieving null " + e.getLocalizedMessage());
//        }
//        return null;
//    }
//
//    public static JSONObject readData(String id) {
//        try {
//            OkHttpClient client = new OkHttpClient();
//            Request request = new Request.Builder()
//                    .url(WAURL + "action=read&itemName=" + id)
//                    .build();
//            response = client.newCall(request).execute();
//            // Log.e(TAG,"response from gs"+response.body().string());
//            return new JSONObject(response.body().string());
//
//
//        } catch (@NonNull IOException | JSONException e) {
//            Log.e(TAG, "recieving null " + e.getLocalizedMessage());
//        }
//        return null;
//    }
//
//    public static JSONObject deleteData(String id) {
//        try {
//            OkHttpClient client = new OkHttpClient();
//            Request request = new Request.Builder()
//                    .url(WAURL + "action=delete&itemName=" + id)
//                    .build();
//            response = client.newCall(request).execute();
//            // Log.e(TAG,"response from gs"+response.body().string());
//            return new JSONObject(response.body().string());
//
//
//        } catch (@NonNull IOException | JSONException e) {
//            Log.e(TAG, "recieving null " + e.getLocalizedMessage());
//        }
//        return null;
//    }
//
//
//}