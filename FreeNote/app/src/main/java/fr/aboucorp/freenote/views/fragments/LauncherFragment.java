package fr.aboucorp.freenote.views.fragments;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.preference.PreferenceManager;


import fr.aboucorp.freenote.R;

public class LauncherFragment extends Fragment implements SharedPreferences.OnSharedPreferenceChangeListener{
    private String noteLayout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState
    ) {
        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(getContext());
        sharedPref.registerOnSharedPreferenceChangeListener(this);
        this.noteLayout = sharedPref.getString("notes_disposition","grid");
        return inflater.inflate(R.layout.fragment_notes_grid, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (noteLayout.toLowerCase().equals("grid")) {
            NavHostFragment.findNavController(LauncherFragment.this)
                    .navigate(R.id.action_launcherFragment_to_noteGridFragment);
        } else if (noteLayout.toLowerCase().equals("list")) {
            NavHostFragment.findNavController(LauncherFragment.this)
                    .navigate(R.id.action_launcherFragment_to_noteListFragment);
        }
    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
        if (key.equals("notes_disposition")) {
            this.noteLayout = sharedPreferences.getString(key, "");
            /*if (noteLayout.toLowerCase().equals("grid")) {
                NavHostFragment.findNavController(LauncherFragment.this)
                        .navigate(R.id.action_launcherFragment_to_noteGridFragment);
            } else if (noteLayout.toLowerCase().equals("list")) {
                NavHostFragment.findNavController(LauncherFragment.this)
                        .navigate(R.id.action_launcherFragment_to_noteListFragment);
            }*/
        }
    }
}
