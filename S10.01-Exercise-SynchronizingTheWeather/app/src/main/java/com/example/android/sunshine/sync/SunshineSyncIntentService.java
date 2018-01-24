package com.example.android.sunshine.sync;

import android.app.IntentService;

// COMPLETED (5) Create a new class called SunshineSyncIntentService that extends IntentService
class SunshineSyncIntentService extends IntentService {
    // COMPLETED (6) Create a constructor that calls super and passes the name of this class
    public SunshineSyncIntentService() {
        super(SunshineSyncIntentService.class.getName());
    }
//  TODO (7) Override onHandleIntent, and within it, call SunshineSyncTask.syncWeather
}
