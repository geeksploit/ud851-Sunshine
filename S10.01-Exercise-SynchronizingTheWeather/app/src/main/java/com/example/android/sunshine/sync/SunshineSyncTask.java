package com.example.android.sunshine.sync;

import android.content.ContentValues;
import android.content.Context;

import com.example.android.sunshine.utilities.NetworkUtils;
import com.example.android.sunshine.utilities.OpenWeatherJsonUtils;

import org.json.JSONException;

import java.io.IOException;
import java.net.URL;

// COMPLETED (1) Create a class called SunshineSyncTask
class SunshineSyncTask {
    // COMPLETED (2) Within SunshineSyncTask, create a synchronized public static void method called syncWeather
    public static synchronized void syncWeather(Context context) {
        // COMPLETED (3) Within syncWeather, fetch new weather data
        URL weatherUrl = NetworkUtils.getUrl(context);
        try {
            String weatherResponse = NetworkUtils.getResponseFromHttpUrl(weatherUrl);
            ContentValues[] weatherValues =
                    OpenWeatherJsonUtils.getWeatherContentValuesFromJson(context, weatherResponse);
            if (weatherValues == null || weatherValues.length == 0) return;

//      TODO (4) If we have valid results, delete the old data and insert the new

        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
