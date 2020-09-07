package fr.aboucorp.freenote.views.fragments;

import android.os.Bundle;

import androidx.navigation.Navigation;
import androidx.preference.PreferenceFragmentCompat;

import fr.aboucorp.freenote.R;
import fr.aboucorp.freenote.views.activities.MainActivity;

public class SettingsFragment extends PreferenceFragmentCompat {
    public static final String NOTE_LAYOUT = "notes_layout";

    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        setPreferencesFromResource(R.xml.settings, rootKey);
    }
}