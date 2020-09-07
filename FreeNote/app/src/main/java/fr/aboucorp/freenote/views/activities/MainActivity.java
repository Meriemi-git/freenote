package fr.aboucorp.freenote.views.activities;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.preference.PreferenceManager;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;

import fr.aboucorp.freenote.R;
import fr.aboucorp.freenote.views.fragments.LauncherFragment;
import fr.aboucorp.freenote.views.fragments.NoteListFragment;
import fr.aboucorp.freenote.views.fragments.NoteGridFragment;
import fr.aboucorp.freenote.views.fragments.SettingsFragment;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            Navigation.findNavController(MainActivity.this, R.id.nav_host_fragment)
                    .navigate(R.id.action_global_settingsFragment);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onSupportNavigateUp() {
        return  Navigation.findNavController(MainActivity.this, R.id.nav_host_fragment).navigateUp();
    }

    @Override
    public void onBackPressed() {
        NavController controller = Navigation.findNavController(MainActivity.this, R.id.nav_host_fragment);
        NavBackStackEntry back = controller.getCurrentBackStackEntry();
        if(controller.getPreviousBackStackEntry().getDestination().getId() == R.id.settingsFragment){
            Navigation.findNavController(MainActivity.this, R.id.nav_host_fragment)
                    .navigate(R.id.launcherFragment);
        }
        if(controller.getPreviousBackStackEntry().getDestination().getId() == R.id.noteListFragment || controller.getPreviousBackStackEntry().getDestination().getId() == R.id.noteGridFragment){
            Navigation.findNavController(MainActivity.this, R.id.nav_host_fragment)
                    .navigate(R.id.launcherFragment);
        }else{
            Navigation.findNavController(MainActivity.this, R.id.nav_host_fragment)
                    .navigate(controller.getPreviousBackStackEntry().getDestination().getId());
        }
    }
}