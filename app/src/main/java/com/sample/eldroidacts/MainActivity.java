package com.sample.eldroidacts;

import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;

public class MainActivity extends FragmentActivity implements HeadlineListFragment.OnHeadlineSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Check if we're in two-pane mode (landscape)
        if (findViewById(R.id.fragment_news_content) != null) {
            // Add the news content fragment to the layout in landscape mode
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_news_content, NewsContentFragment.newInstance(0))
                    .commit();
        }
    }

    @Override
    public void onHeadlineSelected(int position) {
        NewsContentFragment newsContentFragment = (NewsContentFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_news_content);

        if (newsContentFragment != null) {
            // If fragment is available in landscape mode, update it.
            newsContentFragment = NewsContentFragment.newInstance(position);
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_news_content, newsContentFragment)
                    .commit();
        } else {
            // If we are in portrait mode, start a new fragment transaction
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_headlines, NewsContentFragment.newInstance(position))
                    .addToBackStack(null)
                    .commit();
        }
    }
}

