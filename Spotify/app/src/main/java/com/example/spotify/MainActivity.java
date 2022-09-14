package com.example.spotify;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.app.SearchManager;
import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.example.spotify.Adapter.SearchAdapter;
import com.example.spotify.Fragment.LibsFragment;
import com.example.spotify.Fragment.PremiumFragment;
import com.example.spotify.Fragment.SearchFragment;
import com.example.spotify.category.CategoryFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView btmNav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btmNav = findViewById(R.id.bot_nav);

        loadFragment(new CategoryFragment());

        btmNav.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment;
                switch (item.getItemId()){
                    case R.id.item_home:
                        fragment = new CategoryFragment();
                        loadFragment(fragment);
                        break;
                    case R.id.item_search:
                        fragment = new SearchFragment();
                        loadFragment(fragment);
                        break;
                    case R.id.libs_item:
                        fragment = new LibsFragment();
                        loadFragment(fragment);
                        break;
                    case R.id.premium_item:
                        fragment = new PremiumFragment();
                        loadFragment(fragment);
                        break;
                }
                return true;
            }
        });
    }


    private void loadFragment(Fragment fragment) {
        // load fragment
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.content_frame, fragment);
        transaction.commit();
    }
}