package com.sample.eldroidacts;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import com.google.android.material.navigation.NavigationView;


public class MainActivity extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Cookie Clicker");
            getSupportActionBar().setSubtitle("Remi");
        }

        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) DrawerLayout drawerLayout = findViewById(R.id.menu_fragment);
        NavigationView navigationView = findViewById(R.id.nav_view);

        View headerView = navigationView.getHeaderView(0);
        ImageView profileImage = headerView.findViewById(R.id.profile_image);
        TextView headerTitle = headerView.findViewById(R.id.header_title);
        TextView headerSubtitle = headerView.findViewById(R.id.header_subtitle);

        headerTitle.setText("Remilia");
        headerSubtitle.setText("Cookie Clicker Master");

        loadFragment(new FirstFragment());
    }


    void loadFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.drawer_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.menu_fragment) {
            loadFragment(new FirstFragment());
            return true;
        } else if (id == R.id.menu_dialog) {
            DialogFragment dialog = new MenuDialogFragment();
            dialog.show(getSupportFragmentManager(), "Reset");
            return true;
        } else if (id == R.id.menu_exit) {
            finishAffinity();
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }
}
