package com.example.android.sunshine;

import android.content.SharedPreferences;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.os.Bundle;
import android.support.v7.preference.CheckBoxPreference;
import android.support.v7.preference.ListPreference;
import android.support.v7.preference.Preference;
import android.support.v7.preference.PreferenceFragmentCompat;
import android.support.v7.preference.PreferenceScreen;

/**
 * Created by geeksploit on 19.12.2017.
 */

public class SettingsFragment extends PreferenceFragmentCompat
        implements OnSharedPreferenceChangeListener {
    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        addPreferencesFromResource(R.xml.preferences_general);

        PreferenceScreen preferenceScreen = getPreferenceScreen();
        SharedPreferences sharedPreferences = preferenceScreen.getSharedPreferences();
        int preferencesCount = preferenceScreen.getPreferenceCount();
        for (int i = 0; i < preferencesCount; i++) {
            Preference preference = preferenceScreen.getPreference(i);
            if (preference instanceof CheckBoxPreference) continue;

            String key = preference.getKey();
            String value = sharedPreferences.getString(key, "");
            setPreferenceSummary(preference, value);
        }
    }

    void setPreferenceSummary(Preference preference, Object value) {
        String stringValue = value.toString();

        if (preference instanceof ListPreference) {
            ListPreference listPreference = (ListPreference) preference;
            int valueIndex = listPreference.findIndexOfValue(stringValue);
            if (valueIndex >= 0) {
                CharSequence summary = listPreference.getEntries()[valueIndex];
                listPreference.setSummary(summary);
            }
        } else {
            preference.setSummary(stringValue);
        }
    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
        Preference preference = findPreference(key);
        if (preference == null) return;
        if (preference instanceof CheckBoxPreference) return;

        String value = sharedPreferences.getString(key, "");
        setPreferenceSummary(preference, value);
    }

    @Override
    public void onStart() {
        super.onStart();
        getPreferenceScreen().getSharedPreferences()
                .registerOnSharedPreferenceChangeListener(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        getPreferenceScreen().getSharedPreferences()
                .unregisterOnSharedPreferenceChangeListener(this);
    }
}