package com.sample.eldroidacts;

import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;

public class MainActivity extends FragmentActivity implements HeadlineListFragment.OnHeadlineSelectedListener {

    private int[] newsImages = {
            R.drawable.ic_launcher_background,
            R.drawable.ic_launcher_background,
            R.drawable.ic_launcher_background,
            R.drawable.ic_launcher_background,
            R.drawable.ic_launcher_background
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Check if we're in two-pane mode (landscape)
        if (findViewById(R.id.fragment_news_content) != null) {
            // Add the news content fragment to the layout in landscape mode
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_news_content, NewsContentFragment.newInstance(0, "Select a headline", R.drawable.ic_launcher_background))
                    .commit();
        }
    }

    @Override
    public void onHeadlineSelected(int position, String content) {
        NewsContentFragment newsContentFragment = (NewsContentFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_news_content);

        if (newsContentFragment != null) {
            // Update fragment in landscape mode
            newsContentFragment = NewsContentFragment.newInstance(position, content, newsImages[position]);
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_news_content, newsContentFragment)
                    .commit();
        } else {
            // Replace the fragment in portrait mode
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_headlines, NewsContentFragment.newInstance(position, content, newsImages[position]))
                    .addToBackStack(null)
                    .commit();
        }
    }
}
