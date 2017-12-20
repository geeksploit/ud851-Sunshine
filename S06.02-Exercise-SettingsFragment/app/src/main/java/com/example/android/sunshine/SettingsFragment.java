package com.example.android.sunshine;

import android.os.Bundle;
import android.support.v7.preference.ListPreference;
import android.support.v7.preference.Preference;
import android.support.v7.preference.PreferenceFragmentCompat;

/**
 * Created by geeksploit on 19.12.2017.
 */

public class SettingsFragment extends PreferenceFragmentCompat {
    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        addPreferencesFromResource(R.xml.preferences_general);
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
}
