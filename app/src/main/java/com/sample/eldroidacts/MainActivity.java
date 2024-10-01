package com.sample.eldroidacts;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.DialogFragment;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        View headerView = navigationView.getHeaderView(0);
        TextView headerTitle = headerView.findViewById(R.id.header_title);
        TextView headerSubtitle = headerView.findViewById(R.id.header_subtitle);

        navigationView.inflateMenu(R.menu.drawer_menu);
        Log.d("Menu", "Menu items count: " + navigationView.getMenu().size());

        headerTitle.setText("Your Title");
        headerSubtitle.setText("Your Subtitle");

        // Setup ActionBarDrawerToggle
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.drawer_open, R.string.drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new FirstFragment()).commit();
            navigationView.setCheckedItem(R.id.nav_first_menu);
        }

    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        if (item.getItemId() == R.id.nav_first_menu) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new FirstFragment()).commit();
        } else if (item.getItemId() == R.id.nav_dialog) {
            showDialog();
        } else if (item.getItemId() == R.id.nav_exit) {
            finish();
        }
        drawerLayout.closeDrawers();
        return true;
    }


    private void showDialog() {
        DialogFragment dialog = new MenuDialogFragment();
        dialog.show(getSupportFragmentManager(), "Menu Dialog");
    }
}
